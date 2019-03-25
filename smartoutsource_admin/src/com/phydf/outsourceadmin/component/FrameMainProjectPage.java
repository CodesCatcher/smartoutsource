package com.phydf.outsourceadmin.component;


import com.phydf.outsourceadmin.control.StringMessageControl;
import com.phydf.outsourceadmin.frames.ProjectFrames;
import com.phydf.outsourceadmin.statics.Connects;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class FrameMainProjectPage extends JPanel {

    private JTextField textField;
    private JPanel projectPanel;
    private int projectMaxIndex;
    private String projectSearch;

    public FrameMainProjectPage() {

        setBackground(Color.white);

        JLabel projectState4 = new JLabel("项目列表", SwingConstants.CENTER);//项目
        projectState4.setBackground(new Color(153, 180, 209));
        projectState4.setFont(new Font("微软雅黑", Font.PLAIN, 15));
        projectState4.setPreferredSize(new Dimension(1030, 25));
        projectState4.setOpaque(true);
        add(projectState4);

        JPanel Title1 = new JPanel();
        Title1.setLayout(new FlowLayout(1, 0, 0));
        Title1.setPreferredSize(new Dimension(1030, 30));
        JLabel proName = new JLabel("项目名称");//项目名称
        proName.setFont(new Font("微软雅黑", Font.PLAIN, 15));
        proName.setPreferredSize(new Dimension(140, 30));

        JLabel proNum = new JLabel("项目代码");//项目代码
        proNum.setFont(new Font("微软雅黑", Font.PLAIN, 15));
        proNum.setPreferredSize(new Dimension(140, 30));

        JLabel GroName = new JLabel("团队名称");//团队名称
        GroName.setFont(new Font("微软雅黑", Font.PLAIN, 15));
        GroName.setPreferredSize(new Dimension(140, 30));

        JLabel startTime = new JLabel("开始时间");//开始时间
        startTime.setFont(new Font("微软雅黑", Font.PLAIN, 15));
        startTime.setPreferredSize(new Dimension(140, 30));

        JLabel stopTime = new JLabel("截止时间");//截止时间
        stopTime.setFont(new Font("微软雅黑", Font.PLAIN, 15));
        stopTime.setPreferredSize(new Dimension(140, 30));

        JLabel proState = new JLabel("项目状况");//项目状况
        proState.setFont(new Font("微软雅黑", Font.PLAIN, 15));
        proState.setPreferredSize(new Dimension(140, 30));

        JLabel proProgress = new JLabel("项目进度");//项目进度
        proProgress.setFont(new Font("微软雅黑", Font.PLAIN, 15));
        proProgress.setPreferredSize(new Dimension(140, 30));

        textField = new JTextField();
        textField.setPreferredSize(new Dimension(500, 30));
        add(textField);

        JButton search = new JButton("查询");
        add(new LayoutPanel(30, 10, Color.white));
        add(search);

        search.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                clearProject();
                projectSearch = textField.getText();
                Connects.stringConnect.sendMessage("{admin_searchProject[content:\"" + textField.getText() + "\"]}");
                textField.setText("");
                textField.requestFocus();
            }
        });

        Title1.setBackground(new Color(200, 200, 200));
        Title1.add(new LayoutPanel(50, 10, new Color(200, 200, 200)));
        Title1.add(proName);
        Title1.add(proNum);
        Title1.add(GroName);
        Title1.add(startTime);
        Title1.add(stopTime);
        Title1.add(proState);
        Title1.add(proProgress);

        add(Title1);

        projectPanel = new JPanel();

        projectPanel.setLayout(new FlowLayout(1, 0, 0));

        JScrollPane projectScrollPane = new JScrollPane(projectPanel);
        projectScrollPane.setPreferredSize(new Dimension(1030, 520));

        add(projectScrollPane);

        setLayout(new FlowLayout(1, 0, 10));
        setPreferredSize(new Dimension(0, 715));
    }

    public void addProjectData(String projectName, String projectNumber, String groupName, String projectStartTime,
                               String projectStopTime, String projectState, int progressBar) {

        Project_TopListPanel project_topListPanel = new Project_TopListPanel(projectName, projectNumber, groupName,
                projectStartTime, projectStopTime, projectState, progressBar);

        if (projectMaxIndex % 2 != 0) {
            project_topListPanel.setColor(new Color(200, 200, 200));
        } else {
            project_topListPanel.setColor(new Color(224, 224, 224));
        }

        project_topListPanel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                new ProjectFrames(project_topListPanel.getProjectName());
            }
        });

        projectPanel.add(project_topListPanel);
        projectPanel.setPreferredSize(new Dimension(1030, 30 * (projectMaxIndex + 1)));
        projectMaxIndex++;

    }

    public void clearProject() {
        projectPanel.removeAll();
        projectPanel.repaint();
        projectPanel.setPreferredSize(new Dimension(1030, 0));
        projectMaxIndex = 0;
    }

}
