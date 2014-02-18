package com.tw.uno.lib;

import com.tw.uno.lib.card.Card;
import com.tw.uno.lib.card.CardColor;
import com.tw.uno.lib.card.CardValue;
import com.tw.uno.lib.card.NumberCard;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class OpenPileTest {
    OpenPile openPile;

    @Before
    public void setUp() throws Exception {
        openPile = new OpenPile();
    }

    @Test
    public void shouldGetLastPlacedCard() throws Exception {
        openPile.onCardPaced(new NumberCard(CardColor.RED, CardValue.EIGHT));
        openPile.onCardPaced(new NumberCard(CardColor.BLUE, CardValue.THREE));

        Card actualCard = openPile.getLastPlacedCard();

        assertThat((NumberCard)actualCard,is(new NumberCard(CardColor.BLUE,CardValue.THREE)));
    }
}
