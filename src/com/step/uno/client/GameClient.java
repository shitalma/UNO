package com.step.uno.client;

import com.step.communication.channel.MessageChannel;
import com.step.communication.channel.MessageChannelListener;
import com.step.uno.factory.Factory;
import com.step.uno.messages.*;
import com.step.uno.model.Card;
import com.step.uno.model.Colour;

public class GameClient implements MessageChannelListener {
    private Factory factory;
    private MessageChannel channel;
    private String playerName;
    private GameClientObserver observer;

    public GameClient(Factory factory, GameClientObserver observer) {
        this.factory = factory;
        this.observer = observer;
    }

    public void start(String playerName, String serverAddress) {
        System.out.println("I am gc");
        this.playerName = playerName;
        this.channel = factory.communication.connectTo(serverAddress, this);
        channel.startListeningForMessages(this);
        sendIntroduction();
    }

    private void sendIntroduction() {
        channel.send(Introduction.create(playerName));
    }

    public void play(Card card) {
        channel.send(new PlayCardAction(card));
    }

    public void play(Card card, Colour newColour) {
        //dont allow WildDraw4 when running colour is present
        //dont allow colour change to last card when heading to last card
        channel.send(new PlayCardAction(card, newColour));
    }

    public void informNoActionOnDrawnCard() {
        channel.send(new NoActionOnDrawnCard());
    }

    public void draw() {
        System.out.println(channel == null);
        channel.send(new DrawCardAction());
    }

    public void drawTwo() {
        channel.send(new DrawTwoCardAction());
    }

    public void declareUno() {
        channel.send(new DeclareUnoAction());
    }

    public void catchUno(int playerIndex) {
        channel.send(new CatchUnoAction(playerIndex));
    }

    @Override
    public void onError(MessageChannel client, Exception e) {

    }

//    private void handle(Snapshot snapshot) {
//        if (playerView == null) playerView = joinGameView.switchToPlayerView();
//        playerView.update(snapshot);
//    }

    @Override
    public void onMessage(MessageChannel client, Object message) {
//        System.out.println((Snapshot) message);
        if(message.getClass().equals(Snapshot.class))
            observer.onSnapshotReceived((Snapshot) message);
        if(message.getClass().equals(WaitingForDrawnCardAction.class)){
            observer.waitForTurn();
        }
//        try {
//            System.out.println(getClass().getDeclaredMethod("handle", message.getClass()));
//            getClass().getDeclaredMethod("handle", message.getClass())
//                    .invoke(this, message);
//        } catch (IllegalAccessException e) {
//            e.printStackTrace();
//        } catch (InvocationTargetException e) {
//            e.printStackTrace();
//        } catch (NoSuchMethodException e) {
//            e.printStackTrace();
//        }
    }

    @Override
    public void onConnectionClosed(MessageChannel client) {
        client.stop();

        observer.onDisconnected();
    }
}
