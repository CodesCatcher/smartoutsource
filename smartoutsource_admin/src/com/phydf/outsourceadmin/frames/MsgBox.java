package com.phydf.outsourceadmin.frames;

import javax.swing.*;

public class MsgBox {

    public static void show(String message){
        Object[] options = {"ȷ��"};
        JOptionPane.showOptionDialog(null, message, "�����������ƽ̨",
                JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE,
                null, options, options[0]);
    }

    public static boolean ask(String message){

        int i;
        Object[] options = {"ͬ��","��ͬ��"};
        i= JOptionPane.showOptionDialog(null, message, "�����������ƽ̨",
                JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE,
                null, options, options[0]);
        if (i==0){
            return true;
        }else {
            return false;
        }
    }
}
