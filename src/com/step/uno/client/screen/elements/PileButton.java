package com.step.uno.client.screen.elements;

import javax.swing.*;

public class PileButton extends JPanel {
    private JButton pileButton;

    public PileButton() {
        pileButton = new JButton("red:6");
        add(pileButton);
    }
}