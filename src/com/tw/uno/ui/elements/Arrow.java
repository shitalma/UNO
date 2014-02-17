package com.tw.uno.ui.elements;

import javax.swing.*;

public class Arrow extends JPanel{
    private JLabel left;
    private JLabel right;

    public Arrow() {
        this.left = new JLabel(" -> ");
        this.right = new JLabel(" <- ");
        add(left);
        add(right);
    }
}
