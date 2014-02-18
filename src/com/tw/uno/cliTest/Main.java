package com.tw.uno.cliTest;

import com.tw.uno.lib.Player;
import com.tw.uno.lib.card.Card;
import com.tw.uno.lib.card.CardColor;
import com.tw.uno.lib.card.CardValue;
import com.tw.uno.lib.card.NumberCard;

import java.util.ArrayList;
import java.util.List;

/**
 * for command line testing..
 */

public class Main {
    public static void main(String[] args) {
        Player uday = new Player("player");
        List<Card> cards = new ArrayList<>();
        List<Card> remainingCards;

        cards.add(new NumberCard(CardColor.BLUE, CardValue.FIVE));
        cards.add(new NumberCard(CardColor.RED, CardValue.FOUR));

        uday.addCards(cards);

        if (args[0].equalsIgnoreCase("getCards")) {
            for (Card card : cards) {
                System.out.println(card.toString());
            }
        }
        if (args[0].equalsIgnoreCase("placeCard")) {
            System.out.println("before placing card");
            for (Card card : cards) {
                System.out.println(card.toString());
            }
            System.out.println("\nafter placing card");
            uday.placeACard(cards.get(0));
            remainingCards = uday.getCards();
            for (Card remainingCard : remainingCards) {
                System.out.println(remainingCard);
            }

        }

    }
}
