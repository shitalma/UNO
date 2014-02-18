package com.tw.uno.lib;

import com.tw.uno.lib.card.*;
import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static junit.framework.Assert.assertEquals;

/**
 * This is for testing Game's shuffle and deck of cards.
 */
public class GameTest {
    private Game game;
    Player raj;

    @Before
    public void setUp() throws Exception {
        List<Player> players = new ArrayList<>();
        Player sandesh = new Player("sandesh");
        players.add(sandesh);
        raj = new Player("raj");
        players.add(raj);
        List<Card> cards = getCardList();
        game = new Game(players, cards);
    }

    private List<Card> getCardList() {
        List<Card> cards = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            cards.add(new NumberCard(CardColor.RED, CardValue.FIVE));
            cards.add(new NumberCard(CardColor.BLUE, CardValue.ONE));
        }
        return cards;
    }

    @Test
    public void GameMasterShouldStartTheGame() {

        assertEquals(2,game.getPlayers().size());
        assertEquals(4, game.getCards().size());
    }

    @Test
    public void ShouldRemoveCardFromCurrentPlayerAndAddToPile(){
        List<Card> cardList = getCardList();
        raj.addCards(cardList);
        game.onCardPlaced(cardList.get(0));
        assertEquals(3,game.getCurrentPlayer().getCards().size());
    }
}
