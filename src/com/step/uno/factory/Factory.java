package com.step.uno.factory;

import com.step.communication.factory.CommunicationFactory;
import com.step.uno.client.GameClient;
import com.step.uno.client.GameClientObserver;
import com.step.uno.client.controller.GameClientController;
import com.step.uno.client.screen.PlayerViewObserver;
import com.step.uno.model.Game;
import com.step.uno.model.Player;

import java.util.List;

public class Factory {
    public CommunicationFactory communication = new CommunicationFactory();

    public Game createGame(int totalPacks, List<Player> players) {
        return new Game(totalPacks, players);
    }

    public GameClient getGameClient(GameClientObserver observer) {
        return new GameClient(this, observer);
    }
}
