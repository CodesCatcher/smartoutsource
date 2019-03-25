package com.phydf.outsourceadmin.connect;

import java.io.*;
import java.net.Socket;

public class FileConnect {

    private Socket socket;
    private String host;
    private int port;
    private InputStream inputStream;
    private OutputStream outputStream;
    private FileInputStream fileInputStream;
    private FileOutputStream fileOutputStream;
    private File file;
    private int min;
    private int max;
    private String sub;

    private byte[] head;
    private byte[] content;
    private String contentstr;
    private byte[] bytes = new byte[1024 * 1024];

    public void connect() {

        try {
            socket = new Socket(host, port);
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        inputStream = socket.getInputStream();
                        inputStream.read(head);
                        content = new byte[Integer.parseInt(new String(head))];
                        inputStream.read(content);
                        contentstr = new String(content);

                        min = contentstr.indexOf("file") + 6;
                        max = contentstr.indexOf("]") - 1;
                        sub = contentstr.substring(min, max);

                        if (contentstr.indexOf("down_resource") == 1) {
                            file = new File("C:/smartoutsource/res" + sub);
                        } else if (contentstr.indexOf("down_cloud") == 1) {
                            file = new File("C:/smartoutsource/cloud" + sub);
                        }

                        fileOutputStream = new FileOutputStream(file);

                        while (inputStream.read(bytes) != -1) {
                            fileOutputStream.write(bytes);
                        }

                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
            thread.start();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Socket getSocket() {
        return socket;
    }
}
