package com.tw.uno.ui.elements;

import com.tw.uno.lib.UNOFactory;
import com.tw.uno.lib.card.Card;
import com.tw.uno.lib.card.CardColor;
import com.tw.uno.lib.card.CardValue;
import com.tw.uno.lib.card.NumberCard;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MyCards extends JPanel implements ActionListener {
    private List<Card> cards = new ArrayList<>();

    public MyCards(List<Card> cards) {
        this.cards = cards;
        setLayout(new GridLayout(0, cards.size()));
        for (Card card : cards) {
            JButton button = new JButton(card.toString());
            button.addActionListener(this);
            add(button);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Card card;
        String[] s = e.getActionCommand().split(" ");
        card = new UNOFactory().createCard(s[0], s[1]);
        cards.remove(card);
    }
}