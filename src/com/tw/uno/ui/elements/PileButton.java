package com.tw.uno.ui.elements;

import com.tw.uno.lib.card.CardColor;
import com.tw.uno.lib.card.CardValue;
import com.tw.uno.lib.card.NumberCard;

import javax.swing.*;

public class PileButton extends JPanel {
    private JButton pileButton;

    public PileButton() {
        pileButton = new JButton(new NumberCard(CardColor.RED, CardValue.six).toString());
        add(pileButton);
    }
}