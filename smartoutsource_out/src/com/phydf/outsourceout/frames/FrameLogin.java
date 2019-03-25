
/**
 * ����Ϊ��¼����
 * ���ߣ�������
 * ��ʼʱ�䣺2018-03-31
 */

package com.phydf.outsourceout.frames;

import com.phydf.outsourceout.control.StringMessageControl;
import com.phydf.outsourceout.statics.Frames;
import com.phydf.outsourceout.utils.IconBuilder;
import com.phydf.outsourceout.utils.QRFactory;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

public class FrameLogin extends JFrame {

    /**
     * �������
     */
    private JPanel topPanel;

    /**
     * �ײ����
     */
    private JPanel bottomPanel;

    /**
     * ����
     */
    private JLabel title;

    /**
     * �رհ�ťͼƬ
     */
    private ImageIcon closeImage;

    /**
     * �رհ�ť
     */
    private JLabel closeButton;

    /**
     * ��ά��ͼƬ
     */
    private ImageIcon qrImage;

    /**
     * ��ά������
     */
    private JLabel qrCode;

    /**
     * ��ʾ��
     */
    private JLabel text;

    /**
     * �ײ����
     */
    private Container container;

    StringMessageControl stringMessageControl = new StringMessageControl();

    /**
     * ���캯��
     */
    public FrameLogin() {


        setUndecorated(true);
        setSize(300, 400);
        setVisible(true);
        setLocationRelativeTo(null);
        setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));

        container = getContentPane();
        container.setBackground(Color.WHITE);

        topPanel = new JPanel();
        topPanel.setPreferredSize(new Dimension(298, 40));
        topPanel.setLayout(null);
        topPanel.setBackground(Color.white);

        bottomPanel = new JPanel();
        bottomPanel.setPreferredSize(new Dimension(298, 360));
        bottomPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 30));
        bottomPanel.setBackground(Color.WHITE);

        title = new JLabel("�����������ƽ̨");
        title.setFont(new Font("΢���ź�", Font.PLAIN, 16));
        title.setBounds(25, 15, 150, 20);
        title.setForeground(Color.BLACK);
        title.setBackground(Color.WHITE);
        title.setOpaque(true);

        closeImage = new ImageIcon(getToolkit().getImage(IconBuilder.getUrl("close.png")));

        qrImage = new ImageIcon();
        qrImage.setImage(QRFactory.getQRImage("akfshvuinawiobwfuiovjaslngasl"));

        closeButton = new JLabel(closeImage);
        closeButton.setBounds(260, 7, 32, 32);

        closeButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                dispose();
            }
        });

        qrCode = new JLabel(qrImage);
        text = new JLabel("�����ֻ�appɨ���Ϸ���ά��");
        text.setFont(new Font("΢���ź�", Font.PLAIN, 17));
        text.setForeground(Color.DARK_GRAY);

        qrCode.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                dispose();
                Frames.frameMain = new FrameMain();
            }
        });

        topPanel.add(title);
        topPanel.add(closeButton);

        bottomPanel.add(qrCode);
        bottomPanel.add(text);

        container.add(topPanel);
        container.add(bottomPanel);

        validate();
    }

    public void setQrImage(BufferedImage image) {
        qrImage.setImage(image);
        qrCode.setIcon(qrImage);
        repaint();
    }

    public StringMessageControl getStringMessageControl() {
        return stringMessageControl;
    }

    public static void main(String[] args) {
        Frames.frameLogin = new FrameLogin();
    }

}