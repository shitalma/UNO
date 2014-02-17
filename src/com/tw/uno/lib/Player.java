package com.tw.uno.lib;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

/**
 * This is for player to play.
 */
public class Player implements ActionListener {
    private List<NumberCard> cards;
    private String name;

    public Player(String name) {
        this.name = name;
        cards = new ArrayList();
    }

    public void addCards(List<NumberCard> numberCards){
        for (NumberCard numberCard : numberCards) {
            cards.add(numberCard);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    public List<NumberCard> getCards() {
        return this.cards;
    }
}
