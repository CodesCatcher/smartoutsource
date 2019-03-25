package com.phydf.outsourceout.component;

import javax.swing.*;
import java.awt.*;

public class FrameMainTopPanel extends JPanel{

    private Image image;

    public FrameMainTopPanel(Image image){
        this.image = image;
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.drawImage(image,0,0,this.getWidth(), this.getHeight(), this);
    }
}
