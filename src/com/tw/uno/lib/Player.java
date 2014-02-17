package com.tw.uno.lib;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

/**
 * This is for player to play.
 */
public class Player implements ActionListener {

    private List<NumberCard> myNumberCards;

    public Player() {
        myNumberCards = new ArrayList();
    }

    public void addCards(List<NumberCard> numberCards){
        for (NumberCard numberCard : numberCards) {
            myNumberCards.add(numberCard);
        }
    }

    public List<NumberCard> getMyNumberCards() {
        return myNumberCards;
    };


    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println(e.paramString());
    }
}
