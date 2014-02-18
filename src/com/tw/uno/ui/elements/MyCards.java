package com.tw.uno.ui.elements;

import com.tw.uno.controller.Controller;
import com.tw.uno.lib.Player;
import com.tw.uno.lib.card.Card;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class MyCards extends JPanel implements ActionListener {

    public MyCards(List<Card> cards) {
        setLayout(new GridLayout(0, cards.size()));
        for (Card card : cards) {
            JButton button = new JButton(card.toString());
            button.addActionListener(this);
            add(button);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Controller controller = new Controller();
        Card card;
        String[] s = e.getActionCommand().split(" ");

        card = controller.createCard(s[0], s[1]);
     //   controller.onCardPlace(card);
    }

}