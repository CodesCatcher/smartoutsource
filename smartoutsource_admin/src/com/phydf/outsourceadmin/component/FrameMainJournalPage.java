package com.phydf.outsourceadmin.component;

import com.phydf.outsourceadmin.statics.Connects;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class FrameMainJournalPage extends JPanel {

    JLabel search_result = new JLabel("查询结果", SwingConstants.CENTER);//快速查询标题
    JTextField textField = new JTextField();
    JPanel journalJPanel = new JPanel();

    private static int n = 0;
    private static int m = 30;

    public FrameMainJournalPage() {

        setBackground(Color.white);
        search_result.setPreferredSize(new Dimension(1030, 25));
        search_result.setFont(new Font("微软雅黑", Font.PLAIN, 15));
        search_result.setBackground(new Color(153, 180, 209));
        search_result.setOpaque(true);
        setLayout(new FlowLayout(1, 0, 10));
        setPreferredSize(new Dimension(1050, 750));
        add(search_result);
        textField.setPreferredSize(new Dimension(500, 30));
        add(textField);

        JPanel journalTitle = new JPanel();
        journalTitle.setPreferredSize(new Dimension(1030, 30));
        journalTitle.setLayout(new FlowLayout(0, 10, 0));
        journalTitle.setBackground(new Color(200, 200, 200));

        JLabel journalTime = new JLabel("操作时间", SwingConstants.CENTER);
        journalTime.setFont(new Font("微软雅黑", Font.PLAIN, 15));
        journalTime.setPreferredSize(new Dimension(250, 30));

        journalTitle.add(journalTime);

        JLabel journalStaff = new JLabel("操作人员", SwingConstants.CENTER);
        journalStaff.setFont(new Font("微软雅黑", Font.PLAIN, 15));
        journalStaff.setPreferredSize(new Dimension(100, 30));

        journalTitle.add(journalStaff);


        JLabel j_IP = new JLabel("IP", SwingConstants.CENTER);
        j_IP.setFont(new Font("微软雅黑", Font.PLAIN, 15));
        j_IP.setPreferredSize(new Dimension(150, 30));


        journalTitle.add(j_IP);

        JLabel j_Des = new JLabel("操作描述", SwingConstants.CENTER);
        j_Des.setFont(new Font("微软雅黑", Font.PLAIN, 15));
        j_Des.setPreferredSize(new Dimension(450, 30));

        journalTitle.add(j_Des);

        JButton search = new JButton("查询");

        add(new LayoutPanel(20, 10, Color.white));
        add(search);

        search.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                clearJournal();
                Connects.stringConnect.sendMessage("{admin_searchJournal[content:\"" + textField.getText() + "\"]}");
                textField.setText("");
            }
        });

        add(journalTitle);
        journalJPanel.setPreferredSize(new Dimension(1030, 0));
        journalJPanel.setLayout(new FlowLayout(1, 0, 0));

        add(journalJPanel);

        JScrollPane scrollPane = new JScrollPane(journalJPanel);

        scrollPane.setPreferredSize(new Dimension(1030, 550));

        add(scrollPane);

        addJournal("2018-05-05 20:31:15","李白","162.26.354.242","登录系统");
        addJournal("2018-05-05 19:30:53","曹操","171.26.354.242","退出系统");
        addJournal("2018-05-05 18:27:23","高渐离","132.26.354.242","结束工作");
        addJournal("2018-05-05 17:15:14","鲁班","178.26.354.242","上传至云服务器");
        addJournal("2018-05-05 16:10:06","亚瑟","158.26.354.242","下载资源");
        addJournal("2018-05-05 15:59:42","哪吒","158.26.354.242","未检测到人脸");
        addJournal("2018-05-05 14:42:10","吕布","125.26.354.242","出现非法操作");
        addJournal("2018-05-05 13:37:57","安琪拉","158.26.354.242","暂停工作");
        addJournal("2018-05-05 12:33:14","虞姬","158.26.354.242","被系统检测到非法人脸");
        addJournal("2018-05-05 11:32:07","程咬金","158.26.354.242","登录系统");
        addJournal("2018-05-05 10:31:15","李白","158.26.354.242","登录系统");
        addJournal("2018-05-05 09:30:53","曹操","158.26.354.242","退出系统");
        addJournal("2018-05-05 08:27:23","高渐离","158.26.354.242","结束工作");
        addJournal("2018-05-05 07:15:14","鲁班","315.26.354.242","上传至云服务器");
        addJournal("2018-05-05 06:10:06","亚瑟","421.26.354.242","下载资源");
        addJournal("2018-05-05 05:59:42","哪吒","164.26.354.242","未检测到人脸");
        addJournal("2018-05-05 04:42:10","吕布","158.26.354.242","出现非法操作");
        addJournal("2018-05-05 03:35:57","安琪拉","175.26.354.242","暂停工作");
        addJournal("2018-05-05 02:30:14","虞姬","163.26.354.242","被系统检测到非法人脸");
        addJournal("2018-05-05 01:28:07","程咬金","158.26.354.242","登录系统");


    }

    public void addJournal(String Otime, String OStaff, String OIP, String ODescription) {
        if (n == 1) {
            journalJPanel.add(new JournalModel(Otime, OStaff, OIP, ODescription));
            n = 0;
            m = m + 30;

            journalJPanel.setPreferredSize(new Dimension(1030, m));

        } else {
            JournalModel JournalModel = new JournalModel(Otime, OStaff, OIP, ODescription);
            JournalModel.setBackground(new Color(224, 224, 224));
            journalJPanel.add(JournalModel);
            n = 1;
            m = m + 30;
            journalJPanel.setPreferredSize(new Dimension(1030, m));

        }
    }

    public void clearJournal() {
        journalJPanel.removeAll();
        journalJPanel.repaint();
        journalJPanel.setPreferredSize(new Dimension(1030, 0));
        m = 0;
    }
}