package com.phydf.outsourceserver.connect;

import java.io.*;
import java.net.Socket;

public class FileConnect extends Thread {

    private Socket socket;

    private byte[] head;
    private byte[] content;
    private String contentstr;
    private byte[] bytes = new byte[1024 * 1024];

    private InputStream inputStream;
    private OutputStream outputStream;
    private File file;
    private FileInputStream fileInputStream;
    private FileOutputStream fileOutputStream;
    private int min;
    private int max;
    private String sub;

    public FileConnect(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {

        super.run();
        try {

            inputStream = socket.getInputStream();
            inputStream.read(head);
            content = new byte[Integer.parseInt(new String(head))];
            inputStream.read(content);
            contentstr = new String(content);

            min = contentstr.indexOf("file") + 6;
            max = contentstr.indexOf("]") - 1;
            sub = contentstr.substring(min, max);

            if (contentstr.indexOf("up") == 1) {
                if (contentstr.indexOf("up_contract") == 1) {
                    file = new File("C:/contrat/" + sub);
                } else if (contentstr.indexOf("up_secret") == 1) {
                    file = new File("C:/secret/" + sub);
                } else if (contentstr.indexOf("up_resource") == 1) {
                    file = new File("C:/resource/" + sub);
                } else if (contentstr.indexOf("up_cloud") == 1) {
                    file = new File("C:/cloud/" + sub);
                }
                fileOutputStream = new FileOutputStream(file);
                while (inputStream.read(bytes) != -1) {
                    fileOutputStream.write(bytes);
                }
            } else {
                if (contentstr.indexOf("down_resource") == 1) {
                    file = new File("C:/resource/" + sub);
                } else if (contentstr.indexOf("down_cloud") == 1) {
                    file = new File("C:/cloud/" + sub);
                }
                fileInputStream = new FileInputStream(file);
                while (fileInputStream.read(bytes) != -1) {
                    outputStream.write(bytes);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
