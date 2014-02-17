package com.tw.uno.lib;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class PlayerTest {
    Player sandesh;
    List<Card> cards;

    @Before
    public void setUp() throws Exception {
        sandesh = new Player("Sandesh");
        sandesh.setCards(Arrays.asList(new Card("red",1),new Card("blue",9)));
    }

    @Test
    public void shouldGiveTotalNumberOfCards() throws Exception {
        cards = sandesh.getCards();
        assertEquals(2, cards.size());
    }

    @Test
    public void shouldGiveCards() throws Exception {
        cards = sandesh.getCards();
        Card actualCard = cards.get(0);
        assertThat(actualCard,is(new Card("red",1)));
    }
}
