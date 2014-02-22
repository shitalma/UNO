package com.step.uno.server.view;

import com.step.uno.factory.Factory;
import com.step.uno.server.controller.GameMasterController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Arc2D;

public class CreateGameScreen extends JFrame {
    private JLabel players;
    private JLabel packs;
    private JTextField playersField;
    private JTextField packsField;
    private JPanel panel;
    private JButton start;

    public CreateGameScreen() {
        super("Create game screen");
        panel = new JPanel();
        players = new JLabel("Number of players : ");
        packs = new JLabel("Number of packs : ");
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        playersField = new JTextField(15);

        packsField = new JTextField("1" ,15);
        start = new JButton(" START ");
        createFirstScreenFromServerSide();
        start.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                int numberOfPlayers = Integer.parseInt(playersField.getText());
                int noOfPacks = Integer.parseInt(packsField.getText());
                GameMasterController controller = new GameMasterController(numberOfPlayers, noOfPacks, new Factory());
            }
        });
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();

        int w = this.getSize().width;
        int h = this.getSize().height;
        int x = (dim.width - w) / 2;
        int y = (dim.height - h) / 2;
        this.setLocation(x, y);

    }

    public void createFirstScreenFromServerSide() {
        setSize(800, 500);
        panel.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();

        players.setFont(new Font("sansserif", Font.BOLD, 25));
        playersField.setFont(new Font("sansserif", Font.BOLD, 25));
        packs.setFont(new Font("sansserif", Font.BOLD, 25));
        packsField.setFont(new Font("sansserif", Font.BOLD, 25));
        start.setFont(new Font("sansserif", Font.BOLD, 25));

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
        panel.add(start, c);
        add(panel);

        setVisible(true);
    }

    public static void main(String[] args) {
        new CreateGameScreen();
    }
}
