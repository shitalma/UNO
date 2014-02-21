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

public class GameMasterController {
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
        System.out.println("Waiting for all players to connect...");
        gameMaster.start();
    }
 }
