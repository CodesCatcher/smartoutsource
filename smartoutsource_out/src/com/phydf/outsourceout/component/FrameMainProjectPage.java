package com.phydf.outsourceout.component;

import javax.swing.*;
import java.awt.*;

public class FrameMainProjectPage extends JPanel {

    JLabel myProject=new JLabel("我的项目",SwingConstants.CENTER);
    JPanel myProject_title=new JPanel();
    JLabel ProjectNumber=new JLabel("项目代码");
    JLabel ProjectName=new JLabel("项目名称");
    JLabel ProjectStartTime=new JLabel("项目开始时间");
    JLabel ProjectStopTime=new JLabel("项目结束时间");
    JLabel projectState=new JLabel("项目状态");
    JLabel projectProgress=new JLabel("项目进度");
    JPanel myProjectPanel=new JPanel();

    private int n=0;
    private int m=0;

    private void AddProjectModel(String number,String name,String startTime,String stopTime,String state,int progress){
        if(n==0){
            MyProjectModel pModel=new MyProjectModel(number,name,startTime,stopTime,state,progress);
            pModel.setBackground(new Color(224,224,224));
            myProjectPanel.add(pModel);
            n=1;
            m=m+30;
            myProjectPanel.setPreferredSize(new Dimension(880,m));
        }else{
            n=0;
            m=m+30;
            myProjectPanel.add(new MyProjectModel(number,name,startTime,stopTime,state,progress));
            myProjectPanel.setPreferredSize(new Dimension(880,m));
        }
    }

    public FrameMainProjectPage(){
        setLayout(new FlowLayout(1,0,10));
        setBackground(Color.white);
        myProject_title.setPreferredSize(new Dimension(880,30));
        myProject_title.setLayout(new FlowLayout(0,10,0));


        myProject.setPreferredSize(new Dimension(880,25));
        myProject.setBackground(new Color(153, 180, 209));
        myProject.setOpaque(true);
        myProject.setFont(new Font("微软雅黑",Font.PLAIN,15));
        add(myProject);


        ProjectNumber.setFont(new Font("微软雅黑",Font.PLAIN,15));
        ProjectNumber.setPreferredSize(new Dimension(130,30));
        ProjectNumber.setHorizontalAlignment(SwingConstants.CENTER);
        myProject_title.add(ProjectNumber);


        ProjectName.setFont(new Font("微软雅黑",Font.PLAIN,15));
        ProjectName.setPreferredSize(new Dimension(130,30));
        ProjectName.setHorizontalAlignment(SwingConstants.CENTER);
        myProject_title.add(ProjectName);

        ProjectStartTime.setFont(new Font("微软雅黑",Font.PLAIN,15));
        ProjectStartTime.setPreferredSize(new Dimension(130,30));
        ProjectStartTime.setHorizontalAlignment(SwingConstants.CENTER);
        myProject_title.add(ProjectStartTime);

        ProjectStopTime.setFont(new Font("微软雅黑",Font.PLAIN,15));
        ProjectStopTime.setPreferredSize(new Dimension(130,30));
        ProjectStopTime.setHorizontalAlignment(SwingConstants.CENTER);
        myProject_title.add(new LayoutPanel(20,30,new Color(238,238,238)));
        myProject_title.add(ProjectStopTime);

        projectState.setFont(new Font("微软雅黑",Font.PLAIN,15));
        projectState.setPreferredSize(new Dimension(130,30));
        projectState.setHorizontalAlignment(SwingConstants.CENTER);
        myProject_title.add(projectState);

        projectProgress.setFont(new Font("微软雅黑",Font.PLAIN,15));
        projectProgress.setPreferredSize(new Dimension(130,30));
        projectProgress.setHorizontalAlignment(SwingConstants.CENTER);
        myProject_title.add(projectProgress);

        add(myProject_title);
        myProjectPanel.setPreferredSize(new Dimension(880,0));
        myProjectPanel.setLayout(new FlowLayout(1,0,0));



        AddProjectModel("480430001","搜集西湖的有关视频","2018-03-12","2018-05-12","未完成",20);
        AddProjectModel("480430002","整理湿地公园的资料","2018-04-23","2018-05-23","未完成",60);
        AddProjectModel("480430003","拍摄黄山的照片","2018-02-14","2018-05-14","未完成",25);
        AddProjectModel("480430004","整理万里长城的素材","2018-03-16","2018-05-16","未完成",20);
        AddProjectModel("480430005","整理云南高原的视频","2018-01-10","2018-05-10","未完成",73);
        AddProjectModel("480430006","搜集西湖的有关视频","2018-01-31","2018-05-23","未完成",100);
        AddProjectModel("480430007","拍摄黄山的照片","2018-03-20","2018-05-12","未完成",16);
        AddProjectModel("480430008","整理云南高原的视频","2018-02-01","2018-05-08","未完成",71);
        AddProjectModel("480430009","拍摄黄山的照片","2018-02-13","2018-05-01","未完成",20);
        AddProjectModel("480430010","搜集西湖的有关视频","2018-01-23","2018-04-03","未完成",96);

        JScrollPane scrollPane1=new JScrollPane(myProjectPanel);
        scrollPane1.setPreferredSize(new Dimension(880,550));

        add(scrollPane1);
    }
}
