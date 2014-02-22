package com.step.uno.model;

public class RuleEngine {
    public boolean IsCardValidToPlay(Card card,Card lastCard) {
        if(lastCard.sign == Sign.WildDrawFour)
            return false;
        if(lastCard.sign == Sign.DrawTwo && lastCard.sign != card.sign)
            return false;
        if(card.sign == Sign.Wild || card.sign == Sign.WildDrawFour)
            return true;
        if (lastCard.colour == card.colour || lastCard.sign == card.sign)
            return true;
        return false;
    }
}
