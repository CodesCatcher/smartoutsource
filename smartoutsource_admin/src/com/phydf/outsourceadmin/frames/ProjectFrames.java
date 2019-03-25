package com.phydf.outsourceadmin.frames;

import javax.swing.*;
import java.awt.*;


public class ProjectFrames extends JFrame{
    private Container container;

    /**
     * 项目编号
     */
    private JTextField number = new JTextField();

    /**
     * 项目名称
     */
    private JTextField name = new JTextField();

    /**
     * 安全等级
     */
    private JTextField safety = new JTextField();

    /**
     * 紧迫程度
     */
    private JTextField urgency = new JTextField();

    private JTextField startTime = new JTextField();

    private JTextField endTime = new JTextField();

    private  JTextField teamName = new JTextField();

    private JTextField teamNumber = new JTextField();

    private JTextField project = new JTextField();

    private JTextField goalTime = new JTextField();

    /**
     * 项目描述
     */
    private JTextArea describe;

    /**
     * 项目资源
     */
    public ProjectFrames(String str){
        setTitle("查看项目");
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

        JLabel numberLabel = new JLabel("项目编号：");
        numberLabel.setFont(new Font("微软雅黑", Font.PLAIN, 15));
        number.setPreferredSize(new Dimension(300, 30));
        number.setFont(new Font("微软雅黑", Font.PLAIN, 15));

        JLabel nameLabel = new JLabel("项目名称：");
        nameLabel.setFont(new Font("微软雅黑", Font.PLAIN, 15));
        name.setPreferredSize(new Dimension(300, 30));
        name.setFont(new Font("微软雅黑", Font.PLAIN, 15));

        JLabel safeLabel = new JLabel("安全等级：");
        safeLabel.setFont(new Font("微软雅黑", Font.PLAIN, 15));

        safety.setPreferredSize(new Dimension(300, 30));
        safety.setFont(new Font("微软雅黑", Font.PLAIN, 15));

        JLabel urgencyLabel = new JLabel("紧迫程度：");
        urgencyLabel.setFont(new Font("微软雅黑", Font.PLAIN, 15));
        urgency.setPreferredSize(new Dimension(300, 30));
        urgency.setFont(new Font("微软雅黑", Font.PLAIN, 15));

        JLabel start = new JLabel("开始时间：");
        start.setFont(new Font("微软雅黑", Font.PLAIN, 15));
        startTime.setPreferredSize(new Dimension(300, 30));
        startTime.setFont(new Font("微软雅黑", Font.PLAIN, 15));

        JLabel end = new JLabel("结束时间:  ");
        end.setFont(new Font("微软雅黑", Font.PLAIN, 15));
        endTime.setPreferredSize(new Dimension(300, 30));
        endTime.setFont(new Font("微软雅黑", Font.PLAIN, 15));

        JLabel team = new JLabel("开发团队:  ");
        team.setFont(new Font("微软雅黑", Font.PLAIN, 15));
        teamName.setPreferredSize(new Dimension(300, 30));
        teamName.setFont(new Font("微软雅黑", Font.PLAIN, 15));

        JLabel teamNO = new JLabel("队员数量：");
        teamNO.setFont(new Font("微软雅黑", Font.PLAIN, 15));
        teamNumber.setPreferredSize(new Dimension(300, 30));
        teamNumber.setFont(new Font("微软雅黑", Font.PLAIN, 15));

        JLabel Project = new JLabel("文件大小：");
        Project.setFont(new Font("微软雅黑", Font.PLAIN, 15));
        project.setPreferredSize(new Dimension(300, 30));
        project.setFont(new Font("微软雅黑", Font.PLAIN, 15));

        JLabel goal = new JLabel("目标时间：");
        goal.setFont(new Font("微软雅黑", Font.PLAIN, 15));
        goalTime.setPreferredSize(new Dimension(300, 30));
        goalTime.setFont(new Font("微软雅黑", Font.PLAIN, 15));

        JButton showProtocol = new JButton("显示保密协议");
        JButton showAgreement = new JButton("显示合同");

        if(str.equals("280430001")){
            number.setText("280430001");
            name.setText("整理西湖的视频资源");
            safety.setText("低等");
            urgency.setText("中");
            startTime.setText("2018-04-30");
            endTime.setText("2018-05-03");
            teamName.setText("开心外包有限公司");
            teamNumber.setText("5");
            project.setText("30MB");
            goalTime.setText("2018-03-05");
        }
        if(str.equals("280430002")){
            number.setText("280430002");
            name.setText("收集印象城视频");
            safety.setText("高");
            urgency.setText("中");
            startTime.setText("2018-05-04");
            endTime.setText("2018-05-14");
            teamName.setText("开心外包有限公司");
            teamNumber.setText("20");
            project.setText("20MB");
            goalTime.setText("2018-03-05");
        }
        if(str.equals("280430003")){
            number.setText("280430003");
            name.setText("收集西溪湿地图片");
            safety.setText("高");
            urgency.setText("低");
            startTime.setText("2018-01-01");
            endTime.setText("2018-02-01");
            teamName.setText("略略略傲娇团队");
            teamNumber.setText("52");
            project.setText("100KB");
            goalTime.setText("2018-03-05");
        }
        if(str.equals("280430004")){
            number.setText("280430004");
            name.setText("生活水平调查");
            safety.setText("低");
            urgency.setText("中");
            startTime.setText("2018-01-01");
            endTime.setText("2018-02-01");
            teamName.setText("我的火锅科技有限公司");
            teamNumber.setText("52");
            project.setText("56MB");
            goalTime.setText("2018-03-09");
        }
        if(str.equals("280430005")){
            number.setText("280430005");
            name.setText("食品满意度调查");
            safety.setText("低");
            urgency.setText("高");
            startTime.setText("2018-01-01");
            endTime.setText("2018-02-01");
            teamName.setText("3咳2吐团队");
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
