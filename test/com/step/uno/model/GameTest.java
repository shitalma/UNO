package com.step.uno.model;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class GameTest {
    @Test
    public void testNumberOfCardOfOnePlayerWithOnePack() {
        ArrayList<Player> players = new ArrayList<>();
        Player uday = new Player("uday");
        players.add(uday);
        Player sayali = new Player("sayali");
        players.add(sayali);
        Game game = new Game(1, players);
        game.initialize();
        assertEquals(7, uday.getNumberOfCards());
        assertEquals(7, sayali.getNumberOfCards());
    }
}

