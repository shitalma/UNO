package com.tw.uno.lib;

import com.tw.uno.ui.screen.LoginScreen;

import java.net.Socket;

public class GameClient implements LoginObserver {
    private UNOFactory unoFactory;
    private Socket socket;
    private LoginScreen loginScreen;

    public GameClient(UNOFactory unoFactory) {
        this.unoFactory = unoFactory;
        unoFactory.showPlayerLoginScreen(this);
    }

    public void connectTo(String serverAddress) {
        socket = unoFactory.createClientSocket(serverAddress);
    }

    public static void main(String[] args) {
        new GameClient(new UNOFactory());
    }


    @Override
    public void onJoin(String serverAddress, String playerName) {
        connectTo(serverAddress);
    }
}
