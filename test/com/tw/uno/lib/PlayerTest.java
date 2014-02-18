
package com.tw.uno.lib;
import com.tw.uno.lib.card.Card;
import com.tw.uno.lib.card.CardColor;
import com.tw.uno.lib.card.CardValue;
import com.tw.uno.lib.card.NumberCard;
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
        List<Card> cards = new ArrayList<>();
        cards.add(new NumberCard(CardColor.RED, CardValue.one));
        cards.add(new NumberCard(CardColor.BLUE,CardValue.nine));

        sandesh.addCards(cards);
    }

    @Test
    public void shouldGiveAllCardsOfPlayer() {
        List<Card> expected = new ArrayList<>();
        expected.add(new NumberCard(CardColor.RED, CardValue.one));
        expected.add(new NumberCard(CardColor.BLUE,CardValue.nine));

        List<Card> actual = sandesh.getCards();

        assertEquals(expected, actual);
    }

    @Test
    public void placeCardShouldPlaceACard() {
        List<Card> expected = new ArrayList<>();

        expected.add(new NumberCard(CardColor.RED,CardValue.one));

        assertEquals(true, sandesh.placeACard(new NumberCard(CardColor.BLUE,CardValue.nine)));
        assertEquals(expected, sandesh.getCards());

    }

    @Test
    public void placeCardShouldNotPlaceACardWhichIsNotPresent() {
        List<Card> expected = new ArrayList<>();
        NumberCard blue8  = new NumberCard(CardColor.BLUE, CardValue.eight);
        expected.add(new NumberCard(CardColor.RED,CardValue.one));
        expected.add(new NumberCard(CardColor.BLUE,CardValue.nine));

        assertEquals(false, sandesh.placeACard(blue8));
        assertEquals(expected,sandesh.getCards());

    }
}
