package com.tw.uno.ui.elements;

import com.tw.uno.lib.Player;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class Players extends JPanel {
    public Players(List<Player> players) {
        setLayout(new GridLayout(0, players.size(), 40, 40));
        for (Player player : players) {
            JButton button = new JButton(" " + player.getName() + "   \n   " + player.getCards().size());
            add(button);
        }
    }
}