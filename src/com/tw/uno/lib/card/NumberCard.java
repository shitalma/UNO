package com.tw.uno.lib.card;

public class NumberCard implements Card{
    private CardColor color;
    private CardValue value;

    public NumberCard(CardColor cardColor, CardValue value) {
        this.color = cardColor;
        this.value = value;
    }

    public CardValue getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof NumberCard)) return false;

        NumberCard that = (NumberCard) o;

        if (color != that.color) return false;
        if (value != that.value) return false;

        return true;
    }

    @Override
    public String toString() {
        return color+ " " + value.getValue();
    }
}
