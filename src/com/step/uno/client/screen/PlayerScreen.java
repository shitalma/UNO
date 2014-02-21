package com.step.uno.client.screen;

import com.step.uno.client.screen.elements.*;

import javax.swing.*;
import java.awt.*;

import static java.awt.BorderLayout.EAST;

public class PlayerScreen extends JFrame {
    private final Dimension screenSize;
    JTextArea textArea;


    public PlayerScreen() {
        setLayout(new BorderLayout());
        screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setSize(screenSize);
        addComponents();
        setVisible(true);
    }

    public void addComponents() {
        setTitle("Player Screen");

        // Activity Log
        textArea = new JTextArea(35, 35);
        JScrollPane scrollableTextArea = new JScrollPane(textArea);
        scrollableTextArea.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        scrollableTextArea.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        //My Cards
        JScrollPane area = new JScrollPane(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        area.setPreferredSize(new Dimension(300, 200));

        // Catch Buttons
        JPanel pane = new JPanel();
        pane.setPreferredSize(new Dimension(200, 200));
        pane.setBorder(BorderFactory.createLineBorder(Color.black));

        // Close Pile
        JPanel deck = new JPanel();
        deck.setLayout(null);
        JButton button = new JButton("Close pile");
        button.setPreferredSize(new Dimension(30, 30));
        button.setLocation(10, 10);
        button.setBounds(10, 20, 300, 300);
        deck.add(button);
        // open Pile
        JButton button1 = new JButton("open pile");
        button1.setPreferredSize(new Dimension(30, 30));
        button1.setLocation(100, 100);
        button1.setBounds(400, 20, 300, 300);
        deck.add(button1);

        // wild window
        WildCard wildCard = new WildCard();
        wildCard.setBounds(800, 20, 300, 100);
        deck.add(wildCard.addAllButtons(), new GridLayout(2, 2));

        //status hint
        JTextArea area1 = new JTextArea();
        area1.setPreferredSize(new Dimension(50, 50));
        area1.setBounds(10, 350, 900, 300);
        deck.add(area1);

        //UNO button
        JButton unoButton = new JButton("UNO");
        unoButton.setPreferredSize(new Dimension(30, 30));
        unoButton.setLocation(100, 100);
        unoButton.setBounds(930, 350, 275, 200);
        unoButton.setBackground(Color.GREEN);
        deck.add(unoButton);


        getContentPane().add(scrollableTextArea, EAST);
        getContentPane().add(area, BorderLayout.SOUTH);
        getContentPane().add(pane, BorderLayout.NORTH);
        getContentPane().add(deck, BorderLayout.CENTER);


    }

    public static void main(String[] args) {
        new PlayerScreen();
    }

}