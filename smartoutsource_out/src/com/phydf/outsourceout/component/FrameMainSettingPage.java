package com.phydf.outsourceout.component;

import javax.swing.*;
import java.awt.*;

public class FrameMainSettingPage extends JPanel {


    private JLabel accoutname;
    public FrameMainSettingPage(){
        super();

        setPreferredSize(new Dimension(1050, 715));
        setLayout(null);
        setBackground(Color.white);

        LayoutPanel layoutPanel = new LayoutPanel(1,100,Color.darkGray);
        layoutPanel.setBounds(200,120,1,400);

        JLabel account = new JLabel("ÕÊºÅ");
        account.setFont(new Font("Î¢ÈíÑÅºÚ",Font.PLAIN,17));
        account.setBounds(150,150,40,40);
        account.setForeground(Color.RED);

        JLabel info = new JLabel("ÐÅÏ¢");
        info.setFont(new Font("Î¢ÈíÑÅºÚ",Font.PLAIN,17));
        info.setBounds(150,250,40,40);

        JLabel defau = new JLabel("Ä¬ÈÏ");
        defau.setFont(new Font("Î¢ÈíÑÅºÚ",Font.PLAIN,17));
        defau.setBounds(150,350,40,40);

        JLabel work = new JLabel("¹¤×÷");
        work.setFont(new Font("Î¢ÈíÑÅºÚ",Font.PLAIN,17));
        work.setBounds(150,450,40,40);

        JLabel accoutnum = new JLabel("¹¤ºÅ:  1561561655001");
        accoutnum.setFont(new Font("Î¢ÈíÑÅºÚ",Font.PLAIN,17));
        accoutnum.setBounds(420,220,300,40);

        JLabel accoutname = new JLabel("ÓÃ»§Ãû:  UserName");
        accoutname.setFont(new Font("Î¢ÈíÑÅºÚ",Font.PLAIN,17));
        accoutname.setBounds(420,260,300,40);

        JLabel accountlevel = new JLabel("¼¶±ð:  ¿ª·¢ÈËÔ±");
        accountlevel.setFont(new Font("Î¢ÈíÑÅºÚ",Font.PLAIN,17));
        accountlevel.setBounds(420,300,300,40);

        JLabel change = new JLabel("<html><u>ÐÞ¸ÄÕÊºÅÐÅÏ¢</u></html>");
        change.setFont(new Font("Î¢ÈíÑÅºÚ",Font.PLAIN,17));
        change.setBounds(420,340,300,40);

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

    public JLabel getAccoutname() {
        return accoutname;
    }

}
