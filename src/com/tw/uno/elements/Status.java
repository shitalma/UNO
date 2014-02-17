package com.tw.uno.elements;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class Status extends JPanel{
    private JLabel label;
    public Status() {
        Border blackLine = BorderFactory.createLineBorder(Color.black);
        label = new JLabel("Status Hint");
        label.setBorder(blackLine);
        label.setFont(new Font("TimesRoman", Font.BOLD, 18));
        add(label);
    }
}
