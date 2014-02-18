package com.tw.uno.ui.screen;

import javax.swing.*;
import java.awt.*;

public class WaitingScreen extends JFrame{

    private JLabel label;
    private JPanel panel;

    public WaitingScreen(){
        setTitle("Exit");
        setSize(500, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);

        createExitScreen();
    }

    public void createExitScreen(){
        panel = new JPanel();
        label = new JLabel("Waiting....");
        label.setFont(new Font("Serif", Font.PLAIN, 34));
        panel.add(label);
        add(panel);
        setVisible(true);
    }

}
