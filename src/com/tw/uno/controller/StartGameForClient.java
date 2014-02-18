package com.tw.uno.controller;

import com.tw.uno.lib.GameClient;
import com.tw.uno.lib.LoginObserver;
import com.tw.uno.lib.UNOFactory;

/**
 * This is for starting game for the client.He joins game from here.
 */
public class StartGameForClient {
    public static void main(String[] args) {
        final UNOFactory unoFactory = new UNOFactory();
//        new GameClient(new UNOFactory(), playerName);
        unoFactory.showPlayerLoginScreen(new LoginObserver() {
            @Override
            public void onJoin(String serverAddress, String playerName) {
                GameClient client = new GameClient(unoFactory,"NAME:" + playerName);
                client.connectTo(serverAddress);
            }
        });

    }
}
