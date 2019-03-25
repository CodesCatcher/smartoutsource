package com.phydf.outsourceadmin.frames;

import javax.swing.*;
import java.awt.*;


public class ProjectFrames extends JFrame{
    private Container container;

    /**
     * ��Ŀ���
     */
    private JTextField number = new JTextField();

    /**
     * ��Ŀ����
     */
    private JTextField name = new JTextField();

    /**
     * ��ȫ�ȼ�
     */
    private JTextField safety = new JTextField();

    /**
     * ���ȳ̶�
     */
    private JTextField urgency = new JTextField();

    private JTextField startTime = new JTextField();

    private JTextField endTime = new JTextField();

    private  JTextField teamName = new JTextField();

    private JTextField teamNumber = new JTextField();

    private JTextField project = new JTextField();

    private JTextField goalTime = new JTextField();

    /**
     * ��Ŀ����
     */
    private JTextArea describe;

    /**
     * ��Ŀ��Դ
     */
    public ProjectFrames(String str){
        setTitle("�鿴��Ŀ");
        setSize(950, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setLayout(new FlowLayout(FlowLayout.CENTER,0,0));
        setVisible(true);

        container = getContentPane();

        JPanel topPanel = new JPanel();
        JPanel bottomPanel = new JPanel();
        topPanel.setPreferredSize(new Dimension(950, 400));
        topPanel.setLayout(new FlowLayout(FlowLayout.LEFT,30,30));

        bottomPanel.setPreferredSize(new Dimension(950, 200));
        bottomPanel.setLayout(new FlowLayout(FlowLayout.CENTER,30,30));

        JLabel numberLabel = new JLabel("��Ŀ��ţ�");
        numberLabel.setFont(new Font("΢���ź�", Font.PLAIN, 15));
        number.setPreferredSize(new Dimension(300, 30));
        number.setFont(new Font("΢���ź�", Font.PLAIN, 15));

        JLabel nameLabel = new JLabel("��Ŀ���ƣ�");
        nameLabel.setFont(new Font("΢���ź�", Font.PLAIN, 15));
        name.setPreferredSize(new Dimension(300, 30));
        name.setFont(new Font("΢���ź�", Font.PLAIN, 15));

        JLabel safeLabel = new JLabel("��ȫ�ȼ���");
        safeLabel.setFont(new Font("΢���ź�", Font.PLAIN, 15));

        safety.setPreferredSize(new Dimension(300, 30));
        safety.setFont(new Font("΢���ź�", Font.PLAIN, 15));

        JLabel urgencyLabel = new JLabel("���ȳ̶ȣ�");
        urgencyLabel.setFont(new Font("΢���ź�", Font.PLAIN, 15));
        urgency.setPreferredSize(new Dimension(300, 30));
        urgency.setFont(new Font("΢���ź�", Font.PLAIN, 15));

        JLabel start = new JLabel("��ʼʱ�䣺");
        start.setFont(new Font("΢���ź�", Font.PLAIN, 15));
        startTime.setPreferredSize(new Dimension(300, 30));
        startTime.setFont(new Font("΢���ź�", Font.PLAIN, 15));

        JLabel end = new JLabel("����ʱ��:  ");
        end.setFont(new Font("΢���ź�", Font.PLAIN, 15));
        endTime.setPreferredSize(new Dimension(300, 30));
        endTime.setFont(new Font("΢���ź�", Font.PLAIN, 15));

        JLabel team = new JLabel("�����Ŷ�:  ");
        team.setFont(new Font("΢���ź�", Font.PLAIN, 15));
        teamName.setPreferredSize(new Dimension(300, 30));
        teamName.setFont(new Font("΢���ź�", Font.PLAIN, 15));

        JLabel teamNO = new JLabel("��Ա������");
        teamNO.setFont(new Font("΢���ź�", Font.PLAIN, 15));
        teamNumber.setPreferredSize(new Dimension(300, 30));
        teamNumber.setFont(new Font("΢���ź�", Font.PLAIN, 15));

        JLabel Project = new JLabel("�ļ���С��");
        Project.setFont(new Font("΢���ź�", Font.PLAIN, 15));
        project.setPreferredSize(new Dimension(300, 30));
        project.setFont(new Font("΢���ź�", Font.PLAIN, 15));

        JLabel goal = new JLabel("Ŀ��ʱ�䣺");
        goal.setFont(new Font("΢���ź�", Font.PLAIN, 15));
        goalTime.setPreferredSize(new Dimension(300, 30));
        goalTime.setFont(new Font("΢���ź�", Font.PLAIN, 15));

        JButton showProtocol = new JButton("��ʾ����Э��");
        JButton showAgreement = new JButton("��ʾ��ͬ");

        if(str.equals("280430001")){
            number.setText("280430001");
            name.setText("������������Ƶ��Դ");
            safety.setText("�͵�");
            urgency.setText("��");
            startTime.setText("2018-04-30");
            endTime.setText("2018-05-03");
            teamName.setText("����������޹�˾");
            teamNumber.setText("5");
            project.setText("30MB");
            goalTime.setText("2018-03-05");
        }
        if(str.equals("280430002")){
            number.setText("280430002");
            name.setText("�ռ�ӡ�����Ƶ");
            safety.setText("��");
            urgency.setText("��");
            startTime.setText("2018-05-04");
            endTime.setText("2018-05-14");
            teamName.setText("����������޹�˾");
            teamNumber.setText("20");
            project.setText("20MB");
            goalTime.setText("2018-03-05");
        }
        if(str.equals("280430003")){
            number.setText("280430003");
            name.setText("�ռ���Ϫʪ��ͼƬ");
            safety.setText("��");
            urgency.setText("��");
            startTime.setText("2018-01-01");
            endTime.setText("2018-02-01");
            teamName.setText("�����԰����Ŷ�");
            teamNumber.setText("52");
            project.setText("100KB");
            goalTime.setText("2018-03-05");
        }
        if(str.equals("280430004")){
            number.setText("280430004");
            name.setText("����ˮƽ����");
            safety.setText("��");
            urgency.setText("��");
            startTime.setText("2018-01-01");
            endTime.setText("2018-02-01");
            teamName.setText("�ҵĻ���Ƽ����޹�˾");
            teamNumber.setText("52");
            project.setText("56MB");
            goalTime.setText("2018-03-09");
        }
        if(str.equals("280430005")){
            number.setText("280430005");
            name.setText("ʳƷ����ȵ���");
            safety.setText("��");
            urgency.setText("��");
            startTime.setText("2018-01-01");
            endTime.setText("2018-02-01");
            teamName.setText("3��2���Ŷ�");
            teamNumber.setText("5");
            project.setText("20MB");
            goalTime.setText("2018-03-08");
        }

        topPanel.add(numberLabel);
        topPanel.add(number);
        topPanel.add(nameLabel);
        topPanel.add(name);
        topPanel.add(safeLabel);
        topPanel.add(safety);
        topPanel.add(urgencyLabel);
        topPanel.add(urgency);
        topPanel.add(start);
        topPanel.add(startTime);
        topPanel.add(end);
        topPanel.add(endTime);
        topPanel.add(team);
        topPanel.add(teamName);
        topPanel.add(teamNO);
        topPanel.add(teamNumber);
        topPanel.add(Project);
        topPanel.add(project);
        topPanel.add(goal);
        topPanel.add(goalTime);

        bottomPanel.add(showProtocol);
        bottomPanel.add(showAgreement);

        container.add(topPanel);
        container.add(bottomPanel);

        validate();
    }

}
