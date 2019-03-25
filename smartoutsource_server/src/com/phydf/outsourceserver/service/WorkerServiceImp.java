package com.phydf.outsourceserver.service;

import com.phydf.outsourceserver.bean.Worker;
import com.phydf.outsourceserver.dao.WorkerDao;
import com.phydf.outsourceserver.factory.ServerFactory;
import com.phydf.outsourceserver.utils.RegisterSMS;

import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.List;

public class WorkerServiceImp implements WorkerService {

    HashMap<String, Socket> QRmap = new HashMap<>();

    @Override
    public void loginQR(Socket socket) {

        PrintWriter writer;

        try {
            QRmap.put(socket.hashCode() + "", socket);
            writer = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), Charset.forName("gb2312"))
                    , true);
            writer.println("{worker_loginQR[hashcode:\"" + socket.hashCode() + "\"]}");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public void mobileLogin(String info, Socket socket) {

        int min, max;
        PrintWriter writer = null;
        ServerFactory serverFactory = new ServerFactory();
        WorkerDao workerDao = serverFactory.getWorkerDao();

        try {
            writer = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()
                    , Charset.forName("gb2312")), true);
        } catch (Exception e) {
            e.printStackTrace();
        }

        String account, password;
        min = info.indexOf("account") + 9;
        max = info.indexOf("password") - 2;
        account = info.substring(min, max);
        min = info.indexOf("password") + 10;
        max = info.indexOf("]}") - 1;
        password = info.substring(min, max);

        List<Worker> workerList = workerDao.searchWorker("Aphone", account);

        if (workerList.size() != 0) {
            if (workerList.get(0).getPass().equals(password)) {
                writer.println("{login_success[id:\"" + workerList.get(0).getId()
                        + "\",name:\"" + workerList.get(0).getName() + "\"]}");
                return;
            } else {
                writer.println("{login_fail[code:\"wrongpass\"]}");
            }
        } else {
            writer.println("{login_fail[code:\"wrongaccount\"]}");
        }

    }

    /**
     * 此报文是手机端发送的，服务器通过info在哈希表中查看对应的电脑端socket，手机端确认登录后，电脑端打开。
     *
     * @param info
     * @param socket
     */
    @Override
    public void pcLogin(String info, Socket socket) {

    }

    @Override
    public void register(String info, Socket socket) {

        int min, max;
        PrintWriter writer = null;
        ServerFactory serverFactory = new ServerFactory();
        WorkerDao workerDao = serverFactory.getWorkerDao();

        try {
            writer = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()
                    , Charset.forName("gb2312")), true);
        } catch (Exception e) {
            e.printStackTrace();
        }

        String phone;
        min = info.indexOf("telephone") + 11;
        max = info.indexOf("]") - 1;

        phone = info.substring(min, max);

        System.out.println("{worker_register[result:\"ok\",(verification_code:\"" + RegisterSMS.registerMessage(phone) + "\")]}");
    }


    public static void main(String[] args) {

        new WorkerServiceImp().register("{worker_register:[telephone:\"15867874250\"]}",new Socket());
    }
}
