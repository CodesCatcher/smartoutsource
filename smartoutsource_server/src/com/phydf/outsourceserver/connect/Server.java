package com.phydf.outsourceserver.connect;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server {

    /**
     * stringServerSocket
     */
    private ServerSocket stringServerSocket;

    /**
     * stringSocket
     */
    private Socket stringSocket;

    /**
     * fileServerSocket
     */
    private ServerSocket fileServerSocket;

    /**
     * fileSocket
     */
    private Socket fileSocket;


    public Server() {
    }

    public void start() {

        try {
            stringServerSocket = new ServerSocket(7777);
            fileServerSocket = new ServerSocket(8888);
        } catch (IOException e) {
            e.printStackTrace();
        }

        Thread stringThread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    while (true) {
                        stringSocket = stringServerSocket.accept();
                        StringConnect stringConnect = new StringConnect(stringSocket);
                        stringConnect.start();
                        Thread.sleep(1);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        stringThread.start();

        Thread fileThread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    while (true) {
                        fileSocket = fileServerSocket.accept();
                        FileConnect fileConnect = new FileConnect(fileSocket);
                        fileConnect.start();
                        Thread.sleep(1);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        fileThread.start();
    }

}
