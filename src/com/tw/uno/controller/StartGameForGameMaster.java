package com.tw.uno.controller;

import com.tw.uno.lib.GameMaster;
import com.tw.uno.lib.ServerScreenObserver;
import com.tw.uno.lib.UNOFactory;
import com.tw.uno.ui.screen.WaitingScreen;

/*
* This is controller for game master.
* */
public class StartGameForGameMaster {
    public static void main(String[] args) {

        final UNOFactory unoFactory = new UNOFactory();

        unoFactory.showServerStartScreen(new ServerScreenObserver() {
            @Override
            public void onStartGame(String noOfPacks, String noOfPlayers) {
                int numOfPlayers = Integer.parseInt(noOfPlayers);
                int numOfPacks = Integer.parseInt(noOfPacks);
                GameMaster gameMaster = new GameMaster(unoFactory, numOfPlayers, numOfPacks);
                WaitingScreen waitingScreen = new WaitingScreen();
                gameMaster.addClients();
                waitingScreen.dispose();
                unoFactory.showServerScreen(numOfPlayers, numOfPacks);
            }

        });

    }
}