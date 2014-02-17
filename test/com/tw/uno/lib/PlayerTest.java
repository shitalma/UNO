package com.tw.uno.lib;

import junit.framework.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class PlayerTest {
    @Test
    public void testShouldReturnAllCardsPlayerHaving() throws Exception {
        List<NumberCard> expected = new ArrayList<>();
        expected.add(new NumberCard());
        expected.add(new NumberCard());
        Player player = new Player();
        player.addCards(expected);
        List<NumberCard> actual = player.getMyNumberCards();

        Assert.assertEquals(expected,actual);
    }
}
