package com.tw.uno.lib;

import com.tw.uno.lib.card.Card;

import java.util.Collections;
import java.util.List;

/**
 * This is for running the game -- shuffleCards cards, distribute,placeOpenCard --
 * It observers a player's play event
 */
public class Game {
    private List<Player> players;
    private List<Card> cards;

    public Game(List<Player> players,List<Card> cards) {
        this.players = players;
        this.cards = new UNOFactory().getPacksOfCards(2);
        this.cards = cards;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public List<Card> getCards() {
        return cards;
    }

    public void shuffleCards() {
        Collections.shuffle(cards);
    }
//    private void prepareToPlay() {
//
//        List<Card> cards = unoFactory.getPacksOfCards(numOfPacks);
//        for (int i = 0; i < clients.size() * 7; i++) {
//            for (MessageChannel client : clients) {
//                    client.addCard(cards.get(i));
//                    cards.remove(i);
//                client.send("CARD:" + cards);
//            }
//        }
//    }


    public void shufflePlayers(){
        Collections.shuffle(players);
    }
}
