package com.phydf.outsourceout.factory;

import com.phydf.outsourceout.control.MessageListener;
import com.phydf.outsourceout.control.StringMessageControl;
import com.phydf.outsourceout.service.LoginService;
import com.phydf.outsourceout.service.LoginServiceImp;
import com.phydf.outsourceout.service.SearchWorkerService;
import com.phydf.outsourceout.service.SearchWorkerServiceImp;

public class ClientFactory {

    public LoginService getLoginService() {
        return new LoginServiceImp();
    }

    public SearchWorkerService getSearchService() {
        return new SearchWorkerServiceImp();
    }

    public MessageListener getStringMessageControl() {
        return new StringMessageControl();
    }

}
