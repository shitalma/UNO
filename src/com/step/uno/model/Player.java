package com.step.uno.model;

import com.step.uno.messages.Snapshot;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Player implements Serializable{
    private String name;
    private List<Card> cards = new ArrayList<>();
    private boolean declaredUno;

    public Player(String name) {
        this.name = name;
    }
    public void take(Card card) {
        cards.add(card);
        declaredUno = false;
    }

    public void populateSelf(Snapshot snapshot) {
        snapshot.myCards = cards.toArray(new Card[]{});
    }

    public PlayerSummary generateSummary() {
        return new PlayerSummary(name, cards.size(), declaredUno);
    }

    public void play(Card card) {
       cards.remove(card);
    }

    public void declareUno() {
        declaredUno = true;
    }

    public boolean checkUno() {
        return cards.size() == 1 && !declaredUno;
    }

    public boolean hasWon() {
        return cards.size() == 0;
    }

    public PlayerResult generateResult() {
        return new PlayerResult(name, cards, calculatePoints());
    }

    private int calculatePoints() {
        int total = 0;
        for (Card card : cards) total += card.sign.points;
        return total;
    }

    public int getNumberOfCards() {
        return cards.size();
    }

    public boolean hasCard(Card card) {
        for (Card currentCard : cards) {
            if(currentCard.colour == card.colour || currentCard.sign == card.sign)
                return true;
        }
        return false;
    }

    public String getName() {
        return name;
    }
}
