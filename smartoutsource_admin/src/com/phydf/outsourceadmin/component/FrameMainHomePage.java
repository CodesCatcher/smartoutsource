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
    private JButton search = new JButton("��ѯ");
    private int projectMaxIndex = 0;
    private int messageMaxIndex = 0;
    private JList<String> dynamicList;
    private DefaultListModel<String> dynamicModel = new DefaultListModel<String>();

    /**
     * ��ʾ���ȵ����
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

        JLabel leftTopTitle = new JLabel("��Ŀ�ſ�", SwingConstants.CENTER);//��Ŀ�ſ�����
        leftTopTitle.setPreferredSize(new Dimension(710, 25));
        leftTopTitle.setOpaque(true);
        leftTopTitle.setBackground(new Color(153, 180, 209));
        leftTopTitle.setFont(new Font("΢���ź�", Font.PLAIN, 15));

        leftTopPanel.add(leftTopTitle);
        JTextField textField = new JTextField();//ѡ���
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

        /*projectNumber ��Ŀ���*/
        JLabel projectNumber = new JLabel("��Ŀ���");
        projectNumber.setFont(new Font("΢���ź�", Font.PLAIN, 15));
        title.add(projectNumber);

        /*projectName ��Ŀ����*/
        JLabel projectName = new JLabel("��Ŀ����");
        projectName.setFont(new Font("΢���ź�", Font.PLAIN, 15));
        title.add(projectName);

        /*startTime ��ʼʱ��*/
        JLabel startTime = new JLabel("��ʼʱ��");
        startTime.setFont(new Font("΢���ź�", Font.PLAIN, 15));
        title.add(startTime);

        /*stopTime ��ֹʱ��*/
        JLabel stopTime = new JLabel("��ֹʱ��");
        stopTime.setFont(new Font("΢���ź�", Font.PLAIN, 15));
        title.add(stopTime);

        /*developTeam �����Ŷ�*/
        JLabel developTeam = new JLabel("�����Ŷ�");
        developTeam.setFont(new Font("΢���ź�", Font.PLAIN, 15));
        title.add(developTeam);

        /*projectState ��Ŀ״̬*/
        JLabel projectState = new JLabel("��Ŀ״̬");
        projectState.setFont(new Font("΢���ź�", Font.PLAIN, 15));
        title.add(projectState);

        /*developProgress ��������*/
        JLabel developProgress = new JLabel("��������");
        developProgress.setFont(new Font("΢���ź�", Font.PLAIN, 15));
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
        JLabel rightTopTitle = new JLabel("���¶�̬", SwingConstants.CENTER);//��Ŀ�ſ�����
        rightTopTitle.setPreferredSize(new Dimension(300, 25));
        rightTopTitle.setOpaque(true);
        rightTopTitle.setBackground(new Color(153, 180, 209));
        rightTopTitle.setFont(new Font("΢���ź�", Font.PLAIN, 15));
        rightTopPanel.add(rightTopTitle);


        dynamicList = new JList<String>(dynamicModel);
        dynamicList.setFont(new Font("΢���ź�", Font.PLAIN, 15));
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

        JLabel projectState2 = new JLabel("��Ŀ���ͳ��", SwingConstants.CENTER);//��Ŀ���ͳ�Ʊ���
        projectState2.setBackground(new Color(153, 180, 209));
        projectState2.setFont(new Font("΢���ź�", Font.PLAIN, 15));
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

        JLabel projectState3 = new JLabel("�ҵ���Ϣ", SwingConstants.CENTER);//�ҵ���Ϣ

        projectState3.setBackground(new Color(153, 180, 209));
        projectState3.setFont(new Font("΢���ź�", Font.PLAIN, 15));
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

        addMessageData("ϵͳ��Ϣ", "���յ�10��ϵͳ��Ϣ");
        addMessageData("��ҵ����", "�������Ǿ����˰κӱ�������ϲ���ڲ���ðκӱ�����һ����");
        addMessageData("֪ͨ��Ϣ", "�����л��飬�ڻ�����2-306�������������زμ�");
        addMessageData("��������", "���յ�1���ʼ��������ˣ�С��");
        addMessageData("֪ͨ��Ϣ", "����3����������δ�����뼰ʱ����");
        addMessageData("��ҵ����", "���죬�����쵼�Ӳ��ҹ�˾�������ҹ�˾�ķ�չ��������");
        addMessageData("֪ͨ��Ϣ", "�����л��飬�ڻ�����2-306�������������زμ�");
        addMessageData("��������", "���յ�1���ʼ��������ˣ��º��");

        addDynamicData("20:31:15","���","��¼ϵͳ");
        addDynamicData("19:30:53","�ܲ�","�˳�ϵͳ");
        addDynamicData("18:27:23","�߽���","��������");
        addDynamicData("17:15:14","³��","�ϴ����Ʒ�����");
        addDynamicData("16:10:06","��ɪ","������Դ");
        addDynamicData("15:59:42","��߸","δ��⵽����");
        addDynamicData("14:42:10","����","���ַǷ�����");
        addDynamicData("13:37:57","������","��ͣ����");
        addDynamicData("12:33:14","�ݼ�","��ϵͳ��⵽�Ƿ�����");
        addDynamicData("11:32:07","��ҧ��","��¼ϵͳ");
        addDynamicData("10:31:15","���","��¼ϵͳ");
        addDynamicData("09:30:53","�ܲ�","�˳�ϵͳ");
        addDynamicData("08:27:23","�߽���","��������");
        addDynamicData("07:15:14","³��","�ϴ����Ʒ�����");
        addDynamicData("06:10:06","��ɪ","������Դ");
        addDynamicData("05:59:42","��߸","δ��⵽����");
        addDynamicData("04:42:10","����","���ַǷ�����");
        addDynamicData("03:35:57","������","��ͣ����");
        addDynamicData("02:30:14","�ݼ�","��ϵͳ��⵽�Ƿ�����");
        addDynamicData("01:28:07","��ҧ��","��¼ϵͳ");

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
