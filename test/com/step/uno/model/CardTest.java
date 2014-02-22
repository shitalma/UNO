package com.step.uno.model;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class CardTest {
    @Test
    public void createCardWillGivesAPackOfCardsWith108Cards(){
        int numberOfCardsIn1Pack = Card.createNewPacks(1).length;
        assertEquals(108,numberOfCardsIn1Pack);
    }

    @Test
    public void createCardWillGivesAPackOfCardsWith216CardsForTwoPacks(){
        int numberOfCardsIn1Pack = Card.createNewPacks(2).length;
        assertEquals(216,numberOfCardsIn1Pack);
    }
}
