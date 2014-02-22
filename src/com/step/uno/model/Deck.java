package com.step.uno.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Deck implements Serializable {
    private List<Card> cards = new ArrayList<>();

    public Deck(Card[] cards) {
        this.cards.addAll(Arrays.asList(cards));
    }

    public Deck() {
    }

    public void shuffle() {
        Collections.shuffle(cards);
    }

    public Card draw() {
        //if cards are over, need to shuffle and pick from the bottom of open pile
        return cards.remove(0);
    }

    public void add(Card card) {
        cards.add(card);
    }

    public Card lookAtLast() {
        return cards.get(cards.size()-1);
    }

    public boolean isEmpty() {
        return cards.size()==0;
    }

    public List<Card> drawAllButLast() {
        List<Card> result = cards.subList(0, cards.size() - 2);
        cards.removeAll(result);
        return result;
    }

    public void addAll(List<Card> newCards) {
        cards.addAll(newCards);
    }
    public int getSize(){
        return cards.size();
    }
}
