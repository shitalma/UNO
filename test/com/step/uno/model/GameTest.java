package com.step.uno.model;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class GameTest {

    @Test
    public void eachPlayerGets7CardsWhenGameStarts() {
        ArrayList<Player> players = new ArrayList<>();
        Player uday = new Player("uday");
        Player sayali = new Player("sayali");

        players.add(uday);
        players.add(sayali);

        Game game = new Game(1, players);
        game.initialize();
        assertEquals(7, uday.getNumberOfCards());
        assertEquals(7, sayali.getNumberOfCards());
    }

    @Test
    public void testPlayerCanPlayValidCard() {
        ArrayList<Player> players = new ArrayList<>();
        Player uday = new Player("uday");
        Player sayali = new Player("sayali");

        players.add(uday);
        players.add(sayali);
        Game game = new Game(1, players);
        game.getOpenDeck().add(Card.createCard(Colour.Green, "_1"));

        assertEquals(true, new RuleEngine().isCardValidToPlay((Card.createCard(Colour.Green, "_1")),Card.createCard(Colour.Green, "_1")));
    }

    @Test
    public void playerCanDrawACard() {
        Player uday = new Player("uday");

        uday.take(Card.createCard(Colour.Blue, "_1"));

        assertEquals(true, uday.hasCard(Card.createCard(Colour.Blue, "_2")));
    }

//    @Test
//    public void ShouldSwitchTurnToNextPlayerWhenCurrentPlayerIsDone() {
//        Player ram = new Player("Raj");
//        Player raj = new Player("Ram");
//
//        List<Player> players = new ArrayList<>();
//        players.add(raj);
//        players.add(ram);
//        Game game = new Game(1, players);
//        game.initialize();
//
//        Snapshot rajSnapshot = new Snapshot();
//        game.populate(rajSnapshot,raj);
//        Player player = players.get(rajSnapshot.currentPlayerIndex);
//
////        Card card = mock(Card.class);
//        game.playCard(player, game.getOpenDeck().draw());
//
//        game.populate(rajSnapshot,raj);
//        Player nextPlayer = players.get(rajSnapshot.currentPlayerIndex);
//        System.out.println(player.getName());
//        System.out.println(nextPlayer.getName());
//
//
//        assertNotSame(player,nextPlayer);
//    }
}

