package com.tw.uno.lib;

/**
 * This is for
 */
public class Card {
    private String color;
    private int number;

    public Card(String color, int number) {
        this.color = color;
        this.number = number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Card card = (Card) o;

        if (number != card.number) return false;
        if (color != null ? !color.equals(card.color) : card.color != null) return false;

        return true;
    }

}
