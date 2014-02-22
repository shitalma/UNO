package com.step.uno.client.screen.elements;

import com.step.uno.client.screen.PlayerViewObserver;
import com.step.uno.model.Card;
import com.step.uno.model.Colour;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;


public class MyCards extends JPanel implements ActionListener {
    private PlayerViewObserver playerViewObserver;

    public MyCards(List<Card> cards, PlayerViewObserver playerViewObserver) {
        this.playerViewObserver = playerViewObserver;
        setLayout(new GridLayout(0, cards.size()));
        for (Card card : cards) {
            String cardName = card.sign.toString();
            if (cardName.contains("_"))
                cardName = cardName.substring(1);
            JButton b = new JButton(cardName);
            b.setPreferredSize(new Dimension(160,150));

            if (card.colour.equals(Colour.Red)) b.setBackground(Color.RED);
            if (card.colour.equals(Colour.Green)) b.setBackground(Color.GREEN);
            if (card.colour.equals(Colour.Blue)) b.setBackground(Color.BLUE);
            if (card.colour.equals(Colour.Yellow)) b.setBackground(Color.YELLOW);
            if (card.colour.equals(Colour.Black)) b.setBackground(Color.BLACK);

            setLayout(new FlowLayout());
            Border border1 = new LineBorder(Color.BLACK, 2);
            b.setBorder(border1);
            b.setFont(new Font("sansserif", Font.BOLD, 35));

            b.addActionListener(this);
            add(b);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton button = (JButton) e.getSource();
        CardGenerator generator = new CardGenerator(button.getBackground(), e.getActionCommand());
        this.playerViewObserver.play(generator.createCard());
    }
}
