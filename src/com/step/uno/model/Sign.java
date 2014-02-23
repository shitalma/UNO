package com.step.uno.model;

import java.io.Serializable;

public enum Sign implements Serializable {
    _0(0,"0"),
    _1(1,"1"),
    _2(2,"2"),
    _3(3,"3"),
    _4(4,"4"),
    _5(5,"5"),
    _6(6,"6"),
    _7(7,"7"),
    _8(8,"8"),
    _9(9,"9"),
    Reverse(20,"<->"),
    Skip(20,"@"),
    DrawTwo(20,"+2"),
    WildDrawFour(50,"+4"),
    Wild(50,"W");
    public final int points;
    private String value;

    Sign(int points, String value) {
        this.points = points;

        this.value = value;
    }

    public int getPoints() {
        return points;
    }

    public String getValue() {
        return value;
    }
}
