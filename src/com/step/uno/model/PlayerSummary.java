package com.step.uno.model;

import java.io.Serializable;

public class PlayerSummary implements Serializable{
    public String name;
    public int cardsInHand;
    private boolean declaredUno;

    @Override
    public String toString() {
        return name+" "+cardsInHand +" "+declaredUno;
    }

    public PlayerSummary(String name, int cardsInHand, boolean declaredUno) {

        this.name = name;
        this.cardsInHand = cardsInHand;
        this.declaredUno = declaredUno;
    }
}
