package com.tw.uno.lib;

import com.tw.uno.lib.card.Card;

import java.util.ArrayList;
import java.util.List;

public class Report {
    private List<Player> players;
    List<Integer> numberOfCards = new ArrayList<>();
    List<Integer> points = new ArrayList<>();
    List<String> names = new ArrayList<>();
    private int sum = 0;

    public Report() {
        this.players = new ArrayList<>();
    }

    public void addPlayers(List<Player> players){
        this.players = players;
    }

    public List<String> getPlayersNames() {
        for (Player player : players) {
            names.add(player.getName());
        }
        return names;
    }

    public List<Integer> getNumberOfCardsForEachPlayer(){
        for (Player player : players) {
            numberOfCards.add(player.getCards().size());
        }
        return numberOfCards;
    }

    public List<Integer> getPointsForEachPlayer(){
        for (Player player : players) {
            points.add(calculateTotalPoints(player.getCards()));
        }
        return points;
    }

    private int calculateTotalPoints(List<Card> cards) {
        sum =0;
        for (Card card : cards) {
            sum += Integer.parseInt(card.toString().split(" ")[1]);
        }
        return sum;
    }

    public int getTotalNumberOfPlayers(){
        return players.size();
    }
}
