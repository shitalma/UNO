package com.tw.uno.ui.elements;

import com.tw.uno.lib.CardColor;
import com.tw.uno.lib.NumberCard;

import javax.swing.*;

public class PileButton extends JPanel {
    private JButton pileButton;

    public PileButton() {
        pileButton = new JButton(new NumberCard(CardColor.RED,6).toString());
        add(pileButton);
    }
}