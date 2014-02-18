package com.tw.uno.lib;

import com.tw.uno.ui.screen.LoginScreen;

import java.net.Socket;

public class GameClient implements LoginObserver {
    private UNOFactory unoFactory;
    private Socket socket;
    private LoginScreen loginScreen;

    public GameClient(UNOFactory unoFactory) {
        this.unoFactory = unoFactory;
    }

    public void connectTo(String serverAddress) {
        socket = unoFactory.createClientSocket(serverAddress);
    }


    private void showPlayerLoginScreen() {
        loginScreen = unoFactory.showPlayerLoginScreen( this);
    }

    public static void main(String[] args) {
        new GameClient(new UNOFactory()).showPlayerLoginScreen();
    }


    @Override
    public void onJoin(String serverAddress, String playerName) {
        connectTo(serverAddress);
    }
}
