package com.step.uno.client.screen.elements;
import javax.swing.*;
import java.awt.*;
import java.util.List;

public class MyCards extends JPanel{
    public MyCards(List<String> cards) {
        setLayout(new GridLayout(0, cards.size()));
        for (String card : cards) {
            JButton b = new JButton(card);
            add(b);
        }
    }
}
