package com.phydf.outsourceadmin.frames;

import com.phydf.outsourceadmin.utils.IconBuilder;

import javax.swing.*;
import java.awt.*;


public class StaffFrames extends JFrame {
    private Container container;

    private JTextField number = new JTextField();

    private JTextField name = new JTextField();

    private JTextField birth = new JTextField();

    private JTextField sex = new JTextField();

    private JTextField job = new JTextField();

    private JTextField team = new JTextField();

    private JTextField time = new JTextField();

    private JTextField project = new JTextField();

    private JTextField address = new JTextField();

    private JTextField post = new JTextField();

    /**
     * 项目描述
     */
    private JTextArea describe;

    /**
     * 项目资源
     */
    public StaffFrames(String str) {
        setTitle("查看人员");
        setSize(950, 650);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
        setVisible(true);

        container = getContentPane();

        JPanel topPanel = new JPanel();
        JPanel bottomPanel = new JPanel();
        JPanel top = new JPanel();
        topPanel.setPreferredSize(new Dimension(950, 360));
        topPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 30, 30));

        top.setPreferredSize(new Dimension(950, 250));
        top.setLayout(new FlowLayout(FlowLayout.RIGHT, 60, 0));

        bottomPanel.setPreferredSize(new Dimension(950, 200));
        bottomPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 30, 30));

        JLabel numberLabel = new JLabel("人员编号：");
        numberLabel.setFont(new Font("微软雅黑", Font.PLAIN, 15));
        number.setPreferredSize(new Dimension(300, 30));
        number.setFont(new Font("微软雅黑", Font.PLAIN, 15));

        JLabel nameLabel = new JLabel("人员名称：");
        nameLabel.setFont(new Font("微软雅黑", Font.PLAIN, 15));
        name.setPreferredSize(new Dimension(300, 30));
        name.setFont(new Font("微软雅黑", Font.PLAIN, 15));

        JLabel births = new JLabel("出生年月：");
        births.setFont(new Font("微软雅黑", Font.PLAIN, 15));
        birth.setPreferredSize(new Dimension(300, 30));
        birth.setFont(new Font("微软雅黑", Font.PLAIN, 15));

        JLabel sexs = new JLabel("性别：       ");
        sexs.setFont(new Font("微软雅黑", Font.PLAIN, 15));
        sex.setPreferredSize(new Dimension(300, 30));
        sex.setFont(new Font("微软雅黑", Font.PLAIN, 15));

        JLabel jobs = new JLabel("职务：       ");
        jobs.setFont(new Font("微软雅黑", Font.PLAIN, 15));
        job.setPreferredSize(new Dimension(300, 30));
        job.setFont(new Font("微软雅黑", Font.PLAIN, 15));

        JLabel teams = new JLabel("团队:       ");
        teams.setFont(new Font("微软雅黑", Font.PLAIN, 15));
        team.setPreferredSize(new Dimension(300, 30));
        team.setFont(new Font("微软雅黑", Font.PLAIN, 15));

        JLabel projects = new JLabel("项目:         ");
        projects.setFont(new Font("微软雅黑", Font.PLAIN, 15));
        project.setPreferredSize(new Dimension(300, 30));
        project.setFont(new Font("微软雅黑", Font.PLAIN, 15));

        JLabel times = new JLabel("出勤次数：");
        times.setFont(new Font("微软雅黑", Font.PLAIN, 15));
        time.setPreferredSize(new Dimension(300, 30));
        time.setFont(new Font("微软雅黑", Font.PLAIN, 15));

        JLabel addresss = new JLabel("家庭住址：");
        addresss.setFont(new Font("微软雅黑", Font.PLAIN, 15));
        address.setPreferredSize(new Dimension(300, 30));
        address.setFont(new Font("微软雅黑", Font.PLAIN, 15));

        JLabel posts = new JLabel("邮政编码：");
        posts.setFont(new Font("微软雅黑", Font.PLAIN, 15));
        post.setPreferredSize(new Dimension(300, 30));
        post.setFont(new Font("微软雅黑", Font.PLAIN, 15));

        ImageIcon img = new ImageIcon();
        JLabel image = new JLabel(img);


        if (str.equals("580430003")) {
            number.setText("580430003");
            name.setText("程咬金");
            birth.setText("1997-01-01");
            sex.setText("男");
            job.setText("程序员");
            time.setText("20");
            team.setText("Phydf");
            project.setText("整理资料");
            address.setText("杭州");
            post.setText("311010");
            img.setImage(getToolkit().getImage(IconBuilder.getUrl("staff01.jpg")));
        }
        if (str.equals("580430004")) {
            number.setText("580430004");
            name.setText("虞姬");
            birth.setText("1997-01-01");
            sex.setText("女");
            job.setText("程序员");
            time.setText("20");
            team.setText("Phydf");
            project.setText("服务外包");
            address.setText("北京");
            post.setText("311012");
            img.setImage(getToolkit().getImage(IconBuilder.getUrl("staff01.jpg")));
        }
        if (str.equals("580430005")) {
            number.setText("580430005");
            name.setText("安其拉");
            birth.setText("1997-01-01");
            sex.setText("男");
            job.setText("程序员");
            time.setText("20");
            team.setText("Phydf");
            project.setText("整理资料");
            address.setText("杭州");
            post.setText("311010");
            img.setImage(getToolkit().getImage(IconBuilder.getUrl("staff01.jpg")));
        }
        if (str.equals("580430006")) {
            number.setText("580430006");
            name.setText("哪吒");
            birth.setText("1997-01-01");
            sex.setText("男");
            job.setText("工程师");
            time.setText("20");
            team.setText("Phydf");
            project.setText("整理资料");
            address.setText("杭州");
            post.setText("311014");
            img.setImage(getToolkit().getImage(IconBuilder.getUrl("staff01.jpg")));
        }
        if (str.equals("580430007")) {
            number.setText("580430007");
            name.setText("橘右京");
            birth.setText("1997-01-01");
            sex.setText("男");
            job.setText("程序员");
            time.setText("20");
            team.setText("Phydf");
            project.setText("整理资料");
            address.setText("杭州");
            post.setText("311010");
            img.setImage(getToolkit().getImage(IconBuilder.getUrl("staff01.jpg")));
        }
        if (str.equals("580430008")) {
            number.setText("580430008");
            name.setText("王昭君");
            birth.setText("1997-01-01");
            sex.setText("男");
            job.setText("工程师");
            time.setText("21");
            team.setText("Phydf");
            project.setText("整理资料");
            address.setText("杭州");
            post.setText("311010");
            img.setImage(getToolkit().getImage(IconBuilder.getUrl("staff01.jpg")));
        }
        if (str.equals("580430009")) {
            number.setText("580430009");
            name.setText("貂蝉");
            birth.setText("1997-01-01");
            sex.setText("男");
            job.setText("程序员");
            time.setText("22");
            team.setText("Phydf");
            project.setText("整理资料");
            address.setText("杭州");
            post.setText("311011");
            img.setImage(getToolkit().getImage(IconBuilder.getUrl("staff01.jpg")));
        }


        topPanel.add(numberLabel);
        topPanel.add(number);
        topPanel.add(nameLabel);
        topPanel.add(name);

        topPanel.add(births);
        topPanel.add(birth);
        topPanel.add(sexs);
        topPanel.add(sex);
        topPanel.add(jobs);
        topPanel.add(job);
        topPanel.add(teams);
        topPanel.add(team);
        topPanel.add(times);
        topPanel.add(time);
        topPanel.add(projects);
        topPanel.add(project);
        topPanel.add(addresss);
        topPanel.add(address);
        topPanel.add(posts);
        topPanel.add(post);
        top.add(image);

        container.add(topPanel);
        container.add(top);

        validate();
    }

    public static void main(String[] args) {
        new StaffFrames("580430003");
    }
}
