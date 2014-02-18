package com.tw.uno.lib;

import com.tw.uno.ui.screen.WaitingScreen;

import java.net.ServerSocket;
import java.util.ArrayList;
import java.util.List;

/**
 * This is for the game master to do various responsibilities like start,.
 */
public class GameMaster implements ServerScreenObserver,MessageChannelListener {
    private ServerSocket serverSocket;
    private List<MessageChannel> clients;
    private UNOFactory unoFactory;
    private int numOfPlayers;
    private int numOfPacks;

    public GameMaster(UNOFactory unoFactory) {
        this.unoFactory = unoFactory;
        this.clients = new ArrayList<>();
        this.serverSocket = unoFactory.createServerSocket();
        unoFactory.showServerStartScreen(this);
    }

    public void addClients() {
        WaitingScreen waitingScreen = new WaitingScreen();
        for (int i = 0; i < numOfPlayers; i++) {
            MessageChannel channel = unoFactory.acceptClient(serverSocket);
            channel.startListeningForMessages(this);
            clients.add(channel);
        }
        waitingScreen.dispose();
        System.out.println(clients.size() + "people joined");
        prepareToPlay();
    }

    private void prepareToPlay() {
        unoFactory.showServerScreen(numOfPlayers, numOfPacks);
        for (MessageChannel client : clients) {
            client.send("Welcome");
        }
    }

    @Override
    public void onStartGame(String noOfPacks, String noOfPlayers) {
        numOfPlayers = Integer.parseInt(noOfPlayers);
        numOfPacks = Integer.parseInt(noOfPacks);

        addClients();
    }

    public static void main(String[] args) {
        GameMaster master = new GameMaster(new UNOFactory());
    }

    @Override
    public void onError(MessageChannel client, Exception e) {
        new RuntimeException("Not able to connect");
    }

    @Override
    public void onMessage(MessageChannel client, Object message) {
        System.out.println(message);
    }

    @Override
    public void onConnectionClosed(MessageChannel client) {

    }
}