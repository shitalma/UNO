package com.tw.uno.elements;
import javax.swing.*;
import java.awt.*;
import java.util.List;

public class Players extends JPanel {
    public Players(List<String> players, List<String> remaningCards) {
        int count = 0;
        setLayout(new GridLayout(0, players.size(),40,40));
        for (String player : players) {
            JButton b = new JButton(" "+player+"  \n   "+remaningCards.get(count));
            add(b);
            count++;
        }
    }
}