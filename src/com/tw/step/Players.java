package com.tw.step;
import javax.swing.*;
import java.awt.*;
import java.util.List;

public class Players extends JPanel {
    public Players(List<String> players, List<String> remainingCards) {
        int count = 0;
        setLayout(new GridLayout(0, players.size(),40,40));
        for (String player : players) {
            JButton b = new JButton(" "+player+"  \n   "+remainingCards.get(count));
            add(b);
            count++;
        }
    }
}