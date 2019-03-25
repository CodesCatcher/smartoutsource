package com.phydf.outsourceadmin.frames;

import javax.swing.*;

public class MsgBox {

    public static void show(String message){
        Object[] options = {"确定"};
        JOptionPane.showOptionDialog(null, message, "智能外包管理平台",
                JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE,
                null, options, options[0]);
    }

    public static boolean ask(String message){

        int i;
        Object[] options = {"同意","不同意"};
        i= JOptionPane.showOptionDialog(null, message, "智能外包管理平台",
                JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE,
                null, options, options[0]);
        if (i==0){
            return true;
        }else {
            return false;
        }
    }
}
