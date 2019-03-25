package com.phydf.outsourceserver.service;

import java.net.Socket;

public interface AdminService {

    void login(String info, Socket socket);

    void searchHome(String info, Socket socket);

    void searchProject(String info, Socket socket);

    void searchWorker(String info, Socket socket);

    void searchJournal(String info, Socket socket);

}
