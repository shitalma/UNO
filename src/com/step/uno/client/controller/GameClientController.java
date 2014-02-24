package com.step.uno.client.controller;

import com.step.uno.client.GameClient;
import com.step.uno.client.GameClientObserver;
import com.step.uno.client.screen.PlayerViewObserver;
import com.step.uno.client.view.JoinGameView;
import com.step.uno.client.view.PlayerView;
import com.step.uno.factory.Factory;
import com.step.uno.messages.GameResult;
import com.step.uno.messages.Snapshot;
import com.step.uno.model.Card;

public class GameClientController implements PlayerViewObserver, GameClientObserver {
    private JoinGameView joinGameView;
    private PlayerView playerView;
    private GameClient gameClient;

    public GameClientController(Factory factory) {
        gameClient = factory.getGameClient(this);

    }

    public void join(String serverAddress, String playerName) {
        gameClient.start(playerName, serverAddress);
    }

    public void bindView(JoinGameView joinGameView) {
        this.joinGameView = joinGameView;
    }


    @Override
    public void onDraw() {
        gameClient.draw();
    }

    @Override
    public void play(Card card) {

        gameClient.play(card);
    }

    @Override
    public void onSnapshotReceived(Snapshot snapshot) {
        boolean areCardsVisible = false;
        if (playerView == null)
            playerView = joinGameView.switchToPlayerView();
        if (snapshot.myPlayerIndex == snapshot.currentPlayerIndex) {
            areCardsVisible = true;
        }
        playerView.update(snapshot, this, areCardsVisible);

    }

    @Override
    public void onDisconnected() {
        playerView.showDisconnected();
    }

    @Override
    public void waitForTurn() {

    }

    @Override
    public void onGameResult(GameResult gameResult) {
        playerView.switchToResultView(gameResult);
    }

}
