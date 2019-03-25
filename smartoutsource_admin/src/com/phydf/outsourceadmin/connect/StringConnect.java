package com.phydf.outsourceadmin.connect;

import com.phydf.outsourceadmin.control.MessageListener;
import com.phydf.outsourceadmin.factory.ClientFactory;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.nio.charset.Charset;

public class StringConnect {

    private Socket socket;
    private String host;
    private int port;
    private PrintWriter writer;
    private BufferedReader reader;
    private ClientFactory clientFactory = new ClientFactory();
    private MessageListener stringControl = clientFactory.getStringMessageControl();

    public void setHost(String host) {
        this.host = host;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public void connect() {

        try {

            socket = new Socket(host, port);
            writer = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), Charset.forName("gb2312")), true);
            reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    String s = null;
                    while (true) {
                        try {
                            s = reader.readLine();
                            stringControl.onGetMessage(s);
                        } catch (Exception e) {
                            e.printStackTrace();
                            break;
                        }
                    }
                }
            });
            thread.start();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void sendMessage(String s) {
        try {
            writer.println(s);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean getState() {
        if (socket.isConnected() == true) {
            return true;
        } else {
            return false;
        }
    }


}
