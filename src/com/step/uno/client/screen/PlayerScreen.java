package com.step.uno.client.screen;

import com.step.uno.client.screen.elements.MyCards;
import com.step.uno.client.screen.elements.Players;
import com.step.uno.client.screen.elements.WildCard;
import com.step.uno.model.Card;
import com.step.uno.model.Colour;
import com.step.uno.model.Player;
import com.step.uno.model.PlayerSummary;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.util.Arrays;
import java.util.List;

import static java.awt.BorderLayout.EAST;

public class PlayerScreen extends JFrame {
    private final Dimension screenSize;
    JTextArea textArea;
    private java.util.List<Player> players;
    private Card[] myCards;
    private PlayerSummary[] playerSummaries;
    private Card openCard;


    public PlayerScreen(List<Player> player, Card[] myCards, PlayerSummary[] playerSummaries, Card openCard) {
        this.players = player;
        this.myCards = myCards;
        this.playerSummaries = playerSummaries;
        this.openCard = openCard;
        setLayout(new BorderLayout());
//        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setBounds(0,0,screenSize.width, screenSize.height);

        setSize(screenSize);
        addComponents();
        setVisible(true);
        java.awt.Window win[] = java.awt.Window.getWindows();
    }

    public void addComponents() {
        setTitle("Player Screen");

        // Activity Log
        textArea = new JTextArea(35, 35);
        textArea.setFont(new Font("sansserif", Font.BOLD, 20));
        textArea.append("Kavita placed red:5");
        textArea.setEditable(false);
        JScrollPane scrollableTextArea = new JScrollPane(textArea);
        scrollableTextArea.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        scrollableTextArea.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        //My Cards
        MyCards cards = new MyCards(Arrays.asList(this.myCards));
        JScrollPane area = new JScrollPane(cards);
        JPanel pane1 = (JPanel) this.getContentPane();
        pane1.add(area);
        area.setPreferredSize(new Dimension(300, 200));

        // Catch Buttons
        JPanel pane = new JPanel();
        pane.setPreferredSize(new Dimension(250, 250));
        pane.setBorder(BorderFactory.createLineBorder(Color.black));
        pane.add(new Players(Arrays.asList(this.playerSummaries)));

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
        if (openCard.colour.equals(Colour.Red)) button1.setBackground(Color.RED);
        if (openCard.colour.equals(Colour.Green)) button1.setBackground(Color.GREEN);
        if (openCard.colour.equals(Colour.Blue)) button1.setBackground(Color.BLUE);
        if (openCard.colour.equals(Colour.Yellow)) button1.setBackground(Color.YELLOW);
        if (openCard.colour.equals(Colour.Black)) button1.setBackground(Color.BLACK);
        String cardValueInOpenPile = this.openCard.sign.toString();
        if(cardValueInOpenPile.contains("_"))
            cardValueInOpenPile = cardValueInOpenPile.substring(1);
        button1.setText(cardValueInOpenPile);
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
}