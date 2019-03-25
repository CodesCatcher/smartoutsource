package com.phydf.outsourceout.safety;

import com.baidu.aip.face.AipFace;
import com.phydf.outsourceout.frames.FrameLogin;
import com.phydf.outsourceout.frames.MsgBox;
import com.phydf.outsourceout.statics.Frames;
import com.phydf.outsourceout.utils.mat2BufferedImage;
import org.json.JSONObject;
import org.opencv.core.Mat;
import org.opencv.videoio.VideoCapture;

import javax.imageio.ImageIO;
import java.io.*;
import java.util.HashMap;

public class Safety {

    static {
        try {
            loadLib("opencv_java341");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private VideoCapture camera;
    private AipFace client;
    private Mat mat = new Mat();
    private ByteArrayOutputStream byteArray;

    public Safety() {

        client = new AipFace("11136860", "vkqAfGP1VKz3hWASKmNqTHTV",
                "kHfdvej2EgWxleSZhGA5ltIEOfVQFjAi");
    }

    private synchronized static void loadLib(String libName) throws IOException {

        String systemType = System.getProperty("os.name");
        System.out.println(systemType);
        String libExtension = (systemType.toLowerCase().indexOf("win") != -1) ? ".dll" : ".so";

        String libFullName = libName + libExtension;
        String nativeTempDir = System.getProperty("java.io.tmpdir");
        System.out.println(nativeTempDir);

        InputStream in = null;
        BufferedInputStream reader = null;
        FileOutputStream writer = null;

        File extractedLibFile = new File(nativeTempDir + File.separator + libFullName);

        if (!extractedLibFile.exists()) {
            try {
                in = FrameLogin.class.getClassLoader().getResourceAsStream("libs/" + libFullName);
                if (in == null)
                    in = FrameLogin.class.getResourceAsStream(libFullName);
                FrameLogin.class.getResource(libFullName);
                reader = new BufferedInputStream(in);
                writer = new FileOutputStream(extractedLibFile);

                byte[] buffer = new byte[1024];

                while (reader.read(buffer) > 0) {
                    writer.write(buffer);
                    buffer = new byte[1024];
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (in != null)
                    in.close();
                if (writer != null)
                    writer.close();
            }
        }

        System.load(extractedLibFile.toString());
    }

    public void openCamera() {

        camera = new VideoCapture();
        camera.open(0);

        if (camera.isOpened() != true) {
            MsgBox.show("未检测到摄像头，系统无法开始工作！");
            System.exit(-1);
        }

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {

                while (true) {
                    camera.read(mat);
                    byteArray = new ByteArrayOutputStream();

                    try {
                        ImageIO.write(mat2BufferedImage.matToBufferedImage(mat), "JPEG", byteArray);

                        byteArray.close();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                }
            }
        });
        thread.start();
    }

    public void judge(AipFace client, byte[] bytes) {

        HashMap<String, String> options = new HashMap<String, String>();
        options.put("ext_fields", "faceliveness");
        options.put("user_top_num", "1");

        String groupId = "outSource";

        JSONObject res = client.identifyUser(groupId, bytes, options);

        try {
            if (getResultNumber(res) == 1 && getName(res).equals("fuenhui")
                    && getScores(res) > 50) {
                Frames.frameSafe.setVisible(false);
            } else {
                Frames.frameSafe.setVisible(true);
            }
        } catch (Exception e) {
            Frames.frameSafe.setVisible(true);
        }

    }

    public int getScores(JSONObject res) {


        String s = res.getJSONArray("result")
                .getJSONObject(0).get("scores").toString();

        int i = s.indexOf('[');
        int j = s.indexOf('.');

        s = s.substring(i + 1, j);

        System.out.println(s);

        return Integer.parseInt(s);
    }

    public String getName(JSONObject res) {

        System.out.println(res.getJSONArray("result").getJSONObject(0).get("uid").toString());
        return res.getJSONArray("result").getJSONObject(0).get("uid").toString();
    }

    public int getResultNumber(JSONObject res) {
        return Integer.parseInt(res.get("result_num").toString());
    }

    public static void main(String[] args) {
        Safety safety = new Safety();
        safety.openCamera();
    }

}
