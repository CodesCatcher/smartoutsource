package com.phydf.outsourceadmin.frames;

import com.phydf.outsourceadmin.component.LayoutPanel;
import com.phydf.outsourceadmin.statics.Varibles;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;

public class FrameOutSource extends JFrame {

    /**
     * 内容面板
     */
    private Container container;

    /**
     * 项目编号
     */
    private JTextField projectNum = new JTextField();

    /**
     * 项目名称
     */
    private JTextField projectName = new JTextField();

    /**
     * 团队编号
     */
    private JTextField teamNum = new JTextField();

    /**
     * 团队名称
     */
    private JTextField teamName = new JTextField();

    /**
     * 项目描述
     */
    private JTextArea describe;

    /**
     * 合同
     */
    private JLabel hetong = new JLabel("<html><u>您没有选择合同图片！</u></html>");

    /**
     * 协议
     */
    private JLabel xieyi = new JLabel("<html><u>您没有选择保密协议图片！</u></html>");

    /**
     * 开始时间
     */
    private JTextField startTime = new JTextField();

    /**
     * 结束时间
     */
    private JTextField stopTime = new JTextField();

    /**
     * 发包备注
     */
    private JTextArea beizhu = new JTextArea();


    public FrameOutSource() {

        setTitle("发包");
        setSize(950, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
        setVisible(true);

        container = getContentPane();

        JPanel topPanel = new JPanel();
        topPanel.setPreferredSize(new Dimension(950, 480));
        topPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 30, 30));

        JLabel projectNumLabel = new JLabel("项目编号：");
        projectNumLabel.setFont(new Font("微软雅黑", Font.PLAIN, 15));
        projectNum.setPreferredSize(new Dimension(300, 30));
        projectNum.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                projectNum.setText("280430001");
                projectName.setText(Varibles.Proname);
            }
        });

        JLabel projectNameLabel = new JLabel("项目名称：");
        projectNameLabel.setFont(new Font("微软雅黑", Font.PLAIN, 15));
        projectName.setPreferredSize(new Dimension(300, 30));

        JLabel teamNumLabel = new JLabel("团队编号：");
        teamNumLabel.setFont(new Font("微软雅黑", Font.PLAIN, 15));
        teamNum.setPreferredSize(new Dimension(300, 30));

        JLabel teamNameLabel = new JLabel("团队名称：");
        teamNameLabel.setFont(new Font("微软雅黑", Font.PLAIN, 15));
        teamName.setPreferredSize(new Dimension(300, 30));
        teamName.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                teamName.setText("开心外包有限公司");
            }
        });

        JLabel startTimeLabel = new JLabel("开始时间：");
        startTimeLabel.setFont(new Font("微软雅黑", Font.PLAIN, 15));
        startTime.setPreferredSize(new Dimension(300, 30));

        JLabel stopTimeLabel = new JLabel("截止时间：");
        stopTimeLabel.setFont(new Font("微软雅黑", Font.PLAIN, 15));
        stopTime.setPreferredSize(new Dimension(300, 30));

        JLabel hetongLabel = new JLabel("团队合同：");
        hetongLabel.setFont(new Font("微软雅黑", Font.PLAIN, 15));
        hetong.setFont(new Font("微软雅黑", Font.PLAIN, 15));
        hetong.setPreferredSize(new Dimension(150,30));

        JLabel xieyiLabel = new JLabel("保密协议：");
        xieyiLabel.setFont(new Font("微软雅黑", Font.PLAIN, 15));
        xieyi.setFont(new Font("微软雅黑", Font.PLAIN, 15));
        xieyi.setPreferredSize(new Dimension(200,30));

        JButton addHetong = new JButton("上传");
        addHetong.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                JFileChooser jf = new JFileChooser();
                jf.showOpenDialog(FrameOutSource.this);//显示打开的文件对话框
                File f = jf.getSelectedFile();//使用文件类获取选择器选择的文件
                String s = f.getAbsolutePath();//返回路径名
                hetong.setText("<html><u>" + s + "</u></html>");
            }
        });


        JButton addXieyi = new JButton("上传");
        addXieyi.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                JFileChooser jf = new JFileChooser();
                jf.showOpenDialog(FrameOutSource.this);//显示打开的文件对话框
                File f = jf.getSelectedFile();//使用文件类获取选择器选择的文件
                String s = f.getAbsolutePath();//返回路径名
                xieyi.setText("<html><u>" + s + "</u></html>");
            }
        });

        JLabel beizhuLabel = new JLabel("发包备注：");
        beizhuLabel.setFont(new Font("微软雅黑", Font.PLAIN, 15));

        JScrollPane jScrollPane = new JScrollPane(beizhu);
        jScrollPane.setPreferredSize(new Dimension(730, 180));

        JButton submit = new JButton("发包");
        submit.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                dispose();
            }
        });

        topPanel.add(projectNumLabel);
        topPanel.add(projectNum);
        topPanel.add(projectNameLabel);
        topPanel.add(projectName);
        topPanel.add(teamNumLabel);
        topPanel.add(teamNum);
        topPanel.add(teamNameLabel);
        topPanel.add(teamName);
        topPanel.add(startTimeLabel);
        topPanel.add(startTime);
        topPanel.add(stopTimeLabel);
        topPanel.add(stopTime);
        topPanel.add(hetongLabel);
        topPanel.add(hetong);
        topPanel.add(addHetong);
        topPanel.add(new LayoutPanel(30, 10, new Color(238, 238, 238)));
        topPanel.add(xieyiLabel);
        topPanel.add(xieyi);
        topPanel.add(addXieyi);
        topPanel.add(new LayoutPanel(30, 10, new Color(238, 238, 238)));
        topPanel.add(beizhuLabel);
        topPanel.add(jScrollPane);

        container.add(topPanel);
        container.add(submit);
        validate();

    }

    public static void main(String[] args) {
        new FrameOutSource();
    }
}
