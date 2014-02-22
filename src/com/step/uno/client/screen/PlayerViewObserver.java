package com.step.uno.client.screen;

import com.step.uno.model.Card;

public interface PlayerViewObserver {
    public void onDraw();
    public void play(Card card);
}
