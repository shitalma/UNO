package com.tw.uno.lib;

import com.tw.uno.lib.card.Card;
import com.tw.uno.lib.card.NumberCard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class Pile {

    private List<Card> openPile;
    private List<Card> closePile;
    private int penalty;

    public Pile() {
        openPile = new ArrayList<>();
        closePile = new ArrayList<>();
        this.penalty = 0;
    }

    public void addCardToOpenPile(Card card){
        openPile.add(card);
    }

    public Card getLastPlacedFromOpenPile(){
        return openPile.get(openPile.size()-1);
    }

    public List<Card> getPenaltyCards() {
        List<Card> penaltyCards = new ArrayList<>();
        if(this.penalty == 0)
            return Arrays.asList(getLastCardInClosePile());
        for (int i = 0; i < this.penalty; i++) {
            penaltyCards.add(getLastCardInClosePile());
        }
        return penaltyCards;
    }

    private Card getLastCardInClosePile() {
        return this.closePile.get(0);
    }
}
