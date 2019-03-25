package com.phydf.outsourceadmin.frames;

import com.phydf.outsourceadmin.component.*;
import com.phydf.outsourceadmin.statics.Frames;

import javax.swing.*;
import java.awt.*;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class FrameMain extends JFrame {

    private TopPanel toppanel = new TopPanel();
    private LeftPanel leftpanel = new LeftPanel();
    private FrameMainHomePage frameMainHomePage = new FrameMainHomePage();
    private FrameMainSettingPage frameMainSettingPage = new FrameMainSettingPage();
    private FrameMainProjectPage frameMainProjectPage = new FrameMainProjectPage();
    private FrameMainStaffPage frameMainStaffPage = new FrameMainStaffPage();
    private FrameMainJournalPage frameMainJournalPage = new FrameMainJournalPage();
    private CardLayout cardLayout;
    private Container container;
    private JPanel bottomPanel = new JPanel();

    JPanel top = new JPanel(),
            left = new JPanel(),
            right = new JPanel();

    public FrameMain() {

        setSize(1350, 800);
        setUndecorated(true);
        setLocationRelativeTo(null);
        setLayout(new FlowLayout(FlowLayout.CENTER, 1, 1));

        container = getContentPane();
        container.setBackground(new Color(34, 56, 69));

        bottomPanel.setPreferredSize(new Dimension(1348, 798));
        bottomPanel.setLayout(new BorderLayout());

        top.setBackground(Color.WHITE);
        top.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));
        left.setBackground(Color.WHITE);
        left.setLayout(new BorderLayout(0, 0));
        right.setBackground(Color.WHITE);
        cardLayout = new CardLayout();

        right.setLayout(cardLayout);

        right.add("FrameMainHomePage", frameMainHomePage);
        right.add("FrameMainSettingPage", frameMainSettingPage);
        right.add("FrameMainProjectPage", frameMainProjectPage);
        right.add("FrameMainStaffPage", frameMainStaffPage);
        right.add("FrameMainJournalPage", frameMainJournalPage);

        leftpanel.setPreferredSize(new Dimension(300, 0));
        top.add(toppanel);
        left.add(leftpanel);

        top.setPreferredSize(new Dimension(0, 116));
        left.setPreferredSize(new Dimension(300, 0));

        bottomPanel.add(top, BorderLayout.NORTH);
        bottomPanel.add(left, BorderLayout.WEST);
        bottomPanel.add(right, BorderLayout.CENTER);

        container.add(bottomPanel);
        validate();
        setVisible(true);

    }

    public void setPage(String page) {

        if (page.equals("FrameMainHomePage")) {
            cardLayout.show(right, page);
        } else if (page.equals("FrameMainSettingPage")) {
            cardLayout.show(right, page);
        } else if (page.equals("FrameMainProjectPage")) {
            cardLayout.show(right, page);
        } else if (page.equals("FrameMainStaffPage")) {
            cardLayout.show(right, page);
        } else if (page.equals("FrameMainJournalPage")) {
            cardLayout.show(right, page);
        }
    }

    public FrameMainHomePage getFrameMainHomePage() {
        return frameMainHomePage;
    }

    public FrameMainSettingPage getFrameMainSettingPage() {
        return frameMainSettingPage;
    }

    public FrameMainProjectPage getFrameMainProjectPage() {
        return frameMainProjectPage;
    }

    public FrameMainStaffPage getFrameMainStaffPage() {
        return frameMainStaffPage;
    }

    public FrameMainJournalPage getFrameMainJournalPage() {
        return frameMainJournalPage;
    }

    public void useSetTitle(String s){
        leftpanel.setAccountTitle(s);
    }

    public static void main(String[] args) {
        Frames.frameMain = new FrameMain();
        try {
            InetAddress inetAddress = InetAddress.getLocalHost();
            System.out.println(inetAddress.getHostAddress());
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        System.out.println();

    }

}
