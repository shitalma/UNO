package com.tw.uno.lib;

import java.util.ArrayList;
import java.util.List;

/**
 * This is for player to play.
 */
public class Player  {
    private List<Card> cards;
    private String name;

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
}