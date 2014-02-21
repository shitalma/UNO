package com.step.uno.client.controller;

import com.step.communication.channel.MessageChannel;
import com.step.communication.channel.MessageChannelListener;
import com.step.uno.client.view.JoinGameView;
import com.step.uno.client.view.PlayerView;
import com.step.uno.factory.Factory;
import com.step.uno.messages.Introduction;
import com.step.uno.messages.Snapshot;

import java.lang.reflect.InvocationTargetException;

public class GameClientController implements MessageChannelListener {
    private Factory factory;
    private JoinGameView joinGameView;
    private PlayerView playerView;
    private MessageChannel channel;

    public GameClientController(Factory factory) {
        this.factory = factory;
    }

    public void join(String serverAddress,String playerName) {
        channel = factory.communication.connectTo(serverAddress,this);
        channel.startListeningForMessages(this);
        channel.send(Introduction.create(playerName));
    }

    @Override
    public void onError(MessageChannel client, Exception e) {

    }

    private void handle(Snapshot snapshot){
        if(playerView == null) playerView = joinGameView.switchToPlayerView();
        playerView.update(snapshot);
    }

    @Override
    public void onMessage(MessageChannel client, Object message) {
        System.out.println((Snapshot)message);

        try {
            System.out.println(getClass().getDeclaredMethod("handle",message.getClass()));
            getClass().getDeclaredMethod("handle",message.getClass())
                    .invoke(this, message);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onConnectionClosed(MessageChannel client) {
        client.stop();
        if(playerView != null)
            playerView.showDisconnected();
    }

    public void bindView(JoinGameView joinGameView) {
        this.joinGameView = joinGameView;
    }
}
