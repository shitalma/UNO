package com.tw.uno.lib;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

/**
 * This is for player to play.
 */
public class Player implements ActionListener {
    private List<Card> cards;
    private String name;


    private List<NumberCard> myNumberCards;

    public Player() {
        myNumberCards = new ArrayList();
    }

    public void addCards(List<NumberCard> numberCards){
        for (NumberCard numberCard : numberCards) {
            myNumberCards.add(numberCard);
        }
    }

    public List<NumberCard> getMyNumberCards() {
        return myNumberCards;
    };

    public Player(String name) {
        this.name = name;
    }

    public void setCards(List<Card> playerCards) {
        cards = new ArrayList<>();
        for (Card card : playerCards) {
            cards.add(card);
        }
    }

    public String getName() {
        return name;
    }

    public int getNumberOfCards(){
        return this.cards.size();
    }

    public List<Card> getCards() {
        return cards;

    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
