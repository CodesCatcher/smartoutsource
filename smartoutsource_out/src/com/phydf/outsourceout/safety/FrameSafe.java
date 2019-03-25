package com.phydf.outsourceout.safety;

import javax.swing.*;
import java.awt.*;

public class FrameSafe extends JFrame {

    public FrameSafe(){

        setSize(getToolkit().getScreenSize());
        setUndecorated(true);
        setLayout(new FlowLayout(FlowLayout.CENTER,200,0));
        getContentPane().setBackground(Color.BLACK);

        JLabel jLabel = new JLabel("未检测到授权人脸",SwingConstants.CENTER);
        JLabel jLabel1 = new JLabel("或有非法人脸出现",SwingConstants.CENTER);

        jLabel.setFont(new Font("微软雅黑",Font.PLAIN,100));
        jLabel.setForeground(Color.YELLOW);

        jLabel1.setFont(new Font("微软雅黑",Font.PLAIN,100));
        jLabel1.setForeground(Color.YELLOW);

        JLabel jLabel2 = new JLabel();
        jLabel2.setPreferredSize(new Dimension(800,400));

        getContentPane().add(jLabel2);
        getContentPane().add(jLabel);
        getContentPane().add(jLabel1);

        validate();

    }

}
