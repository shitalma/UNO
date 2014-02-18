package com.tw.uno.lib;

import java.net.Socket;

public class GameClient implements LoginObserver,MessageChannelListener {
    private UNOFactory unoFactory;
    private MessageChannel channel;
    private String name;

    public GameClient(UNOFactory unoFactory) {
        this.unoFactory = unoFactory;
        unoFactory.showPlayerLoginScreen(this);
    }

    public void connectTo(String serverAddress) {
        Socket socket = unoFactory.createClientSocket(serverAddress);
        channel = new MessageChannel(socket);
        channel.send(name);
    }

    public static void main(String[] args) {
        new GameClient(new UNOFactory());
    }
    @Override
    public void onJoin(String serverAddress, String playerName) {
        this.name = playerName;
        connectTo(serverAddress);
    }

    public String getName() {
        return name;
    }

    @Override
    public void onError(MessageChannel client, Exception e) {

    }

    @Override
    public void onMessage(MessageChannel client, Object message) {
        System.out.println(message);
    }

    @Override
    public void onConnectionClosed(MessageChannel client) {

    }
}
