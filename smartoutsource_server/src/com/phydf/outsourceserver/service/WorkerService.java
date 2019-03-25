package com.phydf.outsourceserver.service;

import java.net.Socket;

public interface WorkerService {

    void loginQR(Socket socket);

    void mobileLogin(String info, Socket socket);

    void pcLogin(String info, Socket socket);

    void register(String info,Socket socket);

}
