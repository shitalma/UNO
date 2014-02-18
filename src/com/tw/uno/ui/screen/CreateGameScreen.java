package com.tw.uno.ui.screen;

import com.tw.uno.lib.ServerScreenObserver;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CreateGameScreen extends JFrame {
    private JLabel players;
    private JLabel packs;
    private JTextField playersField;
    private JTextField packsField;
    private JPanel panel;
    private JButton start;

    public CreateGameScreen(final ServerScreenObserver serverScreenObserver) {
        super("Create game screen");
        panel = new JPanel();
        players = new JLabel("Number of players : ");
        packs = new JLabel("Number of packs : ");

        playersField = new JTextField(15);
        packsField = new JTextField(15);
        start = new JButton(" START ");
        createFirstScreenFromServerSide();
        start.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                serverScreenObserver.onStartGame(playersField.getText(),packsField.getText());
            }
        });
    }

    public void createFirstScreenFromServerSide() {
        setSize(500,500);
        panel.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.gridx = 0;
        c.gridy = 0;
        panel.add(players, c);
        c.gridx = 1;
        c.gridy = 0;
        panel.add(playersField, c);
        c.gridx = 0;
        c.gridy = 1;
        panel.add(packs, c);
        c.gridx = 1;
        c.gridy = 1;
        panel.add(packsField, c);
        c.gridx = 1;
        c.gridy = 2;
        panel.add(start,c);
        add(panel);

        setVisible(true);
    }
}
