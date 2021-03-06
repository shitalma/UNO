package com.step.uno.client.screen;

import com.step.uno.client.controller.GameClientController;
import com.step.uno.client.view.JoinGameView;
import com.step.uno.client.view.PlayerView;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JoinScreen extends JFrame implements JoinGameView {
    JPanel loginPanel;
    JButton joinButton;
    JLabel label1;
    JLabel label2;
    JTextField masterAddress;
    JTextField player;
    final static boolean shouldWeightX = true;
    private GameClientController controller;

    public JoinScreen(GameClientController controller) {
        this.controller = controller;
        setTitle("Login");

        setSize(750, 500);

        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();

        int w = this.getSize().width;
        int h = this.getSize().height;
        int x = (dim.width - w) / 2;
        int y = (dim.height - h) / 2;
        this.setLocation(x, y);

        setDefaultCloseOperation(EXIT_ON_CLOSE);

        createControls();
        addControlsToPanel();

        add(loginPanel);
        this.addComponentsToPane(this.getContentPane());
        setVisible(true);
    }


    private void addControlsToPanel() {
        loginPanel.add(label1);
        loginPanel.add(masterAddress);
        loginPanel.add(label2);
        loginPanel.add(player);
        loginPanel.add(joinButton);
    }

    private void createControls() {
        loginPanel = new JPanel();
        joinButton = new JButton("JOIN");
        label1 = new JLabel("Game Master ");
        label2 = new JLabel("Player Name ");
        masterAddress = new JTextField("localhost");
        player = new JTextField("aa");
        masterAddress.setFont(new Font("sansserif", Font.BOLD, 25));
        label2.setFont(new Font("sansserif", Font.BOLD, 25));
        player.setFont(new Font("sansserif", Font.BOLD, 25));
        label1.setFont(new Font("sansserif", Font.BOLD, 25));
    }

    public void addComponentsToPane(Container pane) {

        GridBagLayout mgr = new GridBagLayout();
        pane.setLayout(mgr  );
        GridBagConstraints c = new GridBagConstraints();


        c.insets = new Insets(17,17,17,17);

        if (shouldWeightX) {
            c.weightx = 0.5;
        }
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 0;
        pane.add(label1, c);

        c.fill = GridBagConstraints.HORIZONTAL;
        c.ipady = 20;
        c.weightx = 0.5;
        c.gridx = 1;
        c.gridy = 0;
        pane.add(masterAddress, c);


        c.fill = GridBagConstraints.HORIZONTAL;
        c.ipady = 20;
        c.gridx = 0;
        c.gridy = 1;
        pane.add(label2, c);

        c.fill = GridBagConstraints.HORIZONTAL;
        c.ipady = 20;
        c.weightx = 0.5;
        c.gridx = 1;
        c.gridy = 1;
        pane.add(player, c);

        c.fill = GridBagConstraints.CENTER;
        c.ipady = 20;
        c.weighty = 1.0;
        c.gridx = 0;
        c.gridwidth = 2;
        c.gridy = 2;
        Border border3 = new LineBorder(Color.BLACK, 3);
        joinButton.setBorder(border3);
        joinButton.setPreferredSize(new Dimension(150, 50));
        joinButton.setFont(new Font("sansserif", Font.BOLD, 25));
        pane.add(joinButton, c);
    }

    @Override
    public PlayerView switchToPlayerView() {
        PlayerView view = new PlayerScreen();
        setVisible(false);
        return view;
    }

    public void showScreen() {
        controller.bindView(this);
        joinButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.join(masterAddress.getText(), player.getText());
                setVisible(false);
                System.out.println("Waiting...");
            }
        });

        setVisible(true);
    }
}