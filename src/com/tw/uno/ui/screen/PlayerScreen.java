package com.tw.uno.ui.screen;

import com.tw.uno.lib.Player;
import com.tw.uno.lib.UNOFactory;
import com.tw.uno.lib.card.Card;
import com.tw.uno.lib.card.CardColor;
import com.tw.uno.lib.card.CardValue;
import com.tw.uno.lib.card.NumberCard;
import com.tw.uno.ui.elements.*;

import javax.swing.*;
import java.awt.*;

import java.util.*;
import java.util.List;

public class PlayerScreen extends JFrame {
    final static boolean shouldFill = true;
    final static boolean RIGHT_TO_LEFT = false;
    private static GridBagConstraints constraints;
    private static Container pane;
    private final Dimension screenSize;

    public static void addComponentsToPane(Container pane) {
        UNOFactory factory = new UNOFactory();
        if (RIGHT_TO_LEFT)
            pane.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);

        JPanel player, cards, UNOButton, log, arrow;

        pane.setLayout(new GridBagLayout());
        constraints = new GridBagConstraints();
        if (shouldFill) {
            //natural height, maximum width
            constraints.fill = GridBagConstraints.HORIZONTAL;
//            constraints.fill = GridBagConstraints.VERTICAL;
        }
        //adds players to grid 0,0
//        player = new Players(Arrays.asList( new Player("Sandesh"), new Player("Ram"), new Player("Sheetal")));
//        addToRow(player, 0, 0, 3);

        List<Card> cards1 = new ArrayList<>();
        cards1.add(new NumberCard(CardColor.RED, CardValue.EIGHT));
        cards1.add(new NumberCard(CardColor.GREEN, CardValue.FOUR));
        Player myPlayer = new Player("player");
        myPlayer.addCards(cards1);
        cards = new MyCards(myPlayer);

        addToRow(cards, 4, 0, 2);
        UNOButton = new com.tw.uno.ui.elements.UNOButton();
        addToRow(UNOButton, 4, 3, 1);

        String[] logMessages = {"Aniket placed RED 4", "Shital placed RED 6", "Sandesh placed BLUE 6", "ram said UNO"};

        log = new Log(logMessages);

        addLogToFrame(log);
        arrow = new Arrow();
        addToRow(arrow, 1, 0
                , 3);
        addToRow(new Status(), 3, 1, 2);

        addToRow(new DrawButton(), 2, 1, 1);

        addToRow(new PileButton(factory.GetTopCardOnPile()), 2, 2, 1);

        addToRow(new WildCard().addAllButtons(), 2, 3, 1);
    }

    private static void addLogToFrame(JPanel log) {
        constraints.weightx = 0.5;
        constraints.gridx = 3;
        constraints.gridy = 0;
        constraints.gridheight = 1;

        PlayerScreen.pane.add(log, constraints);
    }

    private static void addToRow(JPanel panel, int gridY, int gridX, int width) {

        constraints.weightx = 0.5;
        constraints.gridx = gridX;
        constraints.gridy = gridY;
        constraints.gridwidth = width;

        pane.add(panel, constraints);
    }

    public PlayerScreen() {
        setTitle("Player's Screen");

        screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setMinimumSize(screenSize);

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