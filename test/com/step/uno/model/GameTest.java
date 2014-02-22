package com.step.uno.model;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class GameTest {
    ArrayList<Player> players = new ArrayList<>();
    Player uday = new Player("uday");
    Player sayali = new Player("sayali");

    @Test
    public void eachPlayerGets7CardsWhenGameStarts() {
        players.add(uday);
        players.add(sayali);

        Game game = new Game(1, players);
        game.initialize();
        assertEquals(7, uday.getNumberOfCards());
        assertEquals(7, sayali.getNumberOfCards());
    }

    @Test
    public void playerCanDrawACard() {

        uday.take(Card.createCard(Colour.Blue, "_1"));

        assertEquals(true, uday.hasCard(Card.createCard(Colour.Blue, "_2")));
    }

}

