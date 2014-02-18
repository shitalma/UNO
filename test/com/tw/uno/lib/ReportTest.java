package com.tw.uno.lib;

import com.tw.uno.lib.card.Card;
import com.tw.uno.lib.card.CardColor;
import com.tw.uno.lib.card.CardValue;
import com.tw.uno.lib.card.NumberCard;
import com.tw.uno.ui.screen.ReportScreen;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ReportTest {
    Report report;
    List<Player> players;
    List<Card> cards;

    @Before
    public void setUp() throws Exception {
        report = new Report();
        cards = new ArrayList<>();
        players = new ArrayList<>();
        players.add(new Player("uday"));
        cards.add(new NumberCard(CardColor.BLUE, CardValue.SIX));
        cards.add(new NumberCard(CardColor.RED, CardValue.SIX));
    }

    @Test
    public void testGetPlayersNames() throws Exception {
        report.addPlayers(players);
        assertThat(report.getPlayersNames().get(0), is("uday"));
    }

    @Test
    public void testGetNumberOfCards() throws Exception {
        players.get(0).addCards(cards);
        report.addPlayers(players);
        assertThat(report.getNumberOfCardsForEachPlayer().get(0),is(2));
    }

    @Test
    public void testGetPointForEachPlayer(){
        players.get(0).addCards(cards);
        report.addPlayers(players);
        assertThat(report.getPointsForEachPlayer().get(0), is(12));
    }
}
