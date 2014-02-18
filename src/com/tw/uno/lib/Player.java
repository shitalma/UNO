package com.tw.uno.lib;

import com.tw.uno.lib.card.Card;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * This is for player to - play.
 */
public class Player {
    private List<Card> cards;
    private String name;

    public Player(String name) {
        this.name = name;
        cards = new ArrayList<>();
    }

    public void addCards(List<Card> numberCards){
        for (Card numberCard : numberCards) {
            cards.add(numberCard);
        }
    }
    public List<Card> getCards() {
        return this.cards;
    }

    public boolean placeACard(Card card) {
        return cards.remove(card);
    }

    public String getName() {
        return name;
    }

}