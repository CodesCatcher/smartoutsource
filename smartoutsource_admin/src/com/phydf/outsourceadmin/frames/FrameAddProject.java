package com.phydf.outsourceadmin.frames;

import com.phydf.outsourceadmin.statics.Varibles;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;

public class FrameAddProject extends JFrame {

    /**
     * �������
     */
    private Container container;

    /**
     * ��Ŀ���
     */
    private JTextField number = new JTextField();

    /**
     * ��Ŀ����
     */
    private JTextField name = new JTextField();

    /**
     * ��ȫ�ȼ�
     */
    private JComboBox<String> safety;

    /**
     * ���ȳ̶�
     */
    private JComboBox<String> urgency;

    /**
     * ��Ŀ����
     */
    private JTextArea describe;

    /**
     * ��Ŀ��Դ
     */
    private JLabel project = new JLabel("<html><u>��û��ѡ����Ҫ����Ŀ��Դ��</u></html>");


    public FrameAddProject() {

        setTitle("�����Ŀ");
        setSize(950, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setLayout(new FlowLayout(FlowLayout.CENTER,0,0));
        setVisible(true);

        container = getContentPane();

        JPanel topPanel = new JPanel();
        topPanel.setPreferredSize(new Dimension(950, 500));
        topPanel.setLayout(new FlowLayout(FlowLayout.LEFT,30,30));

        JLabel numberLabel = new JLabel("��Ŀ��ţ�");
        numberLabel.setFont(new Font("΢���ź�", Font.PLAIN, 15));
        number.setPreferredSize(new Dimension(300, 30));
        number.setText("280430001");

        JLabel nameLabel = new JLabel("��Ŀ���ƣ�");
        nameLabel.setFont(new Font("΢���ź�", Font.PLAIN, 15));
        name.setPreferredSize(new Dimension(300, 30));

        JLabel safeLabel = new JLabel("��ȫ�ȼ���");
        safeLabel.setFont(new Font("΢���ź�", Font.PLAIN, 15));


        String[] safelevel = {"�͵�", "�е�", "�ߵ�"};

        safety = new JComboBox<String>(safelevel);
        safety.setPreferredSize(new Dimension(300, 30));
        safety.setFont(new Font("΢���ź�", Font.PLAIN, 15));

        JLabel urgencyLabel = new JLabel("���ȳ̶ȣ�");
        urgencyLabel.setFont(new Font("΢���ź�", Font.PLAIN, 15));

        String[] urgencylevel = {"һ��", "����", "�ǳ�����"};
        urgency = new JComboBox<String>(urgencylevel);
        urgency.setFont(new Font("΢���ź�", Font.PLAIN, 15));
        urgency.setPreferredSize(new Dimension(300, 30));

        JLabel describeLabel = new JLabel("��Ŀ������");
        describeLabel.setFont(new Font("΢���ź�", Font.PLAIN, 15));

        describe = new JTextArea();
        describe.setFont(new Font("΢���ź�", Font.PLAIN, 15));

        JScrollPane desScroll = new JScrollPane(describe);
        desScroll.setPreferredSize(new Dimension(730, 250));

        JLabel projectLabel = new JLabel("��Ŀ��Դ��");
        projectLabel.setFont(new Font("΢���ź�", Font.PLAIN, 15));

        project.setFont(new Font("΢���ź�", Font.PLAIN, 15));

        JButton addProButton = new JButton("���");
        addProButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                JFileChooser jf = new JFileChooser();
                jf.showOpenDialog(FrameAddProject.this);//��ʾ�򿪵��ļ��Ի���
                File f = jf.getSelectedFile();//ʹ���ļ����ȡѡ����ѡ����ļ�
                String s = f.getAbsolutePath();//����·����
                project.setText("<html><u>" + s + "</u></html>");
            }
        });

        JButton addButton = new JButton("ȷ���½�");
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