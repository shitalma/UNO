package com.tw.uno.lib;

import java.util.ArrayList;
import java.util.List;

public class Pile {

    private List<NumberCard> cards;

    public Pile() {
        cards = new ArrayList<>();
    }

    public void addCardToPile(NumberCard card){
        cards.add(card);
    }

    public NumberCard getLastPlacedCard(){
        return cards.get(cards.size()-1);
    }
}
