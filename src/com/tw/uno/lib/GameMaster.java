package com.tw.uno.lib;

import java.net.ServerSocket;
import java.util.ArrayList;
import java.util.List;

/**
 * This is for the game master to do various responsibilities like start,.
 */
public class GameMaster implements ServerScreenObserver {
    private ServerSocket serverSocket;
    private List<GameClient> clients;
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
        for (int i = 0; i < numOfPlayers; i++) {
            GameClient client = unoFactory.acceptClient(serverSocket);
            clients.add(client);
        }
        System.out.println(clients.size() + "people joined");
    }


    @Override
    public void onStartGame(String noOfPacks, String noOfPlayers) {
        numOfPlayers = Integer.parseInt(noOfPlayers);
        numOfPacks = Integer.parseInt(noOfPacks);
        unoFactory.showServerScreen(numOfPlayers, numOfPacks);
        addClients();
    }
    public static void main(String[] args) {
        new GameMaster(new UNOFactory());
    }
}