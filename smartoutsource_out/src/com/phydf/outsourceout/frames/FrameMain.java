/**
 * 此类为外包端主界面
 * 作者：丁泉波
 * 开始时间：2018-03-31
 */
package com.phydf.outsourceout.frames;

import com.phydf.outsourceout.component.*;
import com.phydf.outsourceout.utils.IconBuilder;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class FrameMain extends JFrame {

    /**
     * 底部容器
     */
    private Container contentPane;

    /**
     * 卡片布局的容器
     */
    private JPanel cardPanel;

    /**
     * 卡片布局
     */
    private CardLayout card;

    /**
     * 顶部面板
     */
    private FrameMainTopPanel topJPanel;

    /**
     * 图片的容器
     */
    private JLabel logoImage, homepageButton, projectButton, settingButton;

    /**
     * 关闭
     */
    private JLabel closeImage, personImage;

    /**
     * 图片
     */
    private ImageIcon image;

    /**
     * 背景图片
     */
    private Image img;

    /**
     * 空格，用于调节间距
     */
    private JLabel kong1, kong2;

    /**
     * 底层面板，用于边框线
     */
    private JPanel bottomPanel = new JPanel(new BorderLayout());

    /**
     * 构造函数
     */
    public FrameMain() {

        setSize(1200, 800);
        setLocationRelativeTo(null);
        setUndecorated(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout(FlowLayout.CENTER,1,1));
        setVisible(true);

        contentPane = getContentPane();
        contentPane.setBackground(new Color(34,56,69));

        bottomPanel.setPreferredSize(new Dimension(1198, 798));
        bottomPanel.setLayout(new BorderLayout());

        card = new CardLayout();
        cardPanel = new JPanel();
        cardPanel.setLayout(card);
        cardPanel.add("FrameMainHomePage", new FrameMainHomePage());
        cardPanel.add("FrameMainProjectPage", new FrameMainProjectPage());
        cardPanel.add("FrameMainSettingPage", new FrameMainSettingPage());


        bottomPanel.add(cardPanel, BorderLayout.CENTER);

        image = new ImageIcon(getToolkit().getImage(IconBuilder.getUrl("Formmain_icon.jpg")));
        logoImage = new JLabel(image);

        image = new ImageIcon(getToolkit().getImage(IconBuilder.getUrl("Formmain_shouye_click.jpg")));
        homepageButton = new JLabel(image);
        homepageButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                image = new ImageIcon(getToolkit().getImage(IconBuilder.getUrl("Formmain_shouye_click.jpg")));
                homepageButton.setIcon(image);
                image = new ImageIcon(getToolkit().getImage(IconBuilder.getUrl("Formmain_xiangmu.jpg")));
                projectButton.setIcon(image);
                image = new ImageIcon(getToolkit().getImage(IconBuilder.getUrl("Formmain_shezhi.jpg")));
                settingButton.setIcon(image);
                card.show(cardPanel, "FrameMainHomePage");
            }
        });

        image = new ImageIcon(getToolkit().getImage(IconBuilder.getUrl("Formmain_xiangmu.jpg")));
        projectButton = new JLabel(image);
        projectButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                image = new ImageIcon(getToolkit().getImage(IconBuilder.getUrl("Formmain_xiangmu_click.jpg")));
                projectButton.setIcon(image);
                image = new ImageIcon(getToolkit().getImage(IconBuilder.getUrl("Formmain_shouye.jpg")));
                homepageButton.setIcon(image);
                image = new ImageIcon(getToolkit().getImage(IconBuilder.getUrl("Formmain_shezhi.jpg")));
                settingButton.setIcon(image);
                card.show(cardPanel, "FrameMainProjectPage");
            }
        });

        image = new ImageIcon(getToolkit().getImage(IconBuilder.getUrl("Formmain_shezhi.jpg")));
        settingButton = new JLabel(image);
        settingButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                image = new ImageIcon(getToolkit().getImage(IconBuilder.getUrl("Formmain_shezhi_click.jpg")));
                settingButton.setIcon(image);
                image = new ImageIcon(getToolkit().getImage(IconBuilder.getUrl("Formmain_shouye.jpg")));
                homepageButton.setIcon(image);
                image = new ImageIcon(getToolkit().getImage(IconBuilder.getUrl("Formmain_xiangmu.jpg")));
                projectButton.setIcon(image);
                card.show(cardPanel, "FrameMainSettingPage");
            }
        });

        image = new ImageIcon(getToolkit().getImage(IconBuilder.getUrl("Formmain_user.jpg")));
        personImage = new JLabel(image);

        image = new ImageIcon(getToolkit().getImage(IconBuilder.getUrl("Formmain_close.jpg")));
        closeImage = new JLabel(image);
        closeImage.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.exit(0);
            }
        });

        image = new ImageIcon(getToolkit().getImage(IconBuilder.getUrl("dark.jpg")));
        img = image.getImage();

        topJPanel = new FrameMainTopPanel(img);
        GridBagLayout gridBagLayout = new GridBagLayout();
        GridBagConstraints gridBagConstraints = new GridBagConstraints();
        topJPanel.setLayout(gridBagLayout);

        gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1;
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagLayout.setConstraints(logoImage, gridBagConstraints);
        topJPanel.add(logoImage);

        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridwidth = 3;
        kong1 = new JLabel();
        gridBagLayout.setConstraints(kong1, gridBagConstraints);
        topJPanel.add(kong1);

        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridwidth = 1;
        gridBagLayout.setConstraints(homepageButton, gridBagConstraints);
        topJPanel.add(homepageButton);

        gridBagConstraints.gridx = 5;
        gridBagLayout.setConstraints(projectButton, gridBagConstraints);
        topJPanel.add(projectButton);

        gridBagConstraints.gridx = 6;
        gridBagLayout.setConstraints(settingButton, gridBagConstraints);
        topJPanel.add(settingButton);

        gridBagConstraints.gridx = 7;
        kong2 = new JLabel();
        gridBagLayout.setConstraints(kong2, gridBagConstraints);
        topJPanel.add(kong2);

        gridBagConstraints.gridx = 8;
        gridBagLayout.setConstraints(personImage, gridBagConstraints);
        topJPanel.add(personImage);

        gridBagConstraints.gridx = 9;
        gridBagConstraints.gridwidth = 0;
        gridBagLayout.setConstraints(closeImage, gridBagConstraints);
        topJPanel.add(closeImage);

        topJPanel.setPreferredSize(new Dimension(1200, 100));
        bottomPanel.add(topJPanel, BorderLayout.NORTH);

        bottomPanel.add(new LeftPanel(),BorderLayout.WEST);

        contentPane.add(bottomPanel);
        validate();

    }

    public static void main(String[] args) {
        new FrameMain();
    }
}
