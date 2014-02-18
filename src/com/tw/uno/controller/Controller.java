package com.tw.uno.controller;

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

    public Controller(Player player){
        this.player = player;
        this.pile = new Pile();
    }
    public void onCardPlace(Card card) {
        pile.onCardPaced(card);
        player.onCardPaced(card);
    }

    public Card createCard(String color, String value) {
        return new CardGenerator().createCard(color,value);
    }
}
