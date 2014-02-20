package com.step.uno.client.screen.elements;
import com.step.uno.model.Card;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class MyCards extends JPanel{
    public MyCards(List<Card> cards) {
        setLayout(new GridLayout(0, cards.size()));
        for (Card card : cards) {
            JButton b = new JButton(card.toString());
            add(b);
        }
    }
}
