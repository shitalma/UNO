package com.step.uno.client.screen.elements;

import com.step.uno.model.Player;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class Players extends JPanel {
    public Players(List<Player> players, List<String> remainingCards) {
        int count = 0;
        setLayout(new GridLayout(0, players.size(), 40, 40));
        for (Player player : players) {
            JButton b = new JButton(" "+player.name+"  \n   "+remainingCards.get(count));
            add(b);
            count++;
        }
    }
}