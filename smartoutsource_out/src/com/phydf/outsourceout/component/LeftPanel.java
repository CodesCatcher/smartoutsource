package com.phydf.outsourceout.component;


import com.phydf.outsourceout.utils.IconBuilder;

import javax.swing.*;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class LeftPanel extends JPanel {


    /**
     * ��ӭ��ǩ
     */
    private JLabel welcomeTitle;

    /**
     * �ʺű�ǩ
     */
    private JLabel accountTitle;

    /**
     * ��¼ʱ���ǩ
     */
    private JLabel loginTimeTitle;

    /**
     * ��һ�ε�¼ʱ���ǩ
     */
    private JLabel lastLoginTimeTitle;

    /**
     * ����ʱ��
     */
    private JLabel localTime;

    /**
     * �˳���¼ͼ��
     */
    private ImageIcon exitIcon;

    /**
     * �˳���¼��ť
     */
    private JPanel exitButton;

    private Locale locale = Locale.CHINA;

    private SimpleDateFormat simpleDateFormat;


    public LeftPanel() {

        setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
        setPreferredSize(new Dimension(300,700));
        setBackground(Color.BLUE);

        JLabel topTitle = new JLabel("��¼��Ϣ", SwingConstants.CENTER);
        topTitle.setPreferredSize(new Dimension(280, 25));
        topTitle.setOpaque(true);
        topTitle.setBackground(new Color(153, 180, 209));
        topTitle.setFont(new Font("΢���ź�", Font.PLAIN, 15));
        setBackground(Color.WHITE);

        add(new LayoutPanel(240, 10, Color.white));
        add(topTitle);

        add(new LayoutPanel(240, 20, Color.white));

        welcomeTitle = new JLabel("��ӭ��¼�����������ƽ̨", SwingConstants.CENTER);
        welcomeTitle.setPreferredSize(new Dimension(280, 25));
        welcomeTitle.setFont(new Font("΢���ź�", Font.PLAIN, 15));
        add(welcomeTitle);

        add(new LayoutPanel(240, 20, Color.white));

        accountTitle = new JLabel("��ǰ�ʺ�:  UserName");
        accountTitle.setPreferredSize(new Dimension(240, 25));
        accountTitle.setFont(new Font("΢���ź�", Font.PLAIN, 15));
        add(accountTitle);

        simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss", locale);
        loginTimeTitle = new JLabel("��¼ʱ�䣺" + simpleDateFormat.format(new Date()));
        loginTimeTitle.setPreferredSize(new Dimension(240, 25));
        loginTimeTitle.setFont(new Font("΢���ź�", Font.PLAIN, 15));
        add(loginTimeTitle);

        simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss", locale);
        lastLoginTimeTitle = new JLabel("�ϴε�¼��2018-04-12 16:48:06");
        lastLoginTimeTitle.setPreferredSize(new Dimension(240, 25));
        lastLoginTimeTitle.setFont(new Font("΢���ź�", Font.PLAIN, 15));
        add(lastLoginTimeTitle);

        localTime = new JLabel();
        localTime.setPreferredSize(new Dimension(240, 25));
        localTime.setFont(new Font("΢���ź�", Font.PLAIN, 15));
        add(localTime);

        Thread timeThread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss", locale);
                        localTime.setText("��ǰʱ�䣺" + simpleDateFormat.format(new Date()));
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        timeThread.start();

        exitIcon = new ImageIcon(getToolkit().getImage(IconBuilder.getUrl("exit.png")));
        exitButton = new JPanel();
        exitButton.add(new JLabel(exitIcon));
        JLabel exitLabel = new JLabel("�л��ʺ�");
        exitLabel.setFont(new Font("΢���ź�", Font.PLAIN, 15));
        exitLabel.setForeground(new Color(247, 70, 48));
        exitButton.add(exitLabel);
        exitButton.setBackground(Color.white);

        add(new LayoutPanel(240, 20, Color.white));
        add(exitButton);

        JLabel bottomTitle = new JLabel("��ݰ���", SwingConstants.CENTER);
        bottomTitle.setPreferredSize(new Dimension(280, 25));
        bottomTitle.setOpaque(true);
        bottomTitle.setBackground(new Color(153, 180, 209));
        bottomTitle.setFont(new Font("΢���ź�", Font.PLAIN, 15));

        add(new LayoutPanel(240, 20, Color.white));
        add(bottomTitle);

        JPanel quickPanel = new JPanel();
        quickPanel.setPreferredSize(new Dimension(270, 270));
        quickPanel.setBackground(Color.WHITE);
        quickPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 31, 31));

        //add(new LayoutPanel(240, 20));
        add(quickPanel);

        JLabel search = new JLabel(new ImageIcon(getToolkit().getImage(IconBuilder.getUrl("search.png"))));
        quickPanel.add(search);
        search.setToolTipText("��ѯ");

        JLabel outpro = new JLabel(new ImageIcon(getToolkit().getImage(IconBuilder.getUrl("package.png"))));
        quickPanel.add(outpro);
        outpro.setToolTipText("����");

        JLabel count = new JLabel(new ImageIcon(getToolkit().getImage(IconBuilder.getUrl("count.png"))));
        quickPanel.add(count);
        count.setToolTipText("ͳ��");

        JLabel addpro = new JLabel(new ImageIcon(getToolkit().getImage(IconBuilder.getUrl("addpro.png"))));
        quickPanel.add(addpro);
        addpro.setToolTipText("�����Ŀ");

        JLabel video = new JLabel(new ImageIcon(getToolkit().getImage(IconBuilder.getUrl("video.png"))));
        quickPanel.add(video);
        video.setToolTipText("�鿴¼��");

        JLabel evaluate = new JLabel(new ImageIcon(getToolkit().getImage(IconBuilder.getUrl("evaluate.png"))));
        quickPanel.add(evaluate);
        evaluate.setToolTipText("����");

        JLabel setting = new JLabel(new ImageIcon(getToolkit().getImage(IconBuilder.getUrl("setting.png"))));
        quickPanel.add(setting);
        setting.setToolTipText("����");

        JLabel message = new JLabel(new ImageIcon(getToolkit().getImage(IconBuilder.getUrl("message.png"))));
        quickPanel.add(message);
        message.setToolTipText("��Ϣ");

        JLabel about = new JLabel(new ImageIcon(getToolkit().getImage(IconBuilder.getUrl("about.png"))));
        quickPanel.add(about);
        about.setToolTipText("����");

        JLabel versionTitle = new JLabel("�汾��Ϣ", SwingConstants.CENTER);
        versionTitle.setPreferredSize(new Dimension(280, 25));
        versionTitle.setOpaque(true);
        versionTitle.setBackground(new Color(153, 180, 209));
        versionTitle.setFont(new Font("΢���ź�", Font.PLAIN, 15));
        setBackground(Color.WHITE);
        add(versionTitle);

        JLabel version1 = new JLabel("Version 1.0.2", SwingConstants.CENTER);
        version1.setFont(new Font("΢���ź�", Font.PLAIN, 15));
        version1.setPreferredSize(new Dimension(240, 20));
        add(new LayoutPanel(240, 10, Color.white));
        add(version1);

        JLabel version2 = new JLabel("Phydf. All Rights Reserved.", SwingConstants.CENTER);
        version2.setFont(new Font("΢���ź�", Font.PLAIN, 15));
        version2.setPreferredSize(new Dimension(240, 20));
        add(version2);

        validate();
    }
}
