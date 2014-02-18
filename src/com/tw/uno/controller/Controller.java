package com.tw.uno.controller;

import com.tw.uno.lib.OpenPile;
import com.tw.uno.lib.Player;
import com.tw.uno.lib.card.Card;
import com.tw.uno.lib.card.CardGenerator;

/**
 * Connect Library to User Interface
 */

public class Controller {
    private OpenPile openPile;
    private Player player;

    public Controller(Player player){
        this.player = player;
        this.openPile = new OpenPile();
    }
    public void onCardPlace(Card card) {
        openPile.onCardPaced(card);
        player.onCardPaced(card);
    }

    public Card createCard(String color, String value) {
        return new CardGenerator().createCard(color,value);
    }
}
