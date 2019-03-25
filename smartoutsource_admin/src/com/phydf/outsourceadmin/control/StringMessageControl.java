package com.phydf.outsourceadmin.control;

import com.phydf.outsourceadmin.factory.ClientFactory;
import com.phydf.outsourceadmin.service.LoginService;
import com.phydf.outsourceadmin.service.SearchService;

public class StringMessageControl implements MessageListener {
    @Override
    public void onGetMessage(String s) {

        int min, max;
        String FinalData;
        String ss;
        ClientFactory clientFactory = new ClientFactory();
        LoginService loginService = clientFactory.getLoginService();
        SearchService searchService = clientFactory.getSearchService();

        while (s.length() != 0) {

            min = s.indexOf("{", 0) + 1;
            max = s.indexOf("}", 0);

            FinalData = "{" + s.substring(min, max) + "}";

            if (max != s.length()) {
                s = s.substring(max + "}".length(), s.length());
            } else {
                s = "";
            }

            System.out.println(FinalData);

            if (FinalData.indexOf("admin_login") == 1) {
                loginService.login(FinalData);
            } else if (FinalData.indexOf("admin_searchHome") == 1) {
                searchService.searchHome(FinalData);
            } else if (FinalData.indexOf("admin_searchProject") == 1) {
                searchService.searchProject(FinalData);
            }else if (FinalData.indexOf("admin_searchJournal")==1){

            }

        }
    }
}
