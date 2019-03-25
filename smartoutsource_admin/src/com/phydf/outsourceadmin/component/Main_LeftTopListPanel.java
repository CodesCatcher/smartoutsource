package com.phydf.outsourceadmin.component;


import java.awt.*;

import javax.swing.*;

public class Main_LeftTopListPanel extends JPanel {

    /**
     * 项目编号
     */
    private String projectNumber;

    /**
     * 项目名称
     */
    private String projectName;

    /**
     * 开始时间
     */
    private String startTime;

    /**
     * 截止时间
     */
    private String stopTime;

    /**
     * 开发团队
     */
    private String developTeam;

    /**
     * 项目状态
     */
    private String projectState;

    /**
     * 开发进度
     */
    private int developProgress;

    /**
     * 项目编号标签
     */
    private JLabel proNumLab;

    /**
     * 项目名称标签
     */
    private JLabel proNameLab;

    /**
     * 开发时间标签
     */
    private JLabel startTimeLab;

    /**
     * 截止时间标签
     */
    private JLabel stopTimeLab;

    /**
     * 开发团队标签
     */
    private JLabel devTeamLab;

    /**
     * 项目状态标签
     */
    private JLabel proStateLab;

    /**
     * 进度条
     */
    private JProgressBar progressBar;


    /**
     * 颜色
     */
    private Color color;

    /**
     * @param projectNumber
     * @param projectName
     * @param startTime
     * @param stopTime
     * @param developTeam
     * @param projectState
     * @param progress
     */

    public Main_LeftTopListPanel(String projectNumber, String projectName, String startTime, String stopTime,
                                 String developTeam, String projectState, int progress) {


        setPreferredSize(new Dimension(707, 30));
        setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));

        proNumLab = new JLabel("", SwingConstants.CENTER);
        proNumLab.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        proNumLab.setPreferredSize(new Dimension(80, 30));

        proNameLab = new JLabel("", SwingConstants.CENTER);
        proNameLab.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        proNameLab.setPreferredSize(new Dimension(80, 30));

        startTimeLab = new JLabel("", SwingConstants.CENTER);
        startTimeLab.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        startTimeLab.setPreferredSize(new Dimension(80, 30));

        stopTimeLab = new JLabel("", SwingConstants.CENTER);
        stopTimeLab.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        stopTimeLab.setPreferredSize(new Dimension(80, 30));

        devTeamLab = new JLabel("", SwingConstants.CENTER);
        devTeamLab.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        devTeamLab.setPreferredSize(new Dimension(80, 30));

        proStateLab = new JLabel("", SwingConstants.CENTER);
        proStateLab.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        proStateLab.setPreferredSize(new Dimension(80, 30));

        progressBar = new JProgressBar();
        progressBar.setBackground(new Color(255, 255, 255));
        progressBar.setForeground(Color.pink);
        progressBar.setPreferredSize(new Dimension(80, 13));

        setProjectNumber(projectNumber);
        setProjectName(projectName);
        setStartTime(startTime);
        setStopTime(stopTime);
        setDevelopTeam(developTeam);
        setProjectState(projectState);
        setDevelopProgress(progress);

    }

    public void setProjectNumber(String projectNumber) {
        this.projectNumber = projectNumber;
        proNumLab.setText(projectNumber);
    }

    public String getProjectNumber() {
        return projectNumber;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
        proNameLab.setText(projectName);
    }

    public String getProjectName() {
        return projectName;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
        startTimeLab.setText(startTime);
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStopTime(String stopTime) {
        this.stopTime = stopTime;
        stopTimeLab.setText(stopTime);
    }

    public String getStopTime() {
        return stopTime;
    }

    public void setDevelopTeam(String developTeam) {
        this.developTeam = developTeam;
        devTeamLab.setText(developTeam);
    }

    public String getDevelopTeam() {
        return developTeam;
    }

    public void setProjectState(String projectState) {
        this.projectState = projectState;
        proStateLab.setText(projectState);
    }

    public String getProjectState() {
        return projectState;
    }

    public void setDevelopProgress(int developProgress) {
        this.developProgress = developProgress;
        progressBar.setValue(developProgress);
    }

    public int getDevelopProgress() {
        return developProgress;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
        setBackground(color);
    }

    public void addPanel(Color color) {

        add(new LayoutPanel(43, 30, color));
        add(proNumLab);
        add(new LayoutPanel(10, 30, color));
        add(proNameLab);
        add(new LayoutPanel(10, 30, color));
        add(startTimeLab);
        add(new LayoutPanel(10, 30, color));
        add(stopTimeLab);
        add(new LayoutPanel(10, 30, color));
        add(devTeamLab);
        add(new LayoutPanel(10, 30, color));
        add(proStateLab);
        add(new LayoutPanel(10, 30, color));
        add(progressBar);
    }

}
