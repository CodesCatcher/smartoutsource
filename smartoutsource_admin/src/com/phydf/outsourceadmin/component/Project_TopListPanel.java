package com.phydf.outsourceadmin.component;

import javax.swing.*;
import java.awt.*;

public class Project_TopListPanel extends JPanel {


    private String projectName;//项目名
    private String projectNumber;//项目编号
    private String groupName;//团队名称
    private String projectStartTime;//项目开始时间
    private String projectStopTime;//项目结束时间
    private String projectState;//项目状态
    private int progressBar;//项目进度
    private JLabel projectName_Label = new JLabel(projectName, SwingConstants.CENTER);
    private JLabel projectNumber_Label = new JLabel(projectNumber, SwingConstants.CENTER);
    private JLabel groupName_Label = new JLabel(groupName, SwingConstants.CENTER);
    private JLabel projectStartTime_Label = new JLabel(projectStartTime, SwingConstants.CENTER);
    private JLabel projectStopTime_Label = new JLabel(projectStopTime, SwingConstants.CENTER);
    private JLabel projectState_Label = new JLabel(projectState, SwingConstants.CENTER);
    private JProgressBar JProgressBar = new JProgressBar(progressBar);
    private Color color;

    public Project_TopListPanel(String projectName, String projectNumber, String groupName, String projectStartTime,
                                String projectStopTime, String projectState, int progressBar) {


        setPreferredSize(new Dimension(1030, 30));
        setLayout(new FlowLayout(0, 15, 0));
        setProjectName(projectName);
        setProjectNumber(projectNumber);
        setGroupName(groupName);
        setProjectStartTime(projectStartTime);
        setProjectStopTime(projectStopTime);
        setProjectState(projectState);
        setProgressBar(progressBar);
        setBackground(Color.WHITE);

        add(projectName_Label);
        add(projectNumber_Label);
        add(groupName_Label);
        add(projectStartTime_Label);
        add(projectStopTime_Label);
        add(projectState_Label);
        add(JProgressBar);
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
        projectName_Label.setText(projectName);
        projectName_Label.setPreferredSize(new Dimension(125, 30));
        projectName_Label.setFont(new Font("微软雅黑", Font.PLAIN, 15));
    }

    public String getProjectNumber() {
        return projectNumber;
    }

    public void setProjectNumber(String projectNumber) {
        this.projectNumber = projectNumber;
        projectNumber_Label.setText(projectNumber);
        projectNumber_Label.setPreferredSize(new Dimension(125, 30));
        projectNumber_Label.setFont(new Font("微软雅黑", Font.PLAIN, 15));
    }

    public String getGroupName() {
        return groupName;

    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
        groupName_Label.setText(groupName);
        groupName_Label.setPreferredSize(new Dimension(125, 30));
        groupName_Label.setFont(new Font("微软雅黑", Font.PLAIN, 15));
    }

    public String getProjectStartTime() {
        return projectStartTime;
    }

    public void setProjectStartTime(String projectStartTime) {
        this.projectStartTime = projectStartTime;
        projectStartTime_Label.setText(projectStartTime);
        projectStartTime_Label.setPreferredSize(new Dimension(125, 30));
        projectStartTime_Label.setFont(new Font("微软雅黑", Font.PLAIN, 15));
    }

    public String getProjectStopTime() {
        return projectStopTime;
    }

    public void setProjectStopTime(String projectStopTime) {
        this.projectStopTime = projectStopTime;
        projectStopTime_Label.setText(projectStopTime);
        projectStopTime_Label.setPreferredSize(new Dimension(125, 30));
        projectStopTime_Label.setFont(new Font("微软雅黑", Font.PLAIN, 15));
    }

    public String getProjectState() {
        return projectState;
    }

    public void setProjectState(String projectState) {
        this.projectState = projectState;
        projectState_Label.setText(projectState);
        projectState_Label.setPreferredSize(new Dimension(125, 30));
        projectState_Label.setFont(new Font("微软雅黑", Font.PLAIN, 15));
    }

    public int getProgressBar() {
        return progressBar;
    }

    public void setProgressBar(int progressBar) {
        this.progressBar = progressBar;
        JProgressBar.setValue(progressBar);
        JProgressBar.setPreferredSize(new Dimension(125, 15));
        JProgressBar.setForeground(Color.PINK);
    }


    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
        setBackground(color);
    }


}

