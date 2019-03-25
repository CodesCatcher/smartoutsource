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
     * �������
     */
    private Container container;

    /**
     * ��Ŀ���
     */
    private JTextField projectNum = new JTextField();

    /**
     * ��Ŀ����
     */
    private JTextField projectName = new JTextField();

    /**
     * �Ŷӱ��
     */
    private JTextField teamNum = new JTextField();

    /**
     * �Ŷ�����
     */
    private JTextField teamName = new JTextField();

    /**
     * ��Ŀ����
     */
    private JTextArea describe;

    /**
     * ��ͬ
     */
    private JLabel hetong = new JLabel("<html><u>��û��ѡ���ͬͼƬ��</u></html>");

    /**
     * Э��
     */
    private JLabel xieyi = new JLabel("<html><u>��û��ѡ����Э��ͼƬ��</u></html>");

    /**
     * ��ʼʱ��
     */
    private JTextField startTime = new JTextField();

    /**
     * ����ʱ��
     */
    private JTextField stopTime = new JTextField();

    /**
     * ������ע
     */
    private JTextArea beizhu = new JTextArea();


    public FrameOutSource() {

        setTitle("����");
        setSize(950, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
        setVisible(true);

        container = getContentPane();

        JPanel topPanel = new JPanel();
        topPanel.setPreferredSize(new Dimension(950, 480));
        topPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 30, 30));

        JLabel projectNumLabel = new JLabel("��Ŀ��ţ�");
        projectNumLabel.setFont(new Font("΢���ź�", Font.PLAIN, 15));
        projectNum.setPreferredSize(new Dimension(300, 30));
        projectNum.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                projectNum.setText("280430001");
                projectName.setText(Varibles.Proname);
            }
        });

        JLabel projectNameLabel = new JLabel("��Ŀ���ƣ�");
        projectNameLabel.setFont(new Font("΢���ź�", Font.PLAIN, 15));
        projectName.setPreferredSize(new Dimension(300, 30));

        JLabel teamNumLabel = new JLabel("�Ŷӱ�ţ�");
        teamNumLabel.setFont(new Font("΢���ź�", Font.PLAIN, 15));
        teamNum.setPreferredSize(new Dimension(300, 30));

        JLabel teamNameLabel = new JLabel("�Ŷ����ƣ�");
        teamNameLabel.setFont(new Font("΢���ź�", Font.PLAIN, 15));
        teamName.setPreferredSize(new Dimension(300, 30));
        teamName.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                teamName.setText("����������޹�˾");
            }
        });

        JLabel startTimeLabel = new JLabel("��ʼʱ�䣺");
        startTimeLabel.setFont(new Font("΢���ź�", Font.PLAIN, 15));
        startTime.setPreferredSize(new Dimension(300, 30));

        JLabel stopTimeLabel = new JLabel("��ֹʱ�䣺");
        stopTimeLabel.setFont(new Font("΢���ź�", Font.PLAIN, 15));
        stopTime.setPreferredSize(new Dimension(300, 30));

        JLabel hetongLabel = new JLabel("�ŶӺ�ͬ��");
        hetongLabel.setFont(new Font("΢���ź�", Font.PLAIN, 15));
        hetong.setFont(new Font("΢���ź�", Font.PLAIN, 15));
        hetong.setPreferredSize(new Dimension(150,30));

        JLabel xieyiLabel = new JLabel("����Э�飺");
        xieyiLabel.setFont(new Font("΢���ź�", Font.PLAIN, 15));
        xieyi.setFont(new Font("΢���ź�", Font.PLAIN, 15));
        xieyi.setPreferredSize(new Dimension(200,30));

        JButton addHetong = new JButton("�ϴ�");
        addHetong.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                JFileChooser jf = new JFileChooser();
                jf.showOpenDialog(FrameOutSource.this);//��ʾ�򿪵��ļ��Ի���
                File f = jf.getSelectedFile();//ʹ���ļ����ȡѡ����ѡ����ļ�
                String s = f.getAbsolutePath();//����·����
                hetong.setText("<html><u>" + s + "</u></html>");
            }
        });


        JButton addXieyi = new JButton("�ϴ�");
        addXieyi.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                JFileChooser jf = new JFileChooser();
                jf.showOpenDialog(FrameOutSource.this);//��ʾ�򿪵��ļ��Ի���
                File f = jf.getSelectedFile();//ʹ���ļ����ȡѡ����ѡ����ļ�
                String s = f.getAbsolutePath();//����·����
                xieyi.setText("<html><u>" + s + "</u></html>");
            }
        });

        JLabel beizhuLabel = new JLabel("������ע��");
        beizhuLabel.setFont(new Font("΢���ź�", Font.PLAIN, 15));

        JScrollPane jScrollPane = new JScrollPane(beizhu);
        jScrollPane.setPreferredSize(new Dimension(730, 180));

        JButton submit = new JButton("����");
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
