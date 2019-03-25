package com.phydf.outsourceadmin.component;

import javax.swing.*;
import java.awt.*;

public class StaffModel extends JPanel {

    private JLabel Staff_Number=new JLabel();
    private JLabel Staff_Name=new JLabel();
    private JLabel Staff_Sex=new JLabel();
    private JLabel Staff_birth=new JLabel();

    private JLabel Staff_Group=new JLabel();
    private JLabel Staff_Identity=new JLabel();

    private String name;
    private String number;
    private String sex;
    private String birth;

    private String groupName;
    private String identity;


    public String getNumber() {
        return Staff_Number.getText();
    }

    private void setNumber(String number) {
        this.number=number;
        Staff_Number.setText(number);
        Staff_Number.setPreferredSize(new Dimension(150,30));
        Staff_Number.setFont(new Font("Î¢ÈíÑÅºÚ",Font.PLAIN,15));
        Staff_Number.setHorizontalAlignment(SwingConstants.CENTER);
        add(Staff_Number);

    }

    public String getName() {
        return Staff_Name.getText();
    }

    public void setName(String name) {
        this.name = name;
        Staff_Name.setText(name);
        Staff_Name.setPreferredSize(new Dimension(150,30));
        Staff_Name.setFont(new Font("Î¢ÈíÑÅºÚ",Font.PLAIN,15));
        Staff_Name.setHorizontalAlignment(SwingConstants.CENTER);
        add(Staff_Name);
    }

    public String getSex() {
        return Staff_Sex.getText();
    }

    public void setSex(String sex) {
        this.sex = sex;
        Staff_Sex.setText(sex);
        Staff_Sex.setPreferredSize(new Dimension(150,30));
        Staff_Sex.setFont(new Font("Î¢ÈíÑÅºÚ",Font.PLAIN,15));
        Staff_Sex.setHorizontalAlignment(SwingConstants.CENTER);
        add(Staff_Sex);
    }

    public String getBirth() {
        return Staff_birth.getText();
    }

    public void setBirth(String birth) {
        this.birth = birth;
        Staff_birth.setText(birth);
        Staff_birth.setPreferredSize(new Dimension(150,30));
        Staff_birth.setFont(new Font("Î¢ÈíÑÅºÚ",Font.PLAIN,15));
        Staff_birth.setHorizontalAlignment(SwingConstants.CENTER);
        add(Staff_birth);
    }

    public String getGroupName1() {
        return Staff_Group.getText();
    }
    private void setGroupName(String groupName) {
        this.groupName=groupName;
        Staff_Group.setText(groupName);
        Staff_Group.setPreferredSize(new Dimension(150,30));
        Staff_Group.setFont(new Font("Î¢ÈíÑÅºÚ",Font.PLAIN,15));
        Staff_Group.setHorizontalAlignment(SwingConstants.CENTER);
        add(Staff_Group);

    }

    public String getIdentity() {
        return Staff_Identity.getText();
    }

    private void setIdentity(String identity) {
        this.identity=identity;
        Staff_Identity.setText(identity);
        Staff_Identity.setPreferredSize(new Dimension(150,30));
        Staff_Identity.setFont(new Font("Î¢ÈíÑÅºÚ",Font.PLAIN,15));
        Staff_Identity.setHorizontalAlignment(SwingConstants.CENTER);
        add(Staff_Identity);

    }

    public String getGroupName() {
        return Staff_Group.getText();
    }

    public StaffModel(String number, String name, String sex, String birth, String groupName, String identity){
        setLayout(new FlowLayout(1,0,0));
        setPreferredSize(new Dimension(1030,30));
        setNumber(number);
        setName(name);
        setSex(sex);
        setBirth(birth);
        setGroupName(groupName);
        setIdentity(identity);
        setBackground(new Color(200, 200, 200));
    }

}
