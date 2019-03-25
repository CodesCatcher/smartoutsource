package com.phydf.outsourceadmin.component;

import com.phydf.outsourceadmin.frames.StaffFrames;
import com.phydf.outsourceadmin.statics.Connects;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class FrameMainStaffPage extends JPanel {

    JLabel title_quickSearch = new JLabel("���ٲ�ѯ", SwingConstants.CENTER);//���ٲ�ѯ����
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
        title_quickSearch.setFont(new Font("΢���ź�", Font.PLAIN, 15));
        title_quickSearch.setBackground(new Color(153, 180, 209));
        title_quickSearch.setOpaque(true);
        setLayout(new FlowLayout(1, 0, 10));
        setPreferredSize(new Dimension(1050, 750));
        add(title_quickSearch);
        textField.setPreferredSize(new Dimension(500, 30));
        add(textField);

        JButton search = new JButton("��ѯ");

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


        JLabel staffNumber = new JLabel("����", SwingConstants.CENTER);
        staffNumber.setFont(new Font("΢���ź�", Font.PLAIN, 15));
        staffNumber.setPreferredSize(new Dimension(150, 30));
        StaffTitle.add(staffNumber);

        JLabel staffName = new JLabel("����", SwingConstants.CENTER);
        staffName.setFont(new Font("΢���ź�", Font.PLAIN, 15));
        staffName.setPreferredSize(new Dimension(150, 30));
        StaffTitle.add(staffName);

        JLabel sex = new JLabel("�Ա�", SwingConstants.CENTER);
        sex.setFont(new Font("΢���ź�", Font.PLAIN, 15));
        sex.setPreferredSize(new Dimension(150, 30));
        StaffTitle.add(sex);

        JLabel amount = new JLabel("�Ӱ�����", SwingConstants.CENTER);
        amount.setFont(new Font("΢���ź�", Font.PLAIN, 15));
        amount.setPreferredSize(new Dimension(150, 30));
        StaffTitle.add(amount);

        JLabel group = new JLabel("�Ŷ�", SwingConstants.CENTER);
        group.setFont(new Font("΢���ź�", Font.PLAIN, 15));
        group.setPreferredSize(new Dimension(150, 30));
        StaffTitle.add(group);

        JLabel identity = new JLabel("ְ��", SwingConstants.CENTER);
        identity.setFont(new Font("΢���ź�", Font.PLAIN, 15));
        identity.setPreferredSize(new Dimension(150, 30));
        StaffTitle.add(identity);

        StaffPanel.setPreferredSize(new Dimension(1030, 0));
        StaffPanel.setLayout(new FlowLayout(1, 0, 0));

        add(StaffTitle);

        JScrollPane scrollPane = new JScrollPane(StaffPanel);
        scrollPane.setPreferredSize(new Dimension(1030, 550));

        add(scrollPane);
        addStaff("580430003", "��ҧ��", "��", "2","����������޹�˾","����Ա");
        addStaff("580430004", "�ݼ�", "Ů", "5","���������˾","����Ա");
        addStaff("580430005", "������", "Ů", "3","�����ڰ���˾","����Ա");
        addStaff("580430006", "����", "��", "8","�ֺǺ�רҵ�Ӱ���","����Ա");
        addStaff("580430007", "�ܲ�", "��", "7","���������˾","����Ա");
        addStaff("580430008", "³��", "��", "1","����������޹�˾","����Ա");
        addStaff("580430009", "�������", "��", "3","����������޹�˾","����Ա");
        addStaff("580430010", "�ɽ�Īа", "��", "9","������Ƶ�Ƽ����޹�˾","����Ա");
        addStaff("580430011", "������Լ", "��", "1","��תľ��˾","����Ա");
        addStaff("580430012", "�缧", "Ů", "7","�����԰����Ŷ�","����Ա");
        addStaff("580430013", "��������", "��", "4","��תľ��˾","����Ա");
        addStaff("580430003", "��ҧ��", "��", "2","����������޹�˾","����Ա");
        addStaff("580430004", "�ݼ�", "Ů", "3","���������˾","����Ա");
        addStaff("580430005", "������", "Ů", "15","�����ڰ���˾","����Ա");
        addStaff("580430006", "����", "��", "10","�ֺǺ�רҵ�Ӱ���","����Ա");
        addStaff("580430007", "�ܲ�", "��", "1","���������˾","����Ա");
        addStaff("580430008", "³��", "��", "5","����������޹�˾","����Ա");
        addStaff("580430009", "�������", "��", "5","����������޹�˾","����Ա");
        addStaff("580430010", "�ɽ�Īа", "��", "7","������Ƶ�Ƽ����޹�˾","����Ա");
        addStaff("580430011", "������Լ", "��", "3","��תľ��˾","����Ա");
        addStaff("580430012", "�缧", "Ů", "6","�����԰����Ŷ�","����Ա");
        addStaff("580430013", "��������", "��", "6","��תľ��˾","����Ա");

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
