package com.step.uno.server;

import com.step.communication.channel.MessageChannel;
import com.step.communication.server.MessageServer;
import com.step.communication.server.MessageServerListener;
import com.step.uno.factory.Factory;
import com.step.uno.messages.GameResult;
import com.step.uno.model.Card;
import com.step.uno.model.Colour;
import com.step.uno.model.Game;
import com.step.uno.model.Player;

import java.util.ArrayList;
import java.util.List;

public class GameMaster implements MessageServerListener, PlayerProxyObserver {
    private final int totalPlayers;
    private final int totalPacks;
    private final Factory factory;
    private MessageServer server;
    private final List<PlayerProxy> proxies = new ArrayList<>();
    private List<Player> players = new ArrayList<>();
    private Game game;

    public GameMaster(int totalPlayers, int packs, Factory factory) {
        this.totalPlayers = totalPlayers;
        this.totalPacks = packs;
        this.factory = factory;
    }

    public void start() {
        server = factory.communication.createMessageServer();
        server.startListeningForConnections(this);
    }

    @Override
    public void onNewConnection(MessageChannel channel) {
        System.out.println("new Connection");
        if (proxies.size() == totalPlayers) {
            channel.stop();
            return;
        }

        PlayerProxy proxy = new PlayerProxy(channel, this);
        proxy.start();
        proxies.add(proxy);
//        if(proxies.size() == totalPlayers){
//            System.out.println("starting game");
//            startGame();
//        }
    }

    public void startGame() {
        game = factory.createGame(totalPacks, players);
        game.initialize();
        sendSnapshot();
    }

    private void sendSnapshot() {
        for (PlayerProxy proxy : proxies)
            proxy.sendSnapshot(game);
    }

    @Override
    public void onError(Exception e) {

    }

    @Override
    public void onPlayerRegistered(Player player) {
        players.add(player);
        if(players.size() == totalPlayers)
            startGame();
    }

    @Override
    public void onPlayerPlayed(Player player, Card card, Colour newColour) {
        game.playCard(player,card);
        if(player.hasWon())
            sendResult();
        else
            sendSnapshot();
    }

    private void sendResult() {
        GameResult result = new GameResult();
        game.populate(result);
        for (PlayerProxy proxy : proxies)
            proxy.sendResult(result);
    }

    @Override
    public void onPlayerDrewCard(Player player) {
        Card card = game.drawCard(player);
        sendWaitingForDrawnCardAction(player,card);
    }

    private void sendWaitingForDrawnCardAction(Player player, Card card) {
        for (PlayerProxy proxy : proxies) {
            proxy.sendWaitingForDrawnCardAction(player,card);
        }
        sendSnapshot();
    }

    @Override
    public void onPlayerDeclaredUno(Player player) {
        game.declareUno(player);
        sendSnapshot();
    }

    @Override
    public void onPlayerCaughtUno(Player player, int playerIndex) {
        game.catchUno(player,playerIndex);
        sendSnapshot();
    }

    @Override
    public void onPlayerDrewTwoCards(Player player) {
        game.drawTwoCards(player);
        sendSnapshot();
    }

    @Override
    public void onNoActionOnDrawnCard(Player player) {
        game.moveForwardAsPlayerTookNoActionOnDrawnCard();
        sendSnapshot();
    }
}