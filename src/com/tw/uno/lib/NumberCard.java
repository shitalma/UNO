package com.tw.uno.lib;

public class NumberCard {
    private CardColor color;
    private int number;

    public NumberCard(CardColor cardColor, int number) {

        this.color = cardColor;
        this.number = number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof NumberCard)) return false;

        NumberCard that = (NumberCard) o;

        if (number != that.number) return false;
        if (!color.equals(that.color)) return false;

        return true;
    }

    @Override
    public String toString() {
        return color+ " " +number;
    }
}
