package com.step.uno.server.controller;

import com.step.communication.channel.MessageChannel;
import com.step.communication.channel.MessageChannelListener;
import com.step.communication.factory.CommunicationFactory;
import com.step.communication.server.MessageServer;
import com.step.communication.server.MessageServerListener;
import com.step.uno.factory.Factory;
import com.step.uno.messages.Snapshot;
import com.step.uno.server.GameMaster;

import java.util.ArrayList;
import java.util.List;

public class GameMasterController implements MessageServerListener, MessageChannelListener {
    private final int numberOfPlayers;
    private final int numberOfPacks;
    private Factory factory;
//    private MessageServer messageServer;
    private List<MessageChannel> channels = new ArrayList<>();
    private GameMaster gameMaster;

    public GameMasterController(int numberOfPlayers, int numberOfPacks, Factory factory) {

        this.numberOfPlayers = numberOfPlayers;
        this.numberOfPacks = numberOfPacks;
        this.factory = factory;
//        messageServer = factory.communication.createMessageServer();
        gameMaster = new GameMaster(numberOfPlayers, numberOfPacks, factory);
        gameMaster.start();
    }

    @Override
    public void onNewConnection(MessageChannel channel) {
        gameMaster.onNewConnection(channel);
//        if(isHousefull()){
//            channel.stop();
//            return;
//        }
//        channels.add(channel);
//        channel.startListeningForMessages(this);
//        if(isHousefull())startGame();
    }

    private boolean isHousefull() {
        return channels.size() == numberOfPlayers;
    }

    private void startGame() {
        gameMaster.start();
//        Snapshot snapshot = new Snapshot();
//        for (MessageChannel channel : channels) {
//            channel.send(snapshot);
//        }
    }

    @Override
    public void onError(Exception e) {

    }

    public void waitForConnections() {
//        gameMaster = new GameMaster(numberOfPlayers, numberOfPacks, factory);
//        messageServer.startListeningForConnections(this);
    }

    @Override
    public void onError(MessageChannel client, Exception e) {

    }

    @Override
    public void onMessage(MessageChannel client, Object message) {

    }

    @Override
    public void onConnectionClosed(MessageChannel client) {

    }
}
