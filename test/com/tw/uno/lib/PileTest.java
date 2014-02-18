package com.tw.uno.lib;

import com.tw.uno.lib.card.Card;
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
        pile.onCardPaced(new NumberCard(CardColor.RED, CardValue.EIGHT));
        pile.onCardPaced(new NumberCard(CardColor.BLUE,CardValue.THREE));

        Card actualCard = pile.getLastPlacedCard();

        assertThat((NumberCard)actualCard,is(new NumberCard(CardColor.BLUE,CardValue.THREE)));
    }
}
