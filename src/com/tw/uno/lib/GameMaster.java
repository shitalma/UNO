package com.tw.uno.lib;

import com.tw.uno.lib.card.Card;

import java.io.IOException;
import java.net.ServerSocket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * This is for the game master to do various responsibilities like start,.
 */
public class GameMaster implements MessageChannelListener {
    private ServerSocket serverSocket;
    private List<MessageChannel> clients;

    private UNOFactory unoFactory;
    private int numOfPlayers;
    Map<Player, MessageChannel> playerChannels = new HashMap<Player, MessageChannel>();
    private int numOfPacks;

    public GameMaster(UNOFactory unoFactory, int numOfPlayers, int numOfPacks) {
        this.unoFactory = unoFactory;
        this.numOfPlayers = numOfPlayers;
        this.numOfPacks = numOfPacks;
        this.clients = new ArrayList<>();
        this.serverSocket = unoFactory.createServerSocket();

    }

    public void stopGame() {
        try {
            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void addClients() {
        for (int i = 0; i < numOfPlayers; i++) {
            MessageChannel channel = unoFactory.acceptClient(serverSocket);
            channel.startListeningForMessages(this);
            clients.add(channel);
        }
        System.out.println(clients.size() + "people joined");
        seeAllPlayers();
    }

    private void seeAllPlayers() {
        System.out.println("M here");
        System.out.println(playerChannels.size());
        for (Player player : playerChannels.keySet()) {
            System.out.println(player.getName());
        }
    }


    @Override
    public void onError(MessageChannel client, Exception e) {
        new RuntimeException("Not able to connect");
    }

    @Override
    public void onMessage(MessageChannel client, Object message) {
        System.out.println(message.toString());
        if(message.toString().startsWith("NAME:")){
            Player player = new Player(message.toString());
            playerChannels.put(player, client);
        }
    }

    @Override
    public void onConnectionClosed(MessageChannel client) {

    }

    public Game startGame(List<Player> players, List<Card> cards) {
        return new Game(players, cards);
    }
}