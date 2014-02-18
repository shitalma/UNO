package com.tw.uno.ui.elements;

import com.tw.uno.lib.card.Card;
import com.tw.uno.lib.card.CardColor;
import com.tw.uno.lib.card.CardValue;
import com.tw.uno.lib.card.NumberCard;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MyCards extends JPanel implements ActionListener {
    private List<Card> cards = new ArrayList<>();

    public MyCards(List<Card> cards) {
        this.cards = cards;
        setLayout(new GridLayout(0, cards.size()));
        for (Card card : cards) {
            JButton button = new JButton(card.toString());
            button.addActionListener(this);
            add(button);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Card card;
        String[] s = e.getActionCommand().split(" ");
        card = createCard(s[0], s[1]);
        cards.remove(card);
    }

    private NumberCard createCard(String color, String value) {
        Map<String, CardColor> colors = new HashMap<>(4);
        Map<String, CardValue> values = new HashMap<>(10);

        colors.put("RED", CardColor.RED);
        colors.put("BLUE", CardColor.BLUE);
        colors.put("GREEN", CardColor.GREEN);
        colors.put("YELLOW", CardColor.YELLOW);

        String[] numbers = {"zero","one","two","three","four","five","six","seven","eight","nine","drawtwo"};
        CardValue[] cardValues = {CardValue.ZERO, CardValue.ONE,CardValue.TWO,CardValue.THREE,
                                    CardValue.FOUR,CardValue.FIVE,CardValue.SIX,CardValue.SEVEN,
                                    CardValue.EIGHT,CardValue.NINE,CardValue.DRAWTWO};

        for (int index = 0; index < numbers.length; index++) {
            values.put(numbers[index],cardValues[index]);
        }

        return new NumberCard(colors.get(color), values.get(value));
    }
}