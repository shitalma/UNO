package com.step.uno.client.screen.elements;

import com.step.uno.model.Player;
import com.step.uno.model.PlayerSummary;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.util.List;

public class Players extends JPanel {
    public Players(List<PlayerSummary> remainingCards, int currentPlayerIndex) {
        PlayerSummary state;
        for (int i = 0; i < remainingCards.size(); i++) {
            JPanel panel1 = new JPanel();
            state= remainingCards.get(i);
            JButton b = new JButton(" " + state.name + "  \n   " + state.cardsInHand);
            b.setBackground(Color.WHITE);
            b.setLayout(null);
            b.setFont(new Font("sansserif", Font.BOLD, 22));
            b.setPreferredSize(new Dimension(140, 140));
            Border border2 = new LineBorder(Color.BLACK, 3);
            panel1.add(b);
            panel1.setBorder(border2);
            add(panel1);
            if(i == currentPlayerIndex)
                b.setBackground(Color.orange);
        }
    }
}