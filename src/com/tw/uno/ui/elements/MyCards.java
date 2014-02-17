package com.tw.uno.ui.elements;
import com.tw.uno.lib.NumberCard;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class MyCards extends JPanel{
    public MyCards(List<NumberCard> cards) {
        setLayout(new GridLayout(0, cards.size()));
        for (NumberCard card : cards) {
            JButton button = new JButton(card.toString());
            add(button);
        }
    }
}