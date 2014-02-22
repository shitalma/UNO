package com.step.uno.model;

import junit.framework.Assert;
import org.junit.Test;

public class RuleEngineTest {

    Card blue_0 = Card.createCard(Colour.Blue, "_0");
    Card blue_6 = Card.createCard(Colour.Blue, "_6");
    Card red_6 = Card.createCard(Colour.Red, "_6");
    Card red_reverse = Card.createCard(Colour.Red, "Reverse");
    Card yellow_reverse = Card.createCard(Colour.Yellow, "Reverse");
    Card draw_4 = Card.createCard(Colour.Black, "WildDrawFour");
    Card wild = Card.createCard(Colour.Black, "Wild");
    Card yellow_draw_2 = Card.createCard(Colour.Yellow, "DrawTwo");
    Card red_draw_2 = Card.createCard(Colour.Red, "DrawTwo");

    RuleEngine ruleEngine = new RuleEngine();

    @Test
    public void anyNumberCardIsValidToPlayOnSameColorOfLastCard() {
        Assert.assertEquals(true, ruleEngine.isCardValidToPlay(blue_0, blue_6));
    }

    @Test
    public void anyNumberCardIsValidToPlayOnSameSignOfLastCard() {
        Assert.assertEquals(true, ruleEngine.isCardValidToPlay(red_6, blue_6));
    }

    @Test
    public void drawTwoIsValidToPlayOnDrawTwo() {
        Assert.assertEquals(true, ruleEngine.isCardValidToPlay(yellow_draw_2, red_draw_2));
    }

    @Test
    public void otherCardIsNotValidToPlayOnDrawToExceptDrawToOrSameColorCard() {
        Assert.assertEquals(false, ruleEngine.isCardValidToPlay(blue_6, yellow_draw_2));
    }

    @Test
    public void anyCardIsValidOnWildDrawFour() {
        Assert.assertEquals(true, ruleEngine.isCardValidToPlay(blue_6, draw_4));
    }

    @Test
    public void cardWithReverseSignIsValidToPlayOnReverseCard() {
        Assert.assertEquals(true, ruleEngine.isCardValidToPlay(red_reverse, yellow_reverse));
    }

    @Test
    public void cardWithSameColorOrReverseSignIsValidToPlayOnReverseCard() {
        Assert.assertEquals(true, ruleEngine.isCardValidToPlay(red_reverse, draw_4));
    }

    @Test
    public void wildCardISValidForAnySituation() {
        Assert.assertEquals(true, ruleEngine.isCardValidToPlay(wild, blue_6));
    }

    @Test
    public void wildDraw4CardISValidForAnySituation() {
        Assert.assertEquals(true, ruleEngine.isCardValidToPlay(draw_4, blue_6));
    }

}
