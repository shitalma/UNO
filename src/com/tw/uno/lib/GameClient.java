package com.tw.uno.lib;

import java.net.Socket;

public class GameClient implements MessageChannelListener {
    private UNOFactory unoFactory;
    private MessageChannel channel;
    private String name;

    public GameClient(UNOFactory unoFactory, String playerName) {
        this.unoFactory = unoFactory;
        this.name = playerName;
    }

    public void connectTo(String serverAddress) {
        Socket socket = unoFactory.createClientSocket(serverAddress);
        channel = new MessageChannel(socket);
        channel.send(name);
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
