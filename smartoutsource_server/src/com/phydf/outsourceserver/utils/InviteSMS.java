package com.phydf.outsourceserver.utils;

import com.submail.utils.RequestEncoder;
import net.sf.json.JSONObject;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.Map;
import java.util.Random;
import java.util.TreeMap;

public class InviteSMS {

    /**
     * ʱ����ӿ�����
     */
    public static final String TIMESTAMP = "https://api.mysubmail.com/service/timestamp";
    /**
     * ���ýӿ�
     * http://api.mysubmail.com/service/timestamp
     * https://api.submail.cn/service/timestamp
     * http://api.submail.cn/service/timestamp
     */

    public static final String TYPE_MD5 = "md5";
    public static final String TYPE_SHA1 = "sha1";
    /**
     * API ����ӿ�����
     */
    private static final String URL = "https://api.mysubmail.com/message/xsend";

    /*
    public static String RegisterMessage(String phone){
        Random r = new Random();
        String code = "";

        while (code.length() < 6) {
            code = code + r.nextInt(10);
        }
        return code;
    }*/
    public static void inviteMessage(String phone,String code) {

        TreeMap<String, Object> requestData = new TreeMap<String, Object>();
        JSONObject vars = new JSONObject();
        /**
         * --------------------------------��������------------------------------------
         * ����ϸ�Ķ���������˵��
         *
         * ���ò������� appid, appkey ,to ,project, signtype, 	vars
         * appid, appkey, to, project Ϊ�������
         * ����� submail ������������ȡ appid �� appkey�����ӣ�https://www.mysubmail.com/chs/sms/apps
         * ����� submail ����������ȡ��Ŀ��ʶ project_id�����ӣ�https://www.mysubmail.com/chs/sms/templates
         * ��λ�ȡ��Ŀ��ʶ project ���������ӣ�https://www.mysubmail.com/chs/documents/developer/MmSw12
         * vars����
         * ���� vars.put("code", "123456"), ���� code ��Ӧ����ģ���е� @var(code) ����
         * signtype Ϊ��ѡ����: normal | md5 | sha1
         * �� signtype ����Ϊ��ʱ��Ĭ��Ϊ normal
         *  --------------------------------------------------------------------------
         */
        String appid = "14228";
        String appkey = "355a45b608e9a567b6dd94ea477863d9";
        String to = phone;
        String project = "d3u17";
        String signtype = "";

        vars.put("yzm", code);
        /**
         *  ---------------------------------------------------------------------------
         */

        /**
         *  ǩ����֤��ʽ
         *  ��ϸ˵���ɲο� SUBMAIL �����������ĵ� �� ��ʼ �� API ��Ȩ����֤����
         */
        requestData.put("appid", appid);
        requestData.put("project", project);
        requestData.put("to", to);
        if (!vars.isEmpty()) {
            requestData.put("vars", vars.toString());
        }
        MultipartEntityBuilder builder = MultipartEntityBuilder.create();
        @SuppressWarnings("deprecation")
        ContentType contentType = ContentType.create(HTTP.PLAIN_TEXT_TYPE, HTTP.UTF_8);
        for (Map.Entry<String, Object> entry : requestData.entrySet()) {
            String key = entry.getKey();
            Object value = entry.getValue();
            if (value instanceof String) {
                builder.addTextBody(key, String.valueOf(value), contentType);
            }
        }
        if (signtype.equals(TYPE_MD5) || signtype.equals(TYPE_SHA1)) {
            String timestamp = getTimestamp();
            requestData.put("timestamp", timestamp);
            requestData.put("sign_type", signtype);
            String signStr = appid + appkey + RequestEncoder.formatRequest(requestData) + appid + appkey;

            builder.addTextBody("timestamp", timestamp);
            builder.addTextBody("sign_type", signtype);
            builder.addTextBody("signature", RequestEncoder.encode(signtype, signStr), contentType);
        } else {
            builder.addTextBody("signature", appkey, contentType);
        }
        /**
         * http post ����ӿ�
         * �ɹ����� status: success,���� fee ����Ϊ���ŷ��� ��credits ����Ϊʣ��������
         * ��ϸ�� API ������־����� SUBMAIL ���� �� �����ĵ� �� DEBUG �� API �������
         */
        HttpPost httpPost = new HttpPost(URL);
        httpPost.addHeader("charset", "UTF-8");
        httpPost.setEntity(builder.build());
        try {
            CloseableHttpClient closeableHttpClient = HttpClientBuilder.create().build();
            HttpResponse response = closeableHttpClient.execute(httpPost);
            HttpEntity httpEntity = response.getEntity();
            if (httpEntity != null) {
                String jsonStr = EntityUtils.toString(httpEntity, "UTF-8");
                System.out.println(jsonStr);
            }
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * ��ȡʱ���
     *
     * @return
     */
    private static String getTimestamp() {
        CloseableHttpClient closeableHttpClient = HttpClientBuilder.create().build();
        HttpGet httpget = new HttpGet(TIMESTAMP);
        try {
            HttpResponse response = closeableHttpClient.execute(httpget);
            HttpEntity httpEntity = response.getEntity();
            String jsonStr = EntityUtils.toString(httpEntity, "UTF-8");
            if (jsonStr != null) {
                JSONObject json = JSONObject.fromObject(jsonStr);
                return json.getString("timestamp");
            }
            closeableHttpClient.close();
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

}
