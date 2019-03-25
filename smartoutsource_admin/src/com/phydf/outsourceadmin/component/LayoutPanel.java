package com.phydf.outsourceadmin.component;

import javax.swing.*;
import java.awt.*;

public class LayoutPanel extends JPanel {

    public LayoutPanel(int width,int height,Color color){

        super();
        setPreferredSize(new Dimension(width,height));
        setBackground(color);

    }
}
