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
        List<NumberCard> cards = new ArrayList<>();
        cards.add(new NumberCard(CardColor.RED, 1));
        cards.add(new NumberCard(CardColor.BLUE, 9));

        sandesh.addCards(cards);
    }

    @Test
    public void shouldGiveAllCardsOfPlayer() {
        List<NumberCard> expected = new ArrayList<>();
        expected.add(new NumberCard(CardColor.RED, 1));
        expected.add(new NumberCard(CardColor.BLUE, 9));

        List<NumberCard> actual = sandesh.getCards();

        assertEquals(expected, actual);
    }

    @Test
    public void placeCardShouldPlaceACard() {
        List<NumberCard> expected = new ArrayList<>();

        expected.add(new NumberCard(CardColor.RED,1));

        assertEquals(true, sandesh.placeACard(new NumberCard(CardColor.BLUE,9)));
        assertEquals(expected, sandesh.getCards());

    }

    @Test
    public void placeCardShouldNotPlaceACardWhichIsNotPresent() {
        List<NumberCard> expected = new ArrayList<>();
        NumberCard blue10 = new NumberCard(CardColor.BLUE, 10);
        expected.add(new NumberCard(CardColor.RED,1));
        expected.add(new NumberCard(CardColor.BLUE,9));

        assertEquals(false, sandesh.placeACard(blue10));
        assertEquals(expected,sandesh.getCards());

    }
}
