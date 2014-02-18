package com.tw.uno.lib;

import com.tw.uno.ui.screen.CreateGameScreen;
import com.tw.uno.ui.screen.GameMasterWindow;
import com.tw.uno.ui.screen.LoginScreen;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class UNOFactory {
    public ServerSocket createServerSocket() {
        try {
            return new ServerSocket(8080);
        } catch (IOException e) {
            throw new RuntimeException("Unable to start the server", e);
        }
    }

    public MessageChannel acceptClient(ServerSocket serverSocket) {
        try {
            Socket socket = serverSocket.accept();
            return new MessageChannel(socket);
        } catch (IOException e) {
            throw new RuntimeException("not able to accept the client");
        }
    }

    public Socket createClientSocket(String serverAddress) {
        try {
            return new Socket(serverAddress, 8080);
        } catch (IOException e) {
            throw new RuntimeException("could not connect to " + serverAddress + " at " + 8080, e);
        }
    }

    public LoginScreen showPlayerLoginScreen(LoginObserver observer) {
        return new LoginScreen(observer);
    }

    public CreateGameScreen showServerStartScreen(ServerScreenObserver observer) {
        return new CreateGameScreen(observer);
    }

    public GameMasterWindow showServerScreen(int numOfPacks, int numOfPlayers) {
        return new GameMasterWindow();
    }
}
