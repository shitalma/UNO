package com.step.uno.model;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class PlayerTest {
    Player player = new Player("Someone");
    List<Card> cards = new ArrayList<>();

    @Before
    public void setUp() {
        cards.add(Card.createCard(Colour.Red,"_4"));
        cards.add(Card.createCard(Colour.Green,"_6"));
        player.take(cards.get(0));
        player.take(cards.get(1));
    }

    @Test
    public void cardShouldBeRemovedAfterPlayingACard() {
        player.play(cards.get(1));
        assertEquals(player.getNumberOfCards(),1);
    }

    @Test
    public void cardShouldBeAddedAfterDrawingACard() {
        player.take(cards.get(1));
        assertEquals(player.getNumberOfCards(),3);
    }

    @Test
    public void tellThatPlayerWonGameIfHisCardsAreZero(){
        player.play(cards.get(0));
        player.play(cards.get(1));

        assertEquals(player.hasWon(),true);
    }

    @Test
    public void getTheNameOfPlayer() {
        assertEquals("Someone",player.getName());
    }
}
