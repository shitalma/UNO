package com.step.uno.model;

public class RuleEngine {
    public boolean IsCardValidToPlay(Card card,Card lastCard) {
        if(lastCard.sign == Sign.WildDrawFour) return true;
        return lastCard.colour == card.colour || lastCard.sign == card.sign;
    }
}
