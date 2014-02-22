package com.step.uno.model;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by udaykant on 2/21/14.
 */
public class PlayerTest {
    Player player = new Player("Someone");
    List<Card> cards = new ArrayList<>();

    @Before
    public void setUp() throws Exception {
        cards.add(Card.createCard(Colour.Red,"_4"));
        cards.add(Card.createCard(Colour.Green,"_6"));
        player.take(cards.get(0));
        player.take(cards.get(1));
    }

    @Test
    public void testPlay() throws Exception {
        player.play(cards.get(1));
        assertEquals(player.getNumberOfCards(),1);
    }

    @Test
    public void testHasWon(){
        player.play(cards.get(0));
        player.play(cards.get(1));

        assertEquals(player.hasWon(),true);
    }
}
