package com.step.uno.model;

import junit.framework.Assert;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class DeckTest {
    @Test
    public void addACardInADeck() {
        Deck deck = new Deck();
        Card card = Card.createCard(Colour.Blue, "_1");
        assertEquals(0,deck.getSize());
        deck.add(card);
        assertEquals(1,deck.getSize());
    }

    @Test
    public void getLastCardFromOpenDeck() {
        Deck deck = new Deck();
        Card card1 = Card.createCard(Colour.Blue, "_1");
        Card card2 = Card.createCard(Colour.Red, "_9");
        deck.add(card1);
        deck.add(card2);
        assertEquals(card2,deck.lookAtLast());
    }
}
