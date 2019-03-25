package com.phydf.outsourceadmin.frames;

import com.phydf.outsourceadmin.statics.Varibles;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;

public class FrameAddProject extends JFrame {

    /**
     * 内容面板
     */
    private Container container;

    /**
     * 项目编号
     */
    private JTextField number = new JTextField();

    /**
     * 项目名称
     */
    private JTextField name = new JTextField();

    /**
     * 安全等级
     */
    private JComboBox<String> safety;

    /**
     * 紧迫程度
     */
    private JComboBox<String> urgency;

    /**
     * 项目描述
     */
    private JTextArea describe;

    /**
     * 项目资源
     */
    private JLabel project = new JLabel("<html><u>您没有选择需要的项目资源！</u></html>");


    public FrameAddProject() {

        setTitle("添加项目");
        setSize(950, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setLayout(new FlowLayout(FlowLayout.CENTER,0,0));
        setVisible(true);

        container = getContentPane();

        JPanel topPanel = new JPanel();
        topPanel.setPreferredSize(new Dimension(950, 500));
        topPanel.setLayout(new FlowLayout(FlowLayout.LEFT,30,30));

        JLabel numberLabel = new JLabel("项目编号：");
        numberLabel.setFont(new Font("微软雅黑", Font.PLAIN, 15));
        number.setPreferredSize(new Dimension(300, 30));
        number.setText("280430001");

        JLabel nameLabel = new JLabel("项目名称：");
        nameLabel.setFont(new Font("微软雅黑", Font.PLAIN, 15));
        name.setPreferredSize(new Dimension(300, 30));

        JLabel safeLabel = new JLabel("安全等级：");
        safeLabel.setFont(new Font("微软雅黑", Font.PLAIN, 15));


        String[] safelevel = {"低等", "中等", "高等"};

        safety = new JComboBox<String>(safelevel);
        safety.setPreferredSize(new Dimension(300, 30));
        safety.setFont(new Font("微软雅黑", Font.PLAIN, 15));

        JLabel urgencyLabel = new JLabel("紧迫程度：");
        urgencyLabel.setFont(new Font("微软雅黑", Font.PLAIN, 15));

        String[] urgencylevel = {"一般", "紧迫", "非常紧迫"};
        urgency = new JComboBox<String>(urgencylevel);
        urgency.setFont(new Font("微软雅黑", Font.PLAIN, 15));
        urgency.setPreferredSize(new Dimension(300, 30));

        JLabel describeLabel = new JLabel("项目描述：");
        describeLabel.setFont(new Font("微软雅黑", Font.PLAIN, 15));

        describe = new JTextArea();
        describe.setFont(new Font("微软雅黑", Font.PLAIN, 15));

        JScrollPane desScroll = new JScrollPane(describe);
        desScroll.setPreferredSize(new Dimension(730, 250));

        JLabel projectLabel = new JLabel("项目资源：");
        projectLabel.setFont(new Font("微软雅黑", Font.PLAIN, 15));

        project.setFont(new Font("微软雅黑", Font.PLAIN, 15));

        JButton addProButton = new JButton("添加");
        addProButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                JFileChooser jf = new JFileChooser();
                jf.showOpenDialog(FrameAddProject.this);//显示打开的文件对话框
                File f = jf.getSelectedFile();//使用文件类获取选择器选择的文件
                String s = f.getAbsolutePath();//返回路径名
                project.setText("<html><u>" + s + "</u></html>");
            }
        });

        JButton addButton = new JButton("确认新建");
        addButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                Varibles.Proname = name.getText();
                dispose();
            }
        });

        topPanel.add(numberLabel);
        topPanel.add(number);
        topPanel.add(nameLabel);
        topPanel.add(name);
        topPanel.add(safeLabel);
        topPanel.add(safety);
        topPanel.add(urgencyLabel);
        topPanel.add(urgency);
        topPanel.add(describeLabel);
        topPanel.add(desScroll);
        topPanel.add(projectLabel);
        topPanel.add(project);
        topPanel.add(addProButton);

        container.add(topPanel);
        container.add(addButton);

        validate();

    }

    public static void main(String[] args) {
        new FrameAddProject();
    }

}