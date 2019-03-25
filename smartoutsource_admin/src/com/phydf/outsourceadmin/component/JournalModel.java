package com.phydf.outsourceadmin.component;

import javax.swing.*;
import java.awt.*;

public class JournalModel extends JPanel{

    private JLabel operateTime=new JLabel();
    private JLabel operateStaff=new JLabel();
    private JLabel IP=new JLabel();
    private JLabel operateDescription=new JLabel();
    private JLabel spacing=new JLabel();

    private String OTime;
    private String OStaff;
    private String OIP;
    private String ODescription;

    public String getOTime() {
        return OTime;
    }

    private void setOTime(String OTime) {
        this.OTime=OTime;
        operateTime.setText(OTime);
        operateTime.setPreferredSize(new Dimension(250,30));
        operateTime.setFont(new Font("Î¢ÈíÑÅºÚ",Font.PLAIN,15));
        operateTime.setHorizontalAlignment(SwingConstants.CENTER);
        add(operateTime);

    }

    public String getOStaff() {
        return OStaff;
    }

    public void setOStaff(String OStaff) {
        this.OStaff = OStaff;
        operateStaff.setText(OStaff);
        operateStaff.setPreferredSize(new Dimension(100,30));
        operateStaff.setFont(new Font("Î¢ÈíÑÅºÚ",Font.PLAIN,15));
        operateStaff.setHorizontalAlignment(SwingConstants.CENTER);

        add(operateStaff);
    }

    public String getIP() {
        return OIP;
    }

    public void setIP(String OIP) {
        this.OIP = OIP;
        IP.setText(OIP);
        IP.setPreferredSize(new Dimension(150,30));
        IP.setFont(new Font("Î¢ÈíÑÅºÚ",Font.PLAIN,15));
        IP.setHorizontalAlignment(SwingConstants.CENTER);
        add(IP);
    }

    public void setODescription(String ODescription) {
        this.ODescription = ODescription;
        operateDescription.setText(ODescription);
        operateDescription.setPreferredSize(new Dimension(450,30));
        operateDescription.setFont(new Font("Î¢ÈíÑÅºÚ",Font.PLAIN,15));
        operateDescription.setHorizontalAlignment(SwingConstants.CENTER);

        add(operateDescription);
    }

    public String getOperation() {
        return ODescription;
    }

    public JournalModel(String OTime,String OStaff,String OIP,String ODescription){
        setLayout(new FlowLayout(0,10,0));
        setPreferredSize(new Dimension(1030,30));

        setOTime(OTime);
        setOStaff(OStaff);
        setIP(OIP);
        setODescription(ODescription);
        setBackground(new Color(200, 200, 200));
    }

}