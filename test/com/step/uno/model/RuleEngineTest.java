package com.step.uno.model;

import junit.framework.Assert;
import org.junit.Test;

public class RuleEngineTest {

    Card blue_0 = Card.createCard(Colour.Blue,"_0");
    Card blue_6 = Card.createCard(Colour.Blue,"_6");
    Card red_reverse = Card.createCard(Colour.Red,"Reverse");
    Card black_draw_4 = Card.createCard(Colour.Black,"WildDrawFour");
    Card yellow_draw_2 = Card.createCard(Colour.Yellow,"DrawTwo");
    RuleEngine ruleEngine = new RuleEngine();
    @Test
    public void anyNumberCardIsValidToPlayOnSameColorOfLastCard() throws Exception {
        Assert.assertEquals(true,ruleEngine.IsCardValidToPlay(blue_0,blue_6));
    }
}
