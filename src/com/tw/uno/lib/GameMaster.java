package com.tw.uno.lib;

import com.tw.uno.lib.card.Card;

import java.io.IOException;
import java.net.ServerSocket;
import java.util.ArrayList;
import java.util.List;

/**
 * This is for the game master to do various responsibilities like start,.
 */
public class GameMaster implements MessageChannelListener {
    private ServerSocket serverSocket;
    private List<MessageChannel> clients;
    private UNOFactory unoFactory;
    private int numOfPlayers;
    private int numOfPacks;

    public GameMaster(UNOFactory unoFactory, int numOfPlayers, int numOfPacks) {
        this.unoFactory = unoFactory;
        this.numOfPlayers = numOfPlayers;
        this.numOfPacks = numOfPacks;
        this.clients = new ArrayList<>();
        this.serverSocket = unoFactory.createServerSocket();

    }

    public void stopGame(){
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
        prepareToPlay();
    }

    private void prepareToPlay() {

        List<Card> cards = unoFactory.getPacksOfCards(numOfPacks);
        for (int i = 0; i < clients.size() * 7; i++) {
            for (MessageChannel client : clients) {
                    client.addCard(cards.get(i));
                    cards.remove(i);
                client.send("CARD:" + cards);
            }
        }
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

    public Game startGame(List<Player> players, List<Card> cards) {
        return new Game(players,cards);
    }
}