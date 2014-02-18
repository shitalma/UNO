package com.tw.uno.controller;

import com.tw.uno.lib.Game;
import com.tw.uno.lib.Pile;
import com.tw.uno.lib.Player;
import com.tw.uno.lib.card.Card;
import com.tw.uno.lib.card.CardGenerator;

/**
 * Connect Library to User Interface
 */

public class Controller {
    private Pile pile;
    private Player player;

    public Controller(){
        this.pile = new Pile();
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public Card createCard(String color, String value) {
        return new CardGenerator().createCard(color,value);
    }
}
