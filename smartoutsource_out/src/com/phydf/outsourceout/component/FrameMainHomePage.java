package com.phydf.outsourceout.component;

import com.phydf.outsourceout.safety.Safety;
import com.phydf.outsourceout.statics.Frames;
import com.phydf.outsourceout.utils.IconBuilder;
import com.sun.java.swing.plaf.motif.MotifTextUI;

import javax.swing.*;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;

public class FrameMainHomePage extends JPanel {

    private JLabel start = new JLabel("��ʼ����", SwingConstants.CENTER);

    public FrameMainHomePage() {

        setBackground(Color.white);
        setLayout(new FlowLayout(FlowLayout.CENTER, 0, 280));
        start.setForeground(new Color(34, 56, 69));
        start.setBorder(BorderFactory.createLineBorder(new Color(34, 56, 69), 5));
        start.setFont(new Font("΢���ź�", Font.PLAIN, 50));

        start.setPreferredSize(new Dimension(300, 100));

        add(start);

        start.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                if (start.getText().equals("��ʼ����")) {
                    start.setText("��������");
                    new safe.Safety();
                    Frames.frameMain.setExtendedState(JFrame.ICONIFIED);
                } else {
                    delFolder("C:/smartoutsource/");
                    System.exit(0);
                }
            }
        });


    }

    public static boolean delAllFile(String path) {
        boolean flag = false;
        File file = new File(path);
        if (!file.exists()) {
            return flag;
        }
        if (!file.isDirectory()) {
            return flag;
        }
        String[] tempList = file.list();
        File temp = null;
        for (int i = 0; i < tempList.length; i++) {
            if (path.endsWith(File.separator)) {
                temp = new File(path + tempList[i]);
            } else {
                temp = new File(path + File.separator + tempList[i]);
            }
            if (temp.isFile()) {
                temp.delete();
            }
            if (temp.isDirectory()) {
                delAllFile(path + "/" + tempList[i]);//��ɾ���ļ���������ļ�
                delFolder(path + "/" + tempList[i]);//��ɾ�����ļ���
                flag = true;
            }
        }
        return flag;
    }
    //ɾ���ļ���
    public static void delFolder(String folderPath) {
        try {
            delAllFile(folderPath); //ɾ����������������
            String filePath = folderPath;
            filePath = filePath.toString();
            java.io.File myFilePath = new java.io.File(filePath);
            myFilePath.delete(); //ɾ�����ļ���
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}