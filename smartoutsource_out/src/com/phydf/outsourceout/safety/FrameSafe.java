package com.phydf.outsourceout.safety;

import javax.swing.*;
import java.awt.*;

public class FrameSafe extends JFrame {

    public FrameSafe(){

        setSize(getToolkit().getScreenSize());
        setUndecorated(true);
        setLayout(new FlowLayout(FlowLayout.CENTER,200,0));
        getContentPane().setBackground(Color.BLACK);

        JLabel jLabel = new JLabel("δ��⵽��Ȩ����",SwingConstants.CENTER);
        JLabel jLabel1 = new JLabel("���зǷ���������",SwingConstants.CENTER);

        jLabel.setFont(new Font("΢���ź�",Font.PLAIN,100));
        jLabel.setForeground(Color.YELLOW);

        jLabel1.setFont(new Font("΢���ź�",Font.PLAIN,100));
        jLabel1.setForeground(Color.YELLOW);

        JLabel jLabel2 = new JLabel();
        jLabel2.setPreferredSize(new Dimension(800,400));

        getContentPane().add(jLabel2);
        getContentPane().add(jLabel);
        getContentPane().add(jLabel1);

        validate();

    }

}
