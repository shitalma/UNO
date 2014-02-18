package com.tw.uno.lib;

import com.tw.uno.lib.card.Card;

import java.util.Collections;
import java.util.List;

/**
 * This is for running the game -- shuffleCards cards, distribute,placeOpenCard --
 * It observers a player's play event
 */
public class Game implements CardListener{

    private List<Player> players;
    private List<Card> cards;
    private Player currentPlayer;
    private Pile pile;

    public Game(List<Player> players,List<Card> cards) {
        this.players = players;
        this.cards = new UNOFactory().getPacksOfCards(2);
        this.cards = cards;
        this.pile = new Pile();
        shufflePlayers();
        this.currentPlayer = this.players.get(0);
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

    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    @Override
    public void onCardPlaced(Card card) {
        currentPlayer.getCards().remove(card);
        pile.addCardToOpenPile(card);
    }

    @Override
    public void onCardDrew() {
        List<Card> penaltyCards = pile.getPenaltyCards();
        currentPlayer.addCards(penaltyCards);
    }
}
