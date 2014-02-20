package com.step.uno.messages;

import com.step.uno.model.Card;
import com.step.uno.model.Colour;
import com.step.uno.model.Player;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class GameSnapshot implements Serializable {
    public String[]  log;
    public List<Player> players;
    public List<Card> cards;

    public GameSnapshot() {
        this.log = new String[]{"aaa", "bbb", "cccc", "dddd"};
        this.players = new ArrayList<>();
            players.add(new Player("kavita"));
            players.add(new Player("shital"));
            players.add(new Player("Sayali"));
        this.cards = new ArrayList<>();
            cards.add(Card.createCard(Colour.Blue,"_7"));
            cards.add(Card.createCard(Colour.Blue,"_8"));
            cards.add(Card.createCard(Colour.Blue,"_9"));
    }
}
