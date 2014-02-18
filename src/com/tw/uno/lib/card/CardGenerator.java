package com.tw.uno.lib.card;

import java.util.HashMap;
import java.util.Map;

/**
 *generate NumberCard
 */
public class CardGenerator {
    public NumberCard createCard(String color, String value) {
        Map<String, CardColor> colors = new HashMap<>(4);
        Map<String, CardValue> values = new HashMap<>(10);

        colors.put("RED", CardColor.RED);
        colors.put("BLUE", CardColor.BLUE);
        colors.put("GREEN", CardColor.GREEN);
        colors.put("YELLOW", CardColor.YELLOW);

        String[] numbers = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "drawtwo"};
        CardValue[] cardValues = {CardValue.ZERO, CardValue.ONE, CardValue.TWO, CardValue.THREE,
                CardValue.FOUR, CardValue.FIVE, CardValue.SIX, CardValue.SEVEN,
                CardValue.EIGHT, CardValue.NINE, CardValue.DRAWTWO};

        for (int index = 0; index < numbers.length; index++) {
            values.put(numbers[index], cardValues[index]);
        }

        return new NumberCard(colors.get(color), values.get(value));

    }

}
