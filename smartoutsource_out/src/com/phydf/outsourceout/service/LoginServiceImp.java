package com.phydf.outsourceout.service;

import com.phydf.outsourceout.frames.FrameMain;
import com.phydf.outsourceout.statics.Frames;
import com.phydf.outsourceout.utils.QRFactory;
import com.phydf.outsourceout.frames.FrameLogin;

import javax.swing.*;

public class LoginServiceImp implements LoginService{
    @Override
    public void login(String info) {

        if((info.indexOf("account"))!=-1){
            int min,max;
            min = info.indexOf("account");
            max = info.indexOf("]");

            /*
            Frames.frameMain = new FrameMain();
            Frames.frameMain.getLeftPanel().getAccountTitle().setText("用户名："+info.substring(min+9,max-1));
            Frames.frameMain.getFrameMainSettingPage().getAccoutname().setText("用户名："+info.substring(min+9,max-1));*/
        }
        if((info.indexOf("QRImage"))!=-1){
            int min,max;

            min = info.indexOf("QRImage");
            max = info.indexOf("]");
            Frames.frameLogin.setQrImage(QRFactory.getQRImage(info.substring(min+9,max-2)));
        }


    }
}
