package com.tw.uno.lib;

import com.tw.uno.lib.card.Card;
import com.tw.uno.lib.card.CardColor;
import com.tw.uno.lib.card.CardValue;
import com.tw.uno.lib.card.NumberCard;

import java.util.ArrayList;
import java.util.List;

public class Pile {

    private List<Card> cards;

    public Pile() {
        cards = new ArrayList<>();
        cards.add(new NumberCard(CardColor.BLUE, CardValue.THREE));
    }

    public void addCardToPile(Card card){
        cards.add(card);
    }

    public Card getLastPlacedCard(){
        return cards.get(cards.size()-1);
    }
}
