package com.tw.uno.lib;

import com.tw.uno.lib.card.Card;
import com.tw.uno.lib.card.CardGenerator;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.Assert.assertEquals;

/**
 * This is for testing GameMaster
 */
public class GameMasterTest {
    private Game game;
    private GameMaster gameMaster;

    @Before
    public void setUp() throws Exception {
        List<Player> players = new ArrayList<>();
        players.add(new Player("sandesh"));
        players.add(new Player("raj"));
        UNOFactory unoFactory = new UNOFactory();
        List<Card> cards = new ArrayList<>();
        CardGenerator generator = new CardGenerator();
        for (int i = 0; i < 2; i++) {
            cards.add(generator.createCard("RED", "five"));
            cards.add(generator.createCard("BLUE", "one"));
        }
        gameMaster = new GameMaster(unoFactory, players.size(), 1);
        game = gameMaster.startGame(players, cards);

    }

    @After
    public void tearDown() throws Exception {
        gameMaster.stopGame();
        game = null;
    }

    @Test
    public void GameMasterShouldStartTheGame() {

        assertEquals(2,game.getPlayers().size());
        assertEquals(4,game.getCards().size());
    }

    @Test
    public void testShuffleCards(){
        List<Card> cards = game.getCards();
        game.shuffleCards();
        for (Card card : cards) {
            System.out.println(card);
        }
    }

    @Test
    public void testShufflePlayers(){
        List<Player> players = game.getPlayers();
        game.shuffleCards();
        for (Player player : players) {
            System.out.println(player.getName());
        }
    }

}
