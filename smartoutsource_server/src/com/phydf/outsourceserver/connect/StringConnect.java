package com.phydf.outsourceserver.connect;

import com.phydf.outsourceserver.control.MessageListener;
import com.phydf.outsourceserver.factory.ServerFactory;

import java.io.*;
import java.net.Socket;
import java.nio.charset.Charset;

public class StringConnect extends Thread {

    private Socket socket;
    private BufferedReader reader;
    private ServerFactory serverFactory = new ServerFactory();
    private MessageListener stringControl = serverFactory.getStringMessageControl();

    public StringConnect(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        super.run();
        try {
            reader = new BufferedReader(new InputStreamReader(socket.getInputStream(),
                    Charset.forName("GB2312")));
            String s = null;
            while (true) {
                s = reader.readLine();
                System.out.println(s);
                stringControl.onGetMessage(s, socket);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
