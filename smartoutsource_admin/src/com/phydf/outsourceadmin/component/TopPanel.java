package com.phydf.outsourceadmin.component;


import com.phydf.outsourceadmin.statics.Connects;
import com.phydf.outsourceadmin.utils.IconBuilder;
import com.phydf.outsourceadmin.statics.Frames;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class TopPanel extends JPanel {

    private MyPanel topbackpanel, topleft, topmiddle, topright;
    private JLabel loginImage, homepageImage, projectImage, staffImage, noteImage, setupImage;
    private JLabel closeImage, personImage;
    private ImageIcon image;
    private Image img;

    public TopPanel() {

        //图标设置
        image = new ImageIcon(getToolkit().getImage(IconBuilder.getUrl("Formmain_icon.jpg")));
        loginImage = new JLabel(image);
        //首页设置
        image = new ImageIcon(getToolkit().getImage(IconBuilder.getUrl("Formmain_shouye_click.jpg")));
        homepageImage = new JLabel(image);
        homepageImage.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                image = new ImageIcon(getToolkit().getImage(IconBuilder.getUrl("Formmain_shouye_click.jpg")));
                homepageImage.setIcon(image);
                image = new ImageIcon(getToolkit().getImage(IconBuilder.getUrl("Formmain_xiangmu.jpg")));
                projectImage.setIcon(image);
                image = new ImageIcon(getToolkit().getImage(IconBuilder.getUrl("Formmain_renyuan.jpg")));
                staffImage.setIcon(image);
                image = new ImageIcon(getToolkit().getImage(IconBuilder.getUrl("Formmain_rizhi.jpg")));
                noteImage.setIcon(image);
                image = new ImageIcon(getToolkit().getImage(IconBuilder.getUrl("Formmain_shezhi.jpg")));
                setupImage.setIcon(image);
                Frames.frameMain.setPage("FrameMainHomePage");
            }
        });
        //项目设置
        image = new ImageIcon(getToolkit().getImage(IconBuilder.getUrl("Formmain_xiangmu.jpg")));
        projectImage = new JLabel(image);
        projectImage.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                image = new ImageIcon(getToolkit().getImage(IconBuilder.getUrl("Formmain_shouye.jpg")));
                homepageImage.setIcon(image);
                image = new ImageIcon(getToolkit().getImage(IconBuilder.getUrl("Formmain_xiangmu_click.jpg")));
                projectImage.setIcon(image);
                image = new ImageIcon(getToolkit().getImage(IconBuilder.getUrl("Formmain_renyuan.jpg")));
                staffImage.setIcon(image);
                image = new ImageIcon(getToolkit().getImage(IconBuilder.getUrl("Formmain_rizhi.jpg")));
                noteImage.setIcon(image);
                image = new ImageIcon(getToolkit().getImage(IconBuilder.getUrl("Formmain_shezhi.jpg")));
                setupImage.setIcon(image);
                Frames.frameMain.setPage("FrameMainProjectPage");
                Frames.frameMain.getFrameMainProjectPage().clearProject();
                Connects.stringConnect.sendMessage("{admin_searchProject[content:\"\"]}");
            }
        });
        //人员设置
        image = new ImageIcon(getToolkit().getImage(IconBuilder.getUrl("Formmain_renyuan.jpg")));
        staffImage = new JLabel(image);
        staffImage.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                image = new ImageIcon(getToolkit().getImage(IconBuilder.getUrl("Formmain_shouye.jpg")));
                homepageImage.setIcon(image);
                image = new ImageIcon(getToolkit().getImage(IconBuilder.getUrl("Formmain_xiangmu.jpg")));
                projectImage.setIcon(image);
                image = new ImageIcon(getToolkit().getImage(IconBuilder.getUrl("Formmain_renyuan_click.jpg")));
                staffImage.setIcon(image);
                image = new ImageIcon(getToolkit().getImage(IconBuilder.getUrl("Formmain_rizhi.jpg")));
                noteImage.setIcon(image);
                image = new ImageIcon(getToolkit().getImage(IconBuilder.getUrl("Formmain_shezhi.jpg")));
                setupImage.setIcon(image);
                Frames.frameMain.setPage("FrameMainStaffPage");
            }
        });
        //日志设置
        image = new ImageIcon(getToolkit().getImage(IconBuilder.getUrl("Formmain_rizhi.jpg")));
        noteImage = new JLabel(image);
        noteImage.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                image = new ImageIcon(getToolkit().getImage(IconBuilder.getUrl("Formmain_shouye.jpg")));
                homepageImage.setIcon(image);
                image = new ImageIcon(getToolkit().getImage(IconBuilder.getUrl("Formmain_xiangmu.jpg")));
                projectImage.setIcon(image);
                image = new ImageIcon(getToolkit().getImage(IconBuilder.getUrl("Formmain_renyuan.jpg")));
                staffImage.setIcon(image);
                image = new ImageIcon(getToolkit().getImage(IconBuilder.getUrl("Formmain_rizhi_click.jpg")));
                noteImage.setIcon(image);
                image = new ImageIcon(getToolkit().getImage(IconBuilder.getUrl("Formmain_shezhi.jpg")));
                setupImage.setIcon(image);
                Frames.frameMain.setPage("FrameMainJournalPage");
            }
        });
        //设置图标设置
        image = new ImageIcon(getToolkit().getImage(IconBuilder.getUrl("Formmain_shezhi.jpg")));
        setupImage = new JLabel(image);
        setupImage.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                image = new ImageIcon(getToolkit().getImage(IconBuilder.getUrl("Formmain_shouye.jpg")));
                homepageImage.setIcon(image);
                image = new ImageIcon(getToolkit().getImage(IconBuilder.getUrl("Formmain_xiangmu.jpg")));
                projectImage.setIcon(image);
                image = new ImageIcon(getToolkit().getImage(IconBuilder.getUrl("Formmain_renyuan.jpg")));
                staffImage.setIcon(image);
                image = new ImageIcon(getToolkit().getImage(IconBuilder.getUrl("Formmain_rizhi.jpg")));
                noteImage.setIcon(image);
                image = new ImageIcon(getToolkit().getImage(IconBuilder.getUrl("Formmain_shezhi_click.jpg")));
                setupImage.setIcon(image);
                Frames.frameMain.setPage("FrameMainSettingPage");
            }
        });
        //个人中心设置
        image = new ImageIcon(getToolkit().getImage(IconBuilder.getUrl("Formmain_user.jpg")));
        personImage = new JLabel(image);
        //关闭设置
        image = new ImageIcon(getToolkit().getImage(IconBuilder.getUrl("Formmain_close.jpg")));
        closeImage = new JLabel(image);
        closeImage.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.exit(0);
            }
        });
        //背景设置
        image = new ImageIcon(getToolkit().getImage(IconBuilder.getUrl("dark.jpg")));
        img = image.getImage();
        topbackpanel = new MyPanel(img);
        topright = new MyPanel(img);
        topmiddle = new MyPanel(img);
        topleft = new MyPanel(img);

        //添加构件到toppanel
        topbackpanel.setPreferredSize(new Dimension(1350, 150));
        // topleft.setPreferredSize(new Dimension(341,150));
        //  topmiddle.setPreferredSize(new Dimension(1166,150));
        // topright.setPreferredSize(new Dimension(248,150));
        topleft.add(loginImage);
        topmiddle.add(homepageImage);
        topmiddle.add(projectImage);
        topmiddle.add(staffImage);
        topmiddle.add(noteImage);
        topmiddle.add(setupImage);
        topright.add(personImage);
        topright.add(closeImage);
        topbackpanel.setLayout(new BorderLayout());
        topbackpanel.add(topleft, BorderLayout.WEST);
        topbackpanel.add(topmiddle, BorderLayout.CENTER);
        topbackpanel.add(topright, BorderLayout.EAST);
        setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));
        add(topbackpanel);
        setPreferredSize(new Dimension(1350, 150));
    }
    //我的代码

    class MyPanel extends JPanel {
        private Image image;

        public MyPanel(Image image) {
            this.image = image;
            int width = Toolkit.getDefaultToolkit().getScreenSize().width;
            int height = Toolkit.getDefaultToolkit().getScreenSize().height;
            this.setSize(width, height);
        }

        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.drawImage(image, 0, 0, this.getWidth(), this.getHeight(), this);
        }
    }
}


