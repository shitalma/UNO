package com.tw.uno.lib;

import java.util.ArrayList;
import java.util.List;

public class Report {
    private List<Player> players;
    List<Integer> numberOfCards = new ArrayList<>();
    List<Integer> points = new ArrayList<>();
    List<String> names = new ArrayList<>();

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

}
