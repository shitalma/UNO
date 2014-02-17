package com.tw.uno.screen;

import com.tw.uno.elements.*;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;

/**
 * keep tak of log
 */
public class GameMasterWindow extends JFrame{
    final static boolean shouldFill = true;
    final static boolean RIGHT_TO_LEFT = false;
    private static GridBagConstraints constraints;
    private static Container pane;

    public static void addComponentsToPane(Container pane) {
        if (RIGHT_TO_LEFT)
            pane.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);

        JPanel player,log;

        pane.setLayout(new GridBagLayout());
        constraints = new GridBagConstraints();
        if (shouldFill) {
            constraints.fill = GridBagConstraints.HORIZONTAL;
        }
        //adds players to grid 0,0
        player = new Players(Arrays.asList("Sandesh", "Ram", "Sheetal", "Aniket"),Arrays.asList("5", "8", "2", "6"));
        addToRow(player, 0, 0, 3);


        String[] logMessages = {"Aniket placed red 4", "Shital placed red 6", "Sandesh placed blue 6", "ram said UNO"};

        log = new Log(logMessages);

        addLogToFrame(log);

        addToRow(new Status(), 3,1,2);

        addToRow(new DrawButton(), 2,1,1);

        addToRow(new PileButton(),2,2,1 );

        addToRow(new WildCard().addAllButtons(),2,3,1);
    }

    private static void addLogToFrame(JPanel log) {
        constraints.weightx = 0.5;
        constraints.gridx = 3;
        constraints.gridy = 0;
        constraints.gridheight = 1;

        GameMasterWindow.pane.add(log, constraints);
    }

    private static void addToRow(JPanel panel, int gridY, int gridX, int width) {

        constraints.weightx = 0.5;
        constraints.gridx = gridX;
        constraints.gridy = gridY;
        constraints.gridwidth = width;

        pane.add(panel, constraints);
    }

    public GameMasterWindow() {
        setMinimumSize(new Dimension(400, 250));

        setMaximizedBounds(new Rectangle(800, 500));
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        //Set up the content pane.
        pane = getContentPane();
        addComponentsToPane(pane);

        //Display the window.
        pack();
        setVisible(true);
    }
}
