
/**
 * ����Ϊ��¼����
 * ���ߣ�������
 * ��ʼʱ�䣺2018-03-31
 */

package com.phydf.outsourceadmin.frames;

import com.phydf.outsourceadmin.connect.StringConnect;
import com.phydf.outsourceadmin.statics.Connects;
import com.phydf.outsourceadmin.utils.IconBuilder;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class FrameLogin extends JFrame {

    /**
     * �ײ�����
     */
    private Container contentPane;

    /**
     * �ײ����
     */
    private JPanel jPanel;

    /**
     * �������
     */
    private JPanel jPanelTop;

    /**
     * �ײ����
     */
    private JPanel jPanelBottom;

    /**
     * �ײ������Ϸ���壬���ڲ���
     */
    private JPanel jPanelBottom_Top;

    /**
     * �ײ������в���壬���ڷ��ı����������ť
     */
    private JPanel jPanelBottom_Center;

    /**
     * �ײ������²���壬���ڷŵ�¼��ť
     */
    private JPanel jPanelBottom_Bottom;

    /**
     * �ײ������в���������壬���ڷ�ͷ��
     */
    private JPanel jPanelBottom_Center_Left;

    /**
     * �ײ������в���������壬���ڷ��ı���
     */
    private JPanel jPanelBottom_Center_Center;

    /**
     * �ײ������в������Ҳ���壬���ڷ�������ť
     */
    private JPanel jPanelBottom_Center_Right;


    /**
     * �ײ������в������в������ϲ���壬���ڷ��ı���
     */
    private JPanel jPanelBottom_Center_Center_Top;

    /**
     * �ײ������в������в������²���壬���ڷ��ı���
     */
    private JPanel jPanelBottom_Center_Center_Bottom;

    /**
     * ͼƬ������
     */
    private JLabel backImage, accountImage, passwordImage, userImage;

    /**
     * �رհ�ť
     */
    private JLabel closeButton, registerButton, findpasswordButton;

    /**
     * �����ʺŵ��ı���
     */
    private JTextField accountText;

    /**
     * ����������ı���
     */
    private JPasswordField passwordText;

    /**
     * ��¼��ť
     */
    private JLabel loginButton;


    /**
     * ��¼����չ��캯��
     */
    public FrameLogin() {
        this(null, null);
    }

    /**
     * ��¼���湹�캯�����������ʺź�����
     */
    public FrameLogin(String accoutNumber, String passWord) {

        setSize(510, 390);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setVisible(true);

        contentPane = getContentPane();
        contentPane.setBackground(Color.WHITE);
        contentPane.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));

        jPanel = new JPanel();
        jPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
        jPanel.setPreferredSize(new Dimension(510, 390));
        jPanel.setBorder(javax.swing.BorderFactory.createLineBorder(Color.darkGray));

        jPanelTop = new JPanel();
        jPanelTop.setLayout(null);
        jPanelTop.setPreferredSize(new Dimension(getWidth() - 2, getHeight() * 17 / 30 + 1));

        jPanelBottom = new JPanel();
        jPanelBottom.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
        jPanelBottom.setBackground(Color.WHITE);
        jPanelBottom.setPreferredSize(new Dimension(getWidth() - 2, getHeight() * 13 / 30 - 4));

        jPanelBottom_Top = new JPanel();
        jPanelBottom_Top.setPreferredSize(new Dimension(getWidth() - 2, 20));
        jPanelBottom_Top.setBackground(Color.WHITE);

        jPanelBottom_Center = new JPanel();
        jPanelBottom_Center.setLayout(new FlowLayout(FlowLayout.CENTER, 4, 0));
        jPanelBottom_Center.setPreferredSize(new Dimension(getWidth() - 2, 70));
        jPanelBottom_Center.setBackground(Color.WHITE);

        jPanelBottom_Bottom = new JPanel();
        jPanelBottom_Bottom.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 10));
        jPanelBottom_Bottom.setPreferredSize(new Dimension(getWidth() - 2, 60));
        jPanelBottom_Bottom.setBackground(Color.WHITE);

        jPanelBottom_Center_Left = new JPanel();
        jPanelBottom_Center_Left.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 1));
        jPanelBottom_Center_Left.setPreferredSize(new Dimension(85, 80));
        jPanelBottom_Center_Left.setBackground(Color.WHITE);

        jPanelBottom_Center_Center = new JPanel();
        jPanelBottom_Center_Center.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 1));
        jPanelBottom_Center_Center.setPreferredSize(new Dimension(240, 77));
        jPanelBottom_Center_Center.setBackground(Color.gray);

        jPanelBottom_Center_Right = new JPanel();
        jPanelBottom_Center_Right.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 10));
        jPanelBottom_Center_Right.setPreferredSize(new Dimension(90, 80));
        jPanelBottom_Center_Right.setBackground(Color.WHITE);

        jPanelBottom_Center_Center_Top = new JPanel();
        jPanelBottom_Center_Center_Top.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 0));
        jPanelBottom_Center_Center_Top.setPreferredSize(new Dimension(238, 33));
        jPanelBottom_Center_Center_Top.setBackground(Color.WHITE);

        jPanelBottom_Center_Center_Bottom = new JPanel();
        jPanelBottom_Center_Center_Bottom.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 0));
        jPanelBottom_Center_Center_Bottom.setPreferredSize(new Dimension(238, 33));
        jPanelBottom_Center_Center_Bottom.setBackground(Color.WHITE);


        closeButton = new JLabel();
        closeButton.setSize(32, 32);
        closeButton.setLocation(getWidth() - closeButton.getWidth() - 8, 8);

        closeButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                dispose();
            }
        });

        backImage = new JLabel(new ImageIcon(getToolkit().getImage(IconBuilder.getUrl("Formlogin_top.png"))
                .getScaledInstance(getWidth() - 2, getHeight() / 30 * 17 + 2, 1)));
        backImage.setSize(getWidth() - 2, getHeight() / 30 * 17 + 2);
        backImage.setLocation(0, 0);

        userImage = new JLabel(new ImageIcon(getToolkit().getImage(IconBuilder.getUrl("Formlogin_user.png")).getScaledInstance(65, 65, 1)));
        userImage.setSize(65, 65);

        accountImage = new JLabel(new ImageIcon(getToolkit().getImage(IconBuilder.getUrl("account.png")).getScaledInstance(16, 16, 1)));
        accountImage.setSize(16, 16);

        accountText = new JTextField();
        accountText.setPreferredSize(new Dimension(170, 35));
        accountText.setFont(new Font("΢���ź�", Font.PLAIN, 15));
        accountText.setBorder(new EmptyBorder(0, 0, 0, 0));

        passwordImage = new JLabel(new ImageIcon(getToolkit().getImage(IconBuilder.getUrl("password.png")).getScaledInstance(16, 16, 1)));
        passwordImage.setSize(16, 16);

        passwordText = new JPasswordField();
        passwordText.setPreferredSize(new Dimension(170, 35));
        passwordText.setFont(new Font("΢���ź�", Font.PLAIN, 15));
        passwordText.setBorder(new EmptyBorder(0, 0, 0, 0));
        passwordText.setEchoChar((char) 8226);

        registerButton = new JLabel("   ע���ʺ�");
        registerButton.setFont(new Font("΢���ź�", Font.PLAIN, 15));
        registerButton.setForeground(Color.darkGray);

        findpasswordButton = new JLabel("   �һ�����");
        findpasswordButton.setFont(new Font("΢���ź�", Font.PLAIN, 15));
        findpasswordButton.setForeground(Color.darkGray);

        loginButton = new JLabel(new ImageIcon(getToolkit().getImage(IconBuilder.getUrl("Formlogin_login.png")).getScaledInstance(170, 36, 1)));
        loginButton.setSize(170, 36);
        loginButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                Connects.stringConnect.sendMessage("{admin_login[account:\"" + accountText.getText() +
                        "\",password:\"" + passwordText.getText() + "\"]}");
            }
        });

        contentPane.add(jPanel);

        jPanel.add(jPanelTop);
        jPanel.add(jPanelBottom);

        jPanelTop.add(closeButton);
        jPanelTop.add(backImage);

        jPanelBottom.add(jPanelBottom_Top);
        jPanelBottom.add(jPanelBottom_Center);
        jPanelBottom.add(jPanelBottom_Bottom);

        jPanelBottom_Center.add(jPanelBottom_Center_Left);
        jPanelBottom_Center.add(jPanelBottom_Center_Center);
        jPanelBottom_Center.add(jPanelBottom_Center_Right);
        jPanelBottom_Bottom.add(loginButton);

        jPanelBottom_Center_Left.add(userImage);
        jPanelBottom_Center_Center.add(jPanelBottom_Center_Center_Top);
        jPanelBottom_Center_Center.add(jPanelBottom_Center_Center_Bottom);
        jPanelBottom_Center_Right.add(registerButton);
        jPanelBottom_Center_Right.add(findpasswordButton);

        jPanelBottom_Center_Center_Top.add(accountImage);
        jPanelBottom_Center_Center_Top.add(accountText);
        jPanelBottom_Center_Center_Bottom.add(passwordImage);
        jPanelBottom_Center_Center_Bottom.add(passwordText);

        validate();

    }

}