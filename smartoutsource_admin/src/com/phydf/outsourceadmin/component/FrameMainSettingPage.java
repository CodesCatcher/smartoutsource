package com.phydf.outsourceadmin.component;

import javax.swing.*;
import java.awt.*;

public class FrameMainSettingPage extends JPanel{

    public FrameMainSettingPage(){

        setPreferredSize(new Dimension(1050, 715));
        setLayout(null);
        setBackground(Color.white);

        LayoutPanel layoutPanel = new LayoutPanel(1,100,Color.darkGray);
        layoutPanel.setBounds(300,120,1,400);

        JLabel account = new JLabel("ÕÊºÅ");
        account.setFont(new Font("Î¢ÈíÑÅºÚ",Font.PLAIN,17));
        account.setBounds(250,150,40,40);
        account.setForeground(Color.RED);

        JLabel info = new JLabel("ÐÅÏ¢");
        info.setFont(new Font("Î¢ÈíÑÅºÚ",Font.PLAIN,17));
        info.setBounds(250,250,40,40);

        JLabel defau = new JLabel("Ä¬ÈÏ");
        defau.setFont(new Font("Î¢ÈíÑÅºÚ",Font.PLAIN,17));
        defau.setBounds(250,350,40,40);

        JLabel work = new JLabel("¹¤×÷");
        work.setFont(new Font("Î¢ÈíÑÅºÚ",Font.PLAIN,17));
        work.setBounds(250,450,40,40);

        JLabel accoutnum = new JLabel("¹¤ºÅ:  5051515515301");
        accoutnum.setFont(new Font("Î¢ÈíÑÅºÚ",Font.PLAIN,17));
        accoutnum.setBounds(520,220,300,40);

        JLabel accoutname = new JLabel("ÓÃ»§Ãû:  administrator");
        accoutname.setFont(new Font("Î¢ÈíÑÅºÚ",Font.PLAIN,17));
        accoutname.setBounds(520,260,300,40);

        JLabel accountlevel = new JLabel("¼¶±ð:  ¹ÜÀíÔ±");
        accountlevel.setFont(new Font("Î¢ÈíÑÅºÚ",Font.PLAIN,17));
        accountlevel.setBounds(520,300,300,40);

        JLabel change = new JLabel("<html><u>ÐÞ¸ÄÕÊºÅÐÅÏ¢</u></html>");
        change.setFont(new Font("Î¢ÈíÑÅºÚ",Font.PLAIN,17));
        change.setBounds(520,340,300,40);

        add(account);
        add(info);
        add(defau);
        add(work);
        add(accoutnum);
        add(accoutname);
        add(accountlevel);
        add(change);
        add(layoutPanel);

    }
}
