package com.step.uno.client.screen.elements;

/**
 * This is for displaying the UNO button.
 */

import javax.swing.*;

public class UNOButton extends JPanel {
    JButton unoButton;
//    ImageIcon icon;

    public UNOButton() {
//          icon = new ImageIcon("uno_icon.jpg");
        unoButton = new JButton("  UNO  ");
        unoButton.setVisible(true);
        unoButton.setSize(100, 50);
        add(unoButton);
    }
}
