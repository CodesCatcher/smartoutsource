package com.phydf.outsourceadmin.loader;

import com.phydf.outsourceadmin.connect.StringConnect;
import com.phydf.outsourceadmin.frames.FrameLogin;
import com.phydf.outsourceadmin.statics.Connects;
import com.phydf.outsourceadmin.statics.Frames;

public class Loader {

    public static void main(String[] args) {

        Frames.frameLogin = new FrameLogin();

        Connects.stringConnect = new StringConnect();
        Connects.stringConnect.setHost("www.hualami.com");
        Connects.stringConnect.setPort(7777);
        Connects.stringConnect.connect();

    }
}
