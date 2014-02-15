package com.tw.step;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;

public class PlayerScreen extends JFrame {
    final static boolean shouldFill = true;
    final static boolean RIGHT_TO_LEFT = false;
    private static GridBagConstraints constraints;
    private static Container pane;

    public static void addComponentsToPane(Container pane) {
        if (RIGHT_TO_LEFT) {
            pane.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        }

        JPanel player, cards, UNOButton,log;

        pane.setLayout(new GridBagLayout());
        constraints = new GridBagConstraints();
        if (shouldFill) {
            //natural height, maximum width
            constraints.fill = GridBagConstraints.HORIZONTAL;
//            constraints.fill = GridBagConstraints.VERTICAL;
        }
        //adds players to grid 0,0
        player = new Players(Arrays.asList("Sandesh", "Ram","Sheetal","Aniket"));
        addToPane(player,0,0,3);

        cards = new MyCards(Arrays.asList("blue 1", "red 4", "yellow 8", "wild +4","blue 1", "red 4", "yellow 8", "wild +4"));
        addToPane(cards,4,0,2);

        UNOButton = new com.tw.step.UNOButton();
        addToPane(UNOButton, 4, 3, 1);

        String[] logMessages = {"Aniket placed red 4", "Shital placed red 6", "Sandesh placed blue 6", "ram said UNO"};

        log = new Log(logMessages);
        addToPane(log,0,3,1);
    }

    private static void addToPane(JPanel panel, int gridY,int gridX , int width) {

        constraints.weightx = 0.5;
        constraints.gridx = gridX;
        constraints.gridy = gridY;
        constraints.gridwidth = width;

        pane.add(panel, constraints);
    }

    public PlayerScreen() {
        setMinimumSize(new Dimension(400,250));

        setMaximizedBounds(new Rectangle(800, 500));
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        //Set up the content pane.
        pane = getContentPane();
        addComponentsToPane(pane);

        //Display the window.
        pack();
        setVisible(true);
    }

    public static void main(String[] args) {
        new PlayerScreen();
    }
}