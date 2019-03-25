package com.phydf.outsourceserver.control;

import com.phydf.outsourceserver.factory.ServerFactory;
import com.phydf.outsourceserver.service.AdminService;

import java.net.Socket;

public class StringMessageControl implements MessageListener {

    int min, max;
    String FinalData;
    String ss;
    ServerFactory serverFactory = new ServerFactory();
    AdminService adminService = serverFactory.getAdminService();

    @Override
    public void onGetMessage(String s, Socket socket) {

        while (s.length() != 0) {

            min = s.indexOf("{", 0) + 1;
            max = s.indexOf("}", 0);

            FinalData = "{" + s.substring(min, max) + "}";

            if (max != s.length()) {
                s = s.substring(max + "}".length(), s.length());
            } else {
                s = "";
            }

            if (FinalData.indexOf("admin_login") == 1) {
                adminService.login(FinalData, socket);
            } else if (FinalData.indexOf("admin_searchHome") == 1) {
                adminService.searchHome(FinalData, socket);
            } else if (FinalData.indexOf("admin_searchProject") == 1) {
                adminService.searchProject(FinalData, socket);
            } else if (FinalData.indexOf("admin_searchWorker") == 1) {
                adminService.searchWorker(FinalData, socket);
            } else if (FinalData.indexOf("admin_searchJournal") == 1) {
                adminService.searchJournal(FinalData, socket);
            } else if (FinalData.indexOf("worker_login")==1){

            }

        }
    }
}
