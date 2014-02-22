package com.step.uno.client.screen;

import com.step.uno.client.screen.elements.MyCards;
import com.step.uno.client.screen.elements.Players;
import com.step.uno.client.screen.elements.WildCard;
import com.step.uno.client.view.PlayerView;
import com.step.uno.messages.Snapshot;
import com.step.uno.model.Card;
import com.step.uno.model.Player;
import com.step.uno.model.PlayerSummary;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

import static java.awt.BorderLayout.EAST;

public class PlayerScreen extends JFrame implements PlayerView {
    private Dimension screenSize;
    private JTextArea textArea;
    private java.util.List<Player> players;
    private Card[] myCards;
    private PlayerSummary[] playerSummaries;
    private Card openCard;
    private PlayerViewObserver playerViewObserver;
    private JButton unoButton;
    private JTextArea hint;
    private WildCard wildCard;
    private JButton openPile;
    private JPanel deck;
    private JPanel catchButton;
    private MyCards cards;
    private JScrollPane scrollPane = new JScrollPane();
    private JScrollPane myCards1;
    private JScrollPane myCardsPane;
    private JScrollPane activityLog;
    private Snapshot snapshot;


    public void updatePlayerScreen(Snapshot snapshot, boolean areCardsVisible) {
        this.snapshot = snapshot;
        this.players = this.snapshot.player;
        this.myCards = snapshot.myCards;
        this.playerSummaries = snapshot.playerSummaries;
        this.openCard = snapshot.openCard;
        setLayout(new BorderLayout());
        screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        screenSize.width = screenSize.width - 100;
        screenSize.height = screenSize.height - 100;
        setSize(screenSize);

        setBounds(50,50,screenSize.width, screenSize.height);
        setTitle(snapshot.currentPlayerName);
        setMinimumSize(screenSize);
        setMaximumSize(screenSize);
        addComponents(areCardsVisible);
        setVisible(true);
    }

    public PlayerScreen() {
    }

    public void addComponents(boolean areCardsVisible) {
        setTitle("Player Screen");
        // Activity Log
        activityLog = getActivityLog();
        //My Cards
        myCardsPane = getMyCards(areCardsVisible);
        // Catch Buttons
        getPlayers();
        // Close Pile
        getDrawButton();
        // open Pile
        getOpenPile();
        // wild window

//        wildCard = new WildCard();
//        wildCard.setBounds(500, 20, 270, 90);
//        deck.add(wildCard.addAllButtons(), new GridLayout(2, 2));

        //status hint
        getStatusHint();
        //UNO button
        getUnoButton();
        getContentPane().add(activityLog, EAST);
        getContentPane().add(myCardsPane, BorderLayout.SOUTH);
        getContentPane().add(catchButton, BorderLayout.NORTH);
        getContentPane().add(deck, BorderLayout.CENTER);
    }

    private void getUnoButton() {
        unoButton = new JButton("UNO");
        unoButton.setPreferredSize(new Dimension(30, 30));
        unoButton.setLocation(100, 100);
        unoButton.setBounds(680, 230, 230, 150);
        unoButton.setBackground(Color.GREEN);
        Border border3 = new LineBorder(Color.BLACK, 3);
        unoButton.setBorder(border3);
        unoButton.setFont(new Font("sansserif", Font.BOLD, 35));
        deck.add(unoButton);
    }

    private void getStatusHint() {
        hint = new JTextArea();
        hint.setPreferredSize(new Dimension(50, 50));
        hint.setBounds(10, 230, 650, 150);
        hint.setEditable(false);
        Border border = BorderFactory.createLineBorder(Color.BLACK);
        hint.setBorder(BorderFactory.createCompoundBorder(border,
                BorderFactory.createEmptyBorder(10, 10, 10, 10)));
        hint.setText("Status hint");
        hint.setFont(new Font("sansserif", Font.BOLD, 25));
        deck.add(hint);
    }

    private void getOpenPile() {
        openPile = new JButton("open pile");
        openPile.setPreferredSize(new Dimension(30, 30));
        openPile.setLocation(100, 100);
        openPile.setBounds(230, 20, 140, 200);
        openPile.setEnabled(false);
        Border border2 = new LineBorder(Color.BLACK, 3);
        openPile.setBorder(border2);
        openPile.setFont(new Font("sansserif", Font.BOLD, 25));

        String cardValueInOpenPile = this.openCard.sign.toString();
        if (cardValueInOpenPile.contains("_"))
            cardValueInOpenPile = cardValueInOpenPile.substring(1);
        openPile.setText(cardValueInOpenPile);
        openPile.setBackground(this.openCard.colour.getColor());
        deck.add(openPile);
    }

    private void getDrawButton() {
        deck = new JPanel();
        deck.setLayout(null);
        JButton drawButton = new JButton(" Draw ");
        drawButton.setPreferredSize(new Dimension(30, 30));
        drawButton.setLocation(10, 10);
        drawButton.setBounds(20, 20, 140, 200);
        Border border1 = new LineBorder(Color.BLACK, 3);
        drawButton.setBorder(border1);
        drawButton.setFont(new Font("sansserif", Font.BOLD, 25));
        deck.add(drawButton);
        drawButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                playerViewObserver.onDraw();
            }
        });
    }

    private void getPlayers() {
        catchButton = new JPanel();
        catchButton.setPreferredSize(new Dimension(180, 180));
        catchButton.setBorder(BorderFactory.createLineBorder(Color.black));
        catchButton.add(new Players(Arrays.asList(this.playerSummaries)));
    }

    private JScrollPane getActivityLog() {
        textArea = new JTextArea(35, 20);
        textArea.setFont(new Font("sansserif", Font.BOLD, 20));
        textArea.append("Kavita placed red:5");
        textArea.setEditable(false);
        JScrollPane scrollableTextArea = new JScrollPane(textArea);
        scrollableTextArea.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        scrollableTextArea.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        return scrollableTextArea;
    }

    private JScrollPane getMyCards(boolean areCardsVisible) {

        this.remove(scrollPane);
        cards = new MyCards(Arrays.asList(snapshot.myCards), playerViewObserver,areCardsVisible);
//        snapshot
        scrollPane = new JScrollPane(cards);
        JPanel pane1 = (JPanel) this.getContentPane();
        pane1.add(scrollPane);
        scrollPane.setPreferredSize(new Dimension(300, 200));
        System.out.println(snapshot.player.get(snapshot.myPlayerIndex));
        System.out.println(areCardsVisible);
//        scrollPane.setEnabled(areCardsVisible);
        return scrollPane;
    }

    @Override
    public void showDisconnected() {
        System.out.println("disconnected");
    }

    @Override
    public void update(Snapshot snapshot, PlayerViewObserver playerViewObserver,boolean areCardsVisible) {
        this.playerViewObserver = playerViewObserver;
        updatePlayerScreen(snapshot,areCardsVisible);
    }
}