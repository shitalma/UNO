package com.step.uno.client.screen.elements;

import com.step.uno.model.Player;
import com.step.uno.model.PlayerSummary;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.util.List;

public class Players extends JPanel {
    public Players(List<Player> players, List<PlayerSummary> remainingCards) {
        for (PlayerSummary remainingCard : remainingCards) {
            JPanel panel1 = new JPanel();
            JLabel label = new JLabel();
            label.setText("  >   ");
            label.setFont(new Font("sansserif", Font.BOLD, 80));
            JButton b = new JButton(" " + remainingCard.name + "  \n   " + remainingCard.cardsInHand);
            b.setLayout(null);
            b.setFont(new Font("sansserif", Font.BOLD, 25));
            b.setPreferredSize(new Dimension(175, 175));
            Border border2 = new LineBorder(Color.BLACK, 3);

            panel1.add(b);
            panel1.add(label);
            panel1.setBorder(border2);
            add(panel1);
        }
    }
}