package com.phydf.outsourceadmin.component;

import javax.swing.*;
import java.awt.*;

public class Main_RightBottomListPanel extends JPanel {

    private JLabel mesType = new JLabel();
    private JLabel mes = new JLabel();
    private JLabel clickToView = new JLabel("<html><u>µã»÷²é¿´</u><html>");
    private String messageType = null;
    private String message = null;
    private Color color;

    public Main_RightBottomListPanel(String messageType, String message) {

        mesType.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 12));
        mesType.setForeground(Color.red);
        mes.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 12));
        mes.setPreferredSize(new Dimension(160, 20));
        clickToView.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 12));

        setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));
        setmessageType(messageType);
        setmessage(message);
        setPreferredSize(new Dimension(300, 25));
        setBackground(new Color(224, 224, 224));

    }

    public void setmessageType(String messageType) {

        this.messageType = messageType;
        mesType.setText("[" + messageType + "]");
    }

    public String getmessageType() {
        return messageType;
    }

    public void setmessage(String message) {

        this.message = message;
        mes.setText(message);
    }

    public String getmessage() {
        return message;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
        setBackground(color);
    }

    public void addPanel(Color color) {
        add(mesType);
        add(new LayoutPanel(10, 25, color));
        add(mes);
        add(clickToView);
    }
}
