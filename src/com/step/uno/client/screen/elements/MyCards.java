package com.step.uno.client.screen.elements;

import com.step.uno.client.screen.PlayerViewObserver;
import com.step.uno.model.Card;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;


public class MyCards extends JPanel implements ActionListener {
    private PlayerViewObserver playerViewObserver;

    public MyCards(List<Card> cards, PlayerViewObserver playerViewObserver, boolean areCardsEnable) {
        this.playerViewObserver = playerViewObserver;
        setLayout(new GridLayout(0, cards.size()));
        for (Card card : cards) {
            String cardName = card.sign.toString();
            if (cardName.contains("_"))
                cardName = cardName.substring(1);
            JButton cardButton = new JButton(cardName);
            cardButton.setPreferredSize(new Dimension(140, 180));
            cardButton.setBackground(card.colour.getColor());
            cardButton.setEnabled(areCardsEnable);
            setLayout(new FlowLayout());
            Border border1 = new LineBorder(Color.BLACK, 2);
            cardButton.setBorder(border1);
            cardButton.setFont(new Font("sansserif", Font.BOLD, 35));

            cardButton.addActionListener(this);
            add(cardButton);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton button = (JButton) e.getSource();
        CardGenerator generator = new CardGenerator(button.getBackground(), e.getActionCommand());
        this.playerViewObserver.play(generator.createCard());
    }
}
