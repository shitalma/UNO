package com.step.uno.model;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class GameTest {
    ArrayList<Player> players = new ArrayList<>();
    Player uday = new Player("uday");
    Player sayali = new Player("sayali");

    @Test
    public void testNumberOfCardOfOnePlayerWithOnePack() {
        players.add(uday);
        players.add(sayali);

        Game game = new Game(1, players);
        game.initialize();
        assertEquals(7, uday.getNumberOfCards());
        assertEquals(7, sayali.getNumberOfCards());
    }

    @Test
    public void testPlayerCanPlayAValidCard() throws Exception {
        players.add(uday);
        players.add(sayali);
        Game game = new Game(1, players);
        game.getOpenDeck().add(Card.createCard(Colour.Green, "_1"));

        //Specify game's valid cards
        //Verify card can be played.

        assertEquals(true, game.cardIsValid(Card.createCard(Colour.Green, "_1")));
    }

}

