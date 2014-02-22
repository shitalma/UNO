package com.step.uno.server.controller;

import com.step.communication.channel.MessageChannel;
import com.step.uno.factory.Factory;
import com.step.uno.server.GameMaster;

import java.util.ArrayList;
import java.util.List;

public class GameMasterController {
    private final int numberOfPlayers;
    private final int numberOfPacks;
    private Factory factory;
    private List<MessageChannel> channels = new ArrayList<>();
    private GameMaster gameMaster;

    public GameMasterController(int numberOfPlayers, int numberOfPacks, Factory factory) {

        this.numberOfPlayers = numberOfPlayers;
        this.numberOfPacks = numberOfPacks;
        this.factory = factory;
        gameMaster = new GameMaster(numberOfPlayers, numberOfPacks, factory);
        System.out.println("Waiting for all players to connect...");
        gameMaster.start();
    }
 }
