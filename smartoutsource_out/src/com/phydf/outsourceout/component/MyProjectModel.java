package com.phydf.outsourceout.component;

import javax.swing.*;
import java.awt.*;

public class MyProjectModel extends JPanel{
    private JLabel number_Label=new JLabel();
    private JLabel name_Label=new JLabel();
    private JLabel startTime_Label=new JLabel();
    private JLabel stopTime_Label=new JLabel();
    private JLabel projectState=new JLabel();
    private JProgressBar proBar=new JProgressBar();


    private String number;
    private String name;
    private String startTime;
    private String stopTime;
    private String state;
    private int progress;

    public MyProjectModel(String number, String name, String StartTime, String StopTime,String state,int progress1){
        setLayout(new FlowLayout(0,10,0));
        setPreferredSize(new Dimension(880,30));
        number_Label.setPreferredSize(new Dimension(100,30));
        name_Label.setPreferredSize(new Dimension(120,30));
        startTime_Label.setPreferredSize(new Dimension(170,30));
        stopTime_Label.setPreferredSize(new Dimension(140,30));
        projectState.setPreferredSize(new Dimension(130,30));
        proBar.setPreferredSize(new Dimension(100,15));


        setNumber(number);
            JLabel blank=new JLabel();
            blank.setPreferredSize(new Dimension(15,30));
            add(blank);
        setName1(name);

        setStartTime(StartTime);
        setStopTime(StopTime);
        setState(state);
        JLabel blank1=new JLabel();
        blank1.setPreferredSize(new Dimension(15,30));
        add(blank1);
        setProgress(progress1);
    }


    private void setNumber(String number){
        this.number=number;
        number_Label.setText(number);
        number_Label.setFont(new Font("Î¢ÈíÑÅºÚ",Font.PLAIN,15));
        number_Label.setHorizontalAlignment(SwingConstants.CENTER);
        add(number_Label);
    }

    private String getNumber(){
        return number_Label.getText();
    }

    private void setName1(String name){
        this.name=name;
        name_Label.setText(name);
        name_Label.setFont(new Font("Î¢ÈíÑÅºÚ",Font.PLAIN,15));
        name_Label.setHorizontalAlignment(SwingConstants.CENTER);
        add(name_Label);
    }

    private String getName1(){
        return name_Label.getText();
    }

    private void setStartTime(String startTime){
        this.startTime=startTime;
        startTime_Label.setText(startTime);
        startTime_Label.setFont(new Font("Î¢ÈíÑÅºÚ",Font.PLAIN,15));
        startTime_Label.setHorizontalAlignment(SwingConstants.CENTER);
        add(startTime_Label);
    }

    private String getStartTime(){
        return startTime_Label.getText();
    }


    private void setStopTime(String stopTime){
        this.stopTime=stopTime;
        stopTime_Label.setText(stopTime);
        stopTime_Label.setFont(new Font("Î¢ÈíÑÅºÚ",Font.PLAIN,15));
        stopTime_Label.setHorizontalAlignment(SwingConstants.CENTER);
        add(stopTime_Label);
    }

    private String getStopTime(){
        return stopTime_Label.getText();
    }

    private String getState(){
        return projectState.getText();
    }

    private void setState(String state){
        this.state=state;
        projectState.setText(state);
        projectState.setFont(new Font("Î¢ÈíÑÅºÚ",Font.PLAIN,15));
        projectState.setHorizontalAlignment(SwingConstants.CENTER);
        add(projectState);
    }

    private void setProgress(int progress){
        proBar.setValue(progress);
        proBar.setForeground(Color.pink);
        add(proBar);
    }


}
