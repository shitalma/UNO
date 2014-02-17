package com.tw.uno.lib;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class PileTest {
    Pile pile;

    @Before
    public void setUp() throws Exception {
        pile = new Pile();
    }

    @Test
    public void shouldGetLastPlacedCard() throws Exception {
        pile.addCardToPile(new NumberCard("red",7));
        pile.addCardToPile(new NumberCard("blue",2));

        NumberCard actualCard = pile.getLastPlacedCard();

        assertThat(actualCard,is(new NumberCard("blue",2)));
    }
}
