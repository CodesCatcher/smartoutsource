package com.phydf.outsourceadmin.component;

import com.phydf.outsourceadmin.frames.StaffFrames;
import com.phydf.outsourceadmin.statics.Connects;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class FrameMainStaffPage extends JPanel {

    JLabel title_quickSearch = new JLabel("快速查询", SwingConstants.CENTER);//快速查询标题
    JTextField textField = new JTextField();
    JPanel StaffPanel = new JPanel();

    private static int n = 0;
    private static int m = 30;

    public void addStaff(String number, String name, String sex, String amount, String groupname,
                         String identity) {
        if (n == 1) {
            StaffModel staffModel = new StaffModel(number, name, sex, amount, groupname, identity);
            StaffPanel.add(staffModel);
            staffModel.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    super.mouseClicked(e);
                    new StaffFrames(staffModel.getNumber());
                }
            });
            n = 0;
            m = m + 30;
            StaffPanel.setPreferredSize(new Dimension(1030, m));

        } else {
            StaffModel staffModel1 = new StaffModel(number, name, sex, amount, groupname, identity);
            staffModel1.setBackground(new Color(224, 224, 224));
            staffModel1.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    super.mouseClicked(e);
                    new StaffFrames(staffModel1.getNumber());
                }
            });
            StaffPanel.add(staffModel1);
            n = 1;
            m = m + 30;

            StaffPanel.setPreferredSize(new Dimension(1030, m));
        }

    }

    public FrameMainStaffPage() {

        setBackground(Color.white);
        title_quickSearch.setPreferredSize(new Dimension(1030, 25));
        title_quickSearch.setFont(new Font("微软雅黑", Font.PLAIN, 15));
        title_quickSearch.setBackground(new Color(153, 180, 209));
        title_quickSearch.setOpaque(true);
        setLayout(new FlowLayout(1, 0, 10));
        setPreferredSize(new Dimension(1050, 750));
        add(title_quickSearch);
        textField.setPreferredSize(new Dimension(500, 30));
        add(textField);

        JButton search = new JButton("查询");

        search.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                clearStaff();
                Connects.stringConnect.sendMessage("{admin_searchWorker[content:\"" + textField.getText() + "\"]}");
                textField.setText("");
            }
        });

        add(new LayoutPanel(20, 10, Color.white));
        add(search);

        JPanel StaffTitle = new JPanel();
        StaffTitle.setPreferredSize(new Dimension(1030, 30));
        StaffTitle.setLayout(new FlowLayout(1, 0, 0));
        StaffTitle.setBackground(new Color(200, 200, 200));


        JLabel staffNumber = new JLabel("工号", SwingConstants.CENTER);
        staffNumber.setFont(new Font("微软雅黑", Font.PLAIN, 15));
        staffNumber.setPreferredSize(new Dimension(150, 30));
        StaffTitle.add(staffNumber);

        JLabel staffName = new JLabel("姓名", SwingConstants.CENTER);
        staffName.setFont(new Font("微软雅黑", Font.PLAIN, 15));
        staffName.setPreferredSize(new Dimension(150, 30));
        StaffTitle.add(staffName);

        JLabel sex = new JLabel("性别", SwingConstants.CENTER);
        sex.setFont(new Font("微软雅黑", Font.PLAIN, 15));
        sex.setPreferredSize(new Dimension(150, 30));
        StaffTitle.add(sex);

        JLabel amount = new JLabel("接包数量", SwingConstants.CENTER);
        amount.setFont(new Font("微软雅黑", Font.PLAIN, 15));
        amount.setPreferredSize(new Dimension(150, 30));
        StaffTitle.add(amount);

        JLabel group = new JLabel("团队", SwingConstants.CENTER);
        group.setFont(new Font("微软雅黑", Font.PLAIN, 15));
        group.setPreferredSize(new Dimension(150, 30));
        StaffTitle.add(group);

        JLabel identity = new JLabel("职务", SwingConstants.CENTER);
        identity.setFont(new Font("微软雅黑", Font.PLAIN, 15));
        identity.setPreferredSize(new Dimension(150, 30));
        StaffTitle.add(identity);

        StaffPanel.setPreferredSize(new Dimension(1030, 0));
        StaffPanel.setLayout(new FlowLayout(1, 0, 0));

        add(StaffTitle);

        JScrollPane scrollPane = new JScrollPane(StaffPanel);
        scrollPane.setPreferredSize(new Dimension(1030, 550));

        add(scrollPane);
        addStaff("580430003", "程咬金", "男", "2","开心外包有限公司","程序员");
        addStaff("580430004", "虞姬", "女", "5","天天外包公司","程序员");
        addStaff("580430005", "安琪拉", "女", "3","快乐众包公司","程序员");
        addStaff("580430006", "吕布", "男", "8","乐呵呵专业接包队","程序员");
        addStaff("580430007", "曹操", "男", "7","天天外包公司","程序员");
        addStaff("580430008", "鲁班", "男", "1","开心外包有限公司","程序员");
        addStaff("580430009", "宫本武藏", "男", "3","开心外包有限公司","程序员");
        addStaff("580430010", "干将莫邪", "男", "9","快乐视频科技有限公司","程序员");
        addStaff("580430011", "百里守约", "男", "1","旋转木马公司","程序员");
        addStaff("580430012", "甄姬", "女", "7","略略略傲娇团队","程序员");
        addStaff("580430013", "百里轩测", "男", "4","旋转木马公司","程序员");
        addStaff("580430003", "程咬金", "男", "2","开心外包有限公司","程序员");
        addStaff("580430004", "虞姬", "女", "3","天天外包公司","程序员");
        addStaff("580430005", "安琪拉", "女", "15","快乐众包公司","程序员");
        addStaff("580430006", "吕布", "男", "10","乐呵呵专业接包队","程序员");
        addStaff("580430007", "曹操", "男", "1","天天外包公司","程序员");
        addStaff("580430008", "鲁班", "男", "5","开心外包有限公司","程序员");
        addStaff("580430009", "宫本武藏", "男", "5","开心外包有限公司","程序员");
        addStaff("580430010", "干将莫邪", "男", "7","快乐视频科技有限公司","程序员");
        addStaff("580430011", "百里守约", "男", "3","旋转木马公司","程序员");
        addStaff("580430012", "甄姬", "女", "6","略略略傲娇团队","程序员");
        addStaff("580430013", "百里轩测", "男", "6","旋转木马公司","程序员");

    }

    public JPanel getStaffPanel() {
        return StaffPanel;
    }

    public void clearStaff() {
        StaffPanel.removeAll();
        StaffPanel.repaint();
        StaffPanel.setPreferredSize(new Dimension(1030, 0));
        m = 0;
    }

}
