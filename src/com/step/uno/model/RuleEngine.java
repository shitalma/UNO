package com.step.uno.model;

public class RuleEngine {
    public boolean isCardValidToPlay(Card card, Card lastCard) {
        if(lastCard.sign == Sign.WildDrawFour) return true;
        if (lastCard.colour == card.colour || lastCard.sign == card.sign)
            return true;
        return false;
    }
}
