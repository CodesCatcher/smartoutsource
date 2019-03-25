package com.phydf.outsourceadmin.component;

import com.phydf.outsourceadmin.frames.ProjectFrames;
import com.phydf.outsourceadmin.statics.Connects;
import com.phydf.outsourceadmin.utils.IconBuilder;

import javax.swing.*;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class FrameMainHomePage extends JPanel {

    private JPanel leftTopPanel = new JPanel();
    private JPanel rightTopPanel = new JPanel();
    private JPanel leftBottomPanel = new JPanel();
    private JPanel rightBottomPanel = new JPanel();
    private JPanel messagePanel = new JPanel();
    private JButton search = new JButton("查询");
    private int projectMaxIndex = 0;
    private int messageMaxIndex = 0;
    private JList<String> dynamicList;
    private DefaultListModel<String> dynamicModel = new DefaultListModel<String>();

    /**
     * 显示进度的面板
     */
    private JPanel display = new JPanel();

    public FrameMainHomePage() {

        setLayout(new FlowLayout(0, 10, 10));
        setPreferredSize(new Dimension(1050, 715));
        setBackground(Color.white);

        leftTopPanel.setPreferredSize(new Dimension(710, 400));
        leftTopPanel.setBackground(Color.white);
        leftTopPanel.setLayout(new FlowLayout(1, 10, 0));

        rightTopPanel.setPreferredSize(new Dimension(300, 400));
        rightTopPanel.setBackground(Color.white);
        rightTopPanel.setLayout(new FlowLayout(1, 10, 0));

        leftBottomPanel.setPreferredSize(new Dimension(710, 250));
        leftBottomPanel.setBackground(Color.white);

        rightBottomPanel.setPreferredSize(new Dimension(300, 250));
        rightBottomPanel.setBackground(Color.white);

        /**************************************************************************/
        /**
         * leftTopPanel
         */

        JLabel leftTopTitle = new JLabel("项目概况", SwingConstants.CENTER);//项目概况标题
        leftTopTitle.setPreferredSize(new Dimension(710, 25));
        leftTopTitle.setOpaque(true);
        leftTopTitle.setBackground(new Color(153, 180, 209));
        leftTopTitle.setFont(new Font("微软雅黑", Font.PLAIN, 15));

        leftTopPanel.add(leftTopTitle);
        JTextField textField = new JTextField();//选项框
        textField.setPreferredSize(new Dimension(350, 30));
        leftTopPanel.add(new LayoutPanel(710, 20, Color.white));
        leftTopPanel.add(textField);
        leftTopPanel.add(search);
        leftTopPanel.add(new LayoutPanel(710, 20, Color.white));

        search.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                clearProject();
                validate();
                Connects.stringConnect.sendMessage("{admin_searchHome[content:\"" + textField.getText() + "\"]}");
                textField.setText("");
                textField.requestFocus();
            }
        });

        JPanel title = new JPanel();
        title.setLayout(new FlowLayout(1, 30, 2));

        /*projectNumber 项目编号*/
        JLabel projectNumber = new JLabel("项目编号");
        projectNumber.setFont(new Font("微软雅黑", Font.PLAIN, 15));
        title.add(projectNumber);

        /*projectName 项目名称*/
        JLabel projectName = new JLabel("项目名称");
        projectName.setFont(new Font("微软雅黑", Font.PLAIN, 15));
        title.add(projectName);

        /*startTime 开始时间*/
        JLabel startTime = new JLabel("开始时间");
        startTime.setFont(new Font("微软雅黑", Font.PLAIN, 15));
        title.add(startTime);

        /*stopTime 截止时间*/
        JLabel stopTime = new JLabel("截止时间");
        stopTime.setFont(new Font("微软雅黑", Font.PLAIN, 15));
        title.add(stopTime);

        /*developTeam 开发团队*/
        JLabel developTeam = new JLabel("开发团队");
        developTeam.setFont(new Font("微软雅黑", Font.PLAIN, 15));
        title.add(developTeam);

        /*projectState 项目状态*/
        JLabel projectState = new JLabel("项目状态");
        projectState.setFont(new Font("微软雅黑", Font.PLAIN, 15));
        title.add(projectState);

        /*developProgress 开发进度*/
        JLabel developProgress = new JLabel("开发进度");
        developProgress.setFont(new Font("微软雅黑", Font.PLAIN, 15));
        title.add(developProgress);
        title.setPreferredSize(new Dimension(710, 25));

        leftTopPanel.add(title);

        display.setPreferredSize(new Dimension(710, 0));
        display.setLayout(new FlowLayout(0, 0, 0));

        JScrollPane scrollPane = new JScrollPane(display);
        scrollPane.setPreferredSize(new Dimension(710, 280));
        leftTopPanel.add(scrollPane);



        /****************************************************************************/
        /**
         * rightTopPannel
         */
        JLabel rightTopTitle = new JLabel("最新动态", SwingConstants.CENTER);//项目概况标题
        rightTopTitle.setPreferredSize(new Dimension(300, 25));
        rightTopTitle.setOpaque(true);
        rightTopTitle.setBackground(new Color(153, 180, 209));
        rightTopTitle.setFont(new Font("微软雅黑", Font.PLAIN, 15));
        rightTopPanel.add(rightTopTitle);


        dynamicList = new JList<String>(dynamicModel);
        dynamicList.setFont(new Font("微软雅黑", Font.PLAIN, 15));
        JScrollPane dyscroll = new JScrollPane(dynamicList);
        dyscroll.setPreferredSize(new Dimension(300, 340));

        rightTopPanel.add(new LayoutPanel(300, 30, Color.white));
        rightTopPanel.add(dyscroll);


        /********************************************************************************************/
        /**
         * leftBottomPanel
         */
        leftBottomPanel.setLayout(new FlowLayout(2, 10, 10));
        leftBottomPanel.setPreferredSize(new Dimension(710, 250));

        JLabel projectState2 = new JLabel("项目情况统计", SwingConstants.CENTER);//项目情况统计标题
        projectState2.setBackground(new Color(153, 180, 209));
        projectState2.setFont(new Font("微软雅黑", Font.PLAIN, 15));
        projectState2.setPreferredSize(new Dimension(710, 25));
        projectState2.setOpaque(true);
        leftBottomPanel.add(projectState2);
        JPanel picture = new JPanel();

        picture.setLayout(new FlowLayout(0, 10, 10));
        picture.setBackground(Color.WHITE);
        picture.setPreferredSize(new Dimension(710, 280));

        JLabel image1 = new JLabel(new ImageIcon(IconBuilder.getUrl("count1.png")));

        picture.add(image1);

        leftBottomPanel.add(picture);

        /**********************************************************************************************************/
        /**
         * rightBottomPanel
         */

        JLabel projectState3 = new JLabel("我的消息", SwingConstants.CENTER);//我的消息

        projectState3.setBackground(new Color(153, 180, 209));
        projectState3.setFont(new Font("微软雅黑", Font.PLAIN, 15));
        projectState3.setPreferredSize(new Dimension(300, 25));
        projectState3.setOpaque(true);

        rightBottomPanel.add(projectState3);
        messagePanel.setPreferredSize(new Dimension(300, 0));
        messagePanel.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 0));
        JScrollPane scrollpane = new JScrollPane(messagePanel);
        scrollpane.setPreferredSize(new Dimension(300, 198));

        rightBottomPanel.add(scrollpane);
        rightBottomPanel.setPreferredSize(new Dimension(300, 240));
        rightBottomPanel.setBackground(Color.white);

        /*********************************************************************************************************/
        add(leftTopPanel);
        add(rightTopPanel);
        add(leftBottomPanel);
        add(rightBottomPanel);

        addMessageData("系统消息", "您收到10封系统消息");
        addMessageData("企业新闻", "今天我们举行了拔河比赛，恭喜后勤部获得拔河比赛第一名！");
        addMessageData("通知消息", "晚上有会议，在会议室2-306，无特殊情况务必参加");
        addMessageData("邮箱提醒", "您收到1封邮件，发件人：小王");
        addMessageData("通知消息", "您有3件待办事宜未处理，请及时处理");
        addMessageData("企业新闻", "昨天，我市领导视察我公司，并对我公司的发展做出评价");
        addMessageData("通知消息", "晚上有会议，在会议室2-306，无特殊情况务必参加");
        addMessageData("邮箱提醒", "您收到1封邮件，发件人：陈红红");

        addDynamicData("20:31:15","李白","登录系统");
        addDynamicData("19:30:53","曹操","退出系统");
        addDynamicData("18:27:23","高渐离","结束工作");
        addDynamicData("17:15:14","鲁班","上传至云服务器");
        addDynamicData("16:10:06","亚瑟","下载资源");
        addDynamicData("15:59:42","哪吒","未检测到人脸");
        addDynamicData("14:42:10","吕布","出现非法操作");
        addDynamicData("13:37:57","安琪拉","暂停工作");
        addDynamicData("12:33:14","虞姬","被系统检测到非法人脸");
        addDynamicData("11:32:07","程咬金","登录系统");
        addDynamicData("10:31:15","李白","登录系统");
        addDynamicData("09:30:53","曹操","退出系统");
        addDynamicData("08:27:23","高渐离","结束工作");
        addDynamicData("07:15:14","鲁班","上传至云服务器");
        addDynamicData("06:10:06","亚瑟","下载资源");
        addDynamicData("05:59:42","哪吒","未检测到人脸");
        addDynamicData("04:42:10","吕布","出现非法操作");
        addDynamicData("03:35:57","安琪拉","暂停工作");
        addDynamicData("02:30:14","虞姬","被系统检测到非法人脸");
        addDynamicData("01:28:07","程咬金","登录系统");

        clearProject();
        validate();
        Connects.stringConnect.sendMessage("{admin_searchHome[content:\"" + textField.getText() + "\"]}");
        textField.setText("");

    }

    public void addProjectData(String projectNumber, String projectName, String startTime, String stopTime,
                               String developTeam, String projectState, int progress) {

        Main_LeftTopListPanel projectList = new Main_LeftTopListPanel(projectNumber, projectName, startTime, stopTime, developTeam, projectState, progress);
        if (projectMaxIndex % 2 == 0) {
            projectList.setColor(new Color(200, 200, 200));
            projectList.addPanel(new Color(200, 200, 200));
        } else {
            projectList.setColor(new Color(224, 224, 224));
            projectList.addPanel(new Color(224, 224, 224));
        }
        display.add(projectList);
        projectList.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                new ProjectFrames(projectList.getProjectNumber());
            }
        });
        display.setPreferredSize(new Dimension(710, 30 * (projectMaxIndex + 1)));
        projectMaxIndex++;
    }

    public void addMessageData(String messageType, String message) {

        Main_RightBottomListPanel messageList = new Main_RightBottomListPanel(messageType, message);
        if (messageMaxIndex % 2 != 0) {
            messageList.setColor(new Color(200, 200, 200));
            messageList.addPanel(new Color(200, 200, 200));
        } else {
            messageList.setColor(new Color(224, 224, 224));
            messageList.addPanel(new Color(224, 224, 224));
        }
        messagePanel.add(messageList);
        messagePanel.setPreferredSize(new Dimension(300, 25 * (messageMaxIndex + 1)));
        messageMaxIndex++;
    }

    public void addDynamicData(String time, String name, String event) {
        dynamicModel.addElement("  " + time + "        " + name + event);
    }

    public void clearProject() {
        display.removeAll();
        display.repaint();
        display.setPreferredSize(new Dimension(710, 0));
        projectMaxIndex = 0;
    }
}
