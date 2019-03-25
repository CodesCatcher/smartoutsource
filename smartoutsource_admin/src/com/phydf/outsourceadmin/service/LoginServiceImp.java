package com.phydf.outsourceadmin.service;

import com.phydf.outsourceadmin.frames.FrameMain;
import com.phydf.outsourceadmin.frames.MsgBox;
import com.phydf.outsourceadmin.statics.Frames;
import com.phydf.outsourceadmin.statics.Varibles;


public class LoginServiceImp implements LoginService {

    @Override
    public void login(String info) {

        int min, max;

        String getresult, getname, getid;

        min = info.indexOf("result") + 8;
        max = info.indexOf("\"", info.indexOf("result") + 8);
        getresult = info.substring(min, max);

        if (getresult.equals("ok")) {

            min = info.indexOf("id") + 4;
            max = info.indexOf("name") - 2;
            getid = info.substring(min, max);
            Varibles.Id = getid;

            min = info.indexOf("name") + 6;
            max = info.indexOf(")") - 1;
            getname = info.substring(min, max);

            Frames.frameMain = new FrameMain();
            Frames.frameMain.useSetTitle(getname);
            Frames.frameLogin.dispose();

        } else if (getresult.equals("err-1")) {

            MsgBox.show("帐号不存在，请检查后重新输入！");

        } else if (getresult.equals("err-2")) {

            MsgBox.show("帐号和密码不匹配，请检查后重新输入！");

        }

    }
}
