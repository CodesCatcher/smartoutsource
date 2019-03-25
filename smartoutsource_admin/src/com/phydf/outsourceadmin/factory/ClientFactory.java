package com.phydf.outsourceadmin.factory;


import com.phydf.outsourceadmin.control.FileMessageControl;
import com.phydf.outsourceadmin.control.MessageListener;
import com.phydf.outsourceadmin.control.StringMessageControl;
import com.phydf.outsourceadmin.service.*;

public class ClientFactory {

    public LoginService getLoginService() {
        return new LoginServiceImp();
    }

    public SearchService getSearchService() {
        return new SearchServiceImp();
    }

    public DynamicService getDynamicService() {
        return new DynamicServiceImp();
    }

    public MessageListener getStringMessageControl() {
        return new StringMessageControl();
    }

    public MessageListener getFileMessageControl() {
        return new FileMessageControl();
    }
}
