package com.tw.uno.lib;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class PlayerTest {
    Player sandesh;

    @Before
    public void setUp() throws Exception {
        sandesh = new Player("Sandesh");
        List<NumberCard> cards = new ArrayList();
        cards.add(new NumberCard("red", 1));
        cards.add(new NumberCard("blue", 9));

        sandesh.addCards(cards);
    }

    @Test
    public void shouldGiveAllCardsOfPlayer() {
        List<NumberCard> expected = new ArrayList();
        expected.add(new NumberCard("red", 1));
        expected.add(new NumberCard("blue", 9));

        List<NumberCard> actual = sandesh.getCards();

        assertEquals(expected, actual);
    }

    @Test
    public void placeCardShouldPlaceACard() {
        List<NumberCard> expected = new ArrayList();

        expected.add(new NumberCard("red",1));

        assertEquals(true, sandesh.placeACard(new NumberCard("blue",9)));
        assertEquals(expected, sandesh.getCards());

    }

    @Test
    public void placeCardShouldNotPlaceACardWhichIsNotPresent() {
        List<NumberCard> expected = new ArrayList();
        NumberCard blue10 = new NumberCard("blue", 10);
        expected.add(new NumberCard("red",1));
        expected.add(new NumberCard("blue",9));

        assertEquals(false, sandesh.placeACard(blue10));
        assertEquals(expected,sandesh.getCards());

    }
}
