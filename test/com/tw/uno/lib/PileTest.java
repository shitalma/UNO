package com.tw.uno.lib;

import com.tw.uno.lib.card.CardColor;
import com.tw.uno.lib.card.CardValue;
import com.tw.uno.lib.card.NumberCard;
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
        pile.addCardToPile(new NumberCard(CardColor.RED, CardValue.eight));
        pile.addCardToPile(new NumberCard(CardColor.BLUE,CardValue.three));

        NumberCard actualCard = pile.getLastPlacedCard();

        assertThat(actualCard,is(new NumberCard(CardColor.BLUE,CardValue.three)));
    }
}
