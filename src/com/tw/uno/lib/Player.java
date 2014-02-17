package com.tw.uno.lib;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * This is for player to play.
 */
public class Player implements ActionListener {

    public Player() {

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println(e.paramString());
    }
}
