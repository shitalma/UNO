package com.tw.uno.lib;

import com.tw.uno.lib.card.Card;

/**
 *create event onCardPlaced of MyCards
 */
public interface CardListener {
    public void onCardPlaced(Card card);
    public void onCardDrew();
}
