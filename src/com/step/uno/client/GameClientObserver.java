package com.step.uno.client;

import com.step.uno.messages.GameResult;
import com.step.uno.messages.Snapshot;

public interface GameClientObserver {
    public void onSnapshotReceived(Snapshot snapshot);

    void onDisconnected();

    void waitForTurn();

    void onGameResult(GameResult message);

}
