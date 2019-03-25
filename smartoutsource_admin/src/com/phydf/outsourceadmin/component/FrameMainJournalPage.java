package com.phydf.outsourceadmin.component;

import com.phydf.outsourceadmin.statics.Connects;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class FrameMainJournalPage extends JPanel {

    JLabel search_result = new JLabel("��ѯ���", SwingConstants.CENTER);//���ٲ�ѯ����
    JTextField textField = new JTextField();
    JPanel journalJPanel = new JPanel();

    private static int n = 0;
    private static int m = 30;

    public FrameMainJournalPage() {

        setBackground(Color.white);
        search_result.setPreferredSize(new Dimension(1030, 25));
        search_result.setFont(new Font("΢���ź�", Font.PLAIN, 15));
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

        JLabel journalTime = new JLabel("����ʱ��", SwingConstants.CENTER);
        journalTime.setFont(new Font("΢���ź�", Font.PLAIN, 15));
        journalTime.setPreferredSize(new Dimension(250, 30));

        journalTitle.add(journalTime);

        JLabel journalStaff = new JLabel("������Ա", SwingConstants.CENTER);
        journalStaff.setFont(new Font("΢���ź�", Font.PLAIN, 15));
        journalStaff.setPreferredSize(new Dimension(100, 30));

        journalTitle.add(journalStaff);


        JLabel j_IP = new JLabel("IP", SwingConstants.CENTER);
        j_IP.setFont(new Font("΢���ź�", Font.PLAIN, 15));
        j_IP.setPreferredSize(new Dimension(150, 30));


        journalTitle.add(j_IP);

        JLabel j_Des = new JLabel("��������", SwingConstants.CENTER);
        j_Des.setFont(new Font("΢���ź�", Font.PLAIN, 15));
        j_Des.setPreferredSize(new Dimension(450, 30));

        journalTitle.add(j_Des);

        JButton search = new JButton("��ѯ");

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

        addJournal("2018-05-05 20:31:15","���","162.26.354.242","��¼ϵͳ");
        addJournal("2018-05-05 19:30:53","�ܲ�","171.26.354.242","�˳�ϵͳ");
        addJournal("2018-05-05 18:27:23","�߽���","132.26.354.242","��������");
        addJournal("2018-05-05 17:15:14","³��","178.26.354.242","�ϴ����Ʒ�����");
        addJournal("2018-05-05 16:10:06","��ɪ","158.26.354.242","������Դ");
        addJournal("2018-05-05 15:59:42","��߸","158.26.354.242","δ��⵽����");
        addJournal("2018-05-05 14:42:10","����","125.26.354.242","���ַǷ�����");
        addJournal("2018-05-05 13:37:57","������","158.26.354.242","��ͣ����");
        addJournal("2018-05-05 12:33:14","�ݼ�","158.26.354.242","��ϵͳ��⵽�Ƿ�����");
        addJournal("2018-05-05 11:32:07","��ҧ��","158.26.354.242","��¼ϵͳ");
        addJournal("2018-05-05 10:31:15","���","158.26.354.242","��¼ϵͳ");
        addJournal("2018-05-05 09:30:53","�ܲ�","158.26.354.242","�˳�ϵͳ");
        addJournal("2018-05-05 08:27:23","�߽���","158.26.354.242","��������");
        addJournal("2018-05-05 07:15:14","³��","315.26.354.242","�ϴ����Ʒ�����");
        addJournal("2018-05-05 06:10:06","��ɪ","421.26.354.242","������Դ");
        addJournal("2018-05-05 05:59:42","��߸","164.26.354.242","δ��⵽����");
        addJournal("2018-05-05 04:42:10","����","158.26.354.242","���ַǷ�����");
        addJournal("2018-05-05 03:35:57","������","175.26.354.242","��ͣ����");
        addJournal("2018-05-05 02:30:14","�ݼ�","163.26.354.242","��ϵͳ��⵽�Ƿ�����");
        addJournal("2018-05-05 01:28:07","��ҧ��","158.26.354.242","��¼ϵͳ");


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