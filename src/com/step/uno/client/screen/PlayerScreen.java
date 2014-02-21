package com.step.uno.client.screen;

import com.step.uno.client.screen.elements.*;
import com.step.uno.model.Card;
import com.step.uno.model.Colour;
import com.step.uno.model.Player;
import javafx.scene.paint.*;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.Color;
import java.util.Arrays;

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
        textArea.setFont(new Font("sansserif", Font.BOLD,20 ));
        textArea.append("Kavita placed red:5\n");
        textArea.append("Kavita placed red:5 wjjkgjfjngfg");
        textArea.setEditable(false);
        JScrollPane scrollableTextArea = new JScrollPane(textArea);
        scrollableTextArea.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        scrollableTextArea.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        //My Cards
        MyCards cards = new MyCards(Arrays.asList(Card.createCard(Colour.Red, "_7"), Card.createCard(Colour.Blue, "_7"), Card.createCard(Colour.Yellow, "_7")));
        JScrollPane area = new JScrollPane(cards);
        JPanel pane1 = (JPanel) this.getContentPane();
        pane1.add(area);
        area.setPreferredSize(new Dimension(300, 200));

        // Catch Buttons
        JPanel pane = new JPanel();
        pane.setPreferredSize(new Dimension(250, 250));
        pane.setBorder(BorderFactory.createLineBorder(Color.black));
        pane.add(new Players(Arrays.asList(new Player("Shital"), new Player("Shital"), (new Player("Shital"))), Arrays.asList("2", "4", "6")));

        // Close Pile
        JPanel deck = new JPanel();
        deck.setLayout(null);
        JButton button = new JButton("Close pile");
        button.setPreferredSize(new Dimension(30, 30));
        button.setLocation(10, 10);
        button.setBounds(10, 20, 300, 300);
        Border border1 = new LineBorder(Color.BLACK, 3);
        button.setBorder(border1);
        button.setFont(new Font("sansserif", Font.BOLD, 25));
        deck.add(button);

        // open Pile
        JButton button1 = new JButton("open pile");
        button1.setPreferredSize(new Dimension(30, 30));
        button1.setLocation(100, 100);
        button1.setBounds(400, 20, 300, 300);
        Border border2 = new LineBorder(Color.BLACK, 3);
        button1.setBorder(border2);
        button1.setFont(new Font("sansserif", Font.BOLD, 25));
        deck.add(button1);

        // wild window
        WildCard wildCard = new WildCard();
        wildCard.setBounds(800, 20, 300, 100);
        deck.add(wildCard.addAllButtons(), new GridLayout(2, 2));

        //status hint
        JTextArea area1 = new JTextArea();
        area1.setPreferredSize(new Dimension(50, 50));
        area1.setBounds(10, 350, 900, 200);
        area1.setEditable(false);
        Border border = BorderFactory.createLineBorder(Color.BLACK);
        area1.setBorder(BorderFactory.createCompoundBorder(border,
                BorderFactory.createEmptyBorder(10, 10, 10, 10)));
        area1.setText("Status hint");
        area1.setFont(new Font("sansserif", Font.BOLD, 25));
        deck.add(area1);

        //UNO button
        JButton unoButton = new JButton("UNO");
        unoButton.setPreferredSize(new Dimension(30, 30));
        unoButton.setLocation(100, 100);
        unoButton.setBounds(930, 350, 275, 200);
        unoButton.setBackground(Color.GREEN);
        Border border3 = new LineBorder(Color.BLACK, 3);
        unoButton.setBorder(border3);
        unoButton.setFont(new Font("sansserif", Font.BOLD, 35));
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