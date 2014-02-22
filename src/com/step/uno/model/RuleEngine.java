package com.step.uno.model;

public class RuleEngine {
    public boolean IsCardValidToPlay(Card card,Card lastCard) {
        if (lastCard.colour == card.colour || lastCard.sign == card.sign)
            return true;
        return false;
    }
}
