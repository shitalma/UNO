package com.step.uno.model;

import junit.framework.TestCase;
import org.junit.Test;

public class PlayerTest extends TestCase {
    @Test
    public void testIfPlayerHasCard() throws Exception {
        Player raj = new Player("Raj");
        raj.take(Card.createCard(Colour.Blue, "_2"));
        raj.take(Card.createCard(Colour.Green, "_1"));

        assertTrue(raj.hasCard(Card.createCard(Colour.Red, "_2")));;
    }

    @Test
    public void testIfPlayerDoesNotHaveCard() throws Exception {
        Player raj = new Player("Raj");
        raj.take(Card.createCard(Colour.Blue, "_2"));
        raj.take(Card.createCard(Colour.Green, "_1"));

        assertFalse(raj.hasCard(Card.createCard(Colour.Red, "_3")));;
    }
}
