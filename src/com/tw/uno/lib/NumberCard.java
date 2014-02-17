package com.tw.uno.lib;

public class NumberCard {
    private String color;
    private int number;

    public NumberCard(String color, int number) {

        this.color = color;
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
