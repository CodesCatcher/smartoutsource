package com.phydf.outsourceout.component;

import javax.swing.*;
import java.awt.*;

public class FrameMainProjectPage extends JPanel {

    JLabel myProject=new JLabel("�ҵ���Ŀ",SwingConstants.CENTER);
    JPanel myProject_title=new JPanel();
    JLabel ProjectNumber=new JLabel("��Ŀ����");
    JLabel ProjectName=new JLabel("��Ŀ����");
    JLabel ProjectStartTime=new JLabel("��Ŀ��ʼʱ��");
    JLabel ProjectStopTime=new JLabel("��Ŀ����ʱ��");
    JLabel projectState=new JLabel("��Ŀ״̬");
    JLabel projectProgress=new JLabel("��Ŀ����");
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
        myProject.setFont(new Font("΢���ź�",Font.PLAIN,15));
        add(myProject);


        ProjectNumber.setFont(new Font("΢���ź�",Font.PLAIN,15));
        ProjectNumber.setPreferredSize(new Dimension(130,30));
        ProjectNumber.setHorizontalAlignment(SwingConstants.CENTER);
        myProject_title.add(ProjectNumber);


        ProjectName.setFont(new Font("΢���ź�",Font.PLAIN,15));
        ProjectName.setPreferredSize(new Dimension(130,30));
        ProjectName.setHorizontalAlignment(SwingConstants.CENTER);
        myProject_title.add(ProjectName);

        ProjectStartTime.setFont(new Font("΢���ź�",Font.PLAIN,15));
        ProjectStartTime.setPreferredSize(new Dimension(130,30));
        ProjectStartTime.setHorizontalAlignment(SwingConstants.CENTER);
        myProject_title.add(ProjectStartTime);

        ProjectStopTime.setFont(new Font("΢���ź�",Font.PLAIN,15));
        ProjectStopTime.setPreferredSize(new Dimension(130,30));
        ProjectStopTime.setHorizontalAlignment(SwingConstants.CENTER);
        myProject_title.add(new LayoutPanel(20,30,new Color(238,238,238)));
        myProject_title.add(ProjectStopTime);

        projectState.setFont(new Font("΢���ź�",Font.PLAIN,15));
        projectState.setPreferredSize(new Dimension(130,30));
        projectState.setHorizontalAlignment(SwingConstants.CENTER);
        myProject_title.add(projectState);

        projectProgress.setFont(new Font("΢���ź�",Font.PLAIN,15));
        projectProgress.setPreferredSize(new Dimension(130,30));
        projectProgress.setHorizontalAlignment(SwingConstants.CENTER);
        myProject_title.add(projectProgress);

        add(myProject_title);
        myProjectPanel.setPreferredSize(new Dimension(880,0));
        myProjectPanel.setLayout(new FlowLayout(1,0,0));



        AddProjectModel("480430001","�Ѽ��������й���Ƶ","2018-03-12","2018-05-12","δ���",20);
        AddProjectModel("480430002","����ʪ�ع�԰������","2018-04-23","2018-05-23","δ���",60);
        AddProjectModel("480430003","�����ɽ����Ƭ","2018-02-14","2018-05-14","δ���",25);
        AddProjectModel("480430004","�������ﳤ�ǵ��ز�","2018-03-16","2018-05-16","δ���",20);
        AddProjectModel("480430005","�������ϸ�ԭ����Ƶ","2018-01-10","2018-05-10","δ���",73);
        AddProjectModel("480430006","�Ѽ��������й���Ƶ","2018-01-31","2018-05-23","δ���",100);
        AddProjectModel("480430007","�����ɽ����Ƭ","2018-03-20","2018-05-12","δ���",16);
        AddProjectModel("480430008","�������ϸ�ԭ����Ƶ","2018-02-01","2018-05-08","δ���",71);
        AddProjectModel("480430009","�����ɽ����Ƭ","2018-02-13","2018-05-01","δ���",20);
        AddProjectModel("480430010","�Ѽ��������й���Ƶ","2018-01-23","2018-04-03","δ���",96);

        JScrollPane scrollPane1=new JScrollPane(myProjectPanel);
        scrollPane1.setPreferredSize(new Dimension(880,550));

        add(scrollPane1);
    }
}
