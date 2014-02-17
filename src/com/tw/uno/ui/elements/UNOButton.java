package com.tw.uno.ui.elements;

/**
 * This is for displaying the UNO button.
 */

import javax.swing.*;

public class UNOButton extends JPanel {
    JButton unoButton;

    public UNOButton() {
        unoButton = new JButton("  UNO  ");
        unoButton.setVisible(true);
        unoButton.setSize(100, 50);
        add(unoButton);
    }
}
