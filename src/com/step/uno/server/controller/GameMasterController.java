package com.step.uno.server.controller;

import com.step.uno.factory.Factory;
import com.step.uno.server.GameMaster;

public class GameMasterController {
    private GameMaster gameMaster;

    public GameMasterController(int numberOfPlayers, int numberOfPacks, Factory factory) {

        gameMaster = new GameMaster(numberOfPlayers, numberOfPacks, factory);
        System.out.println("Waiting for all players to connect...");
        gameMaster.start();
    }
 }
