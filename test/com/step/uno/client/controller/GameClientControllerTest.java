package com.step.uno.client.controller;

import com.step.uno.client.GameClient;
import com.step.uno.client.GameClientObserver;
import com.step.uno.client.view.JoinGameView;
import com.step.uno.client.view.PlayerView;
import com.step.uno.factory.Factory;
import com.step.uno.messages.Snapshot;
import com.step.uno.model.Card;
import org.junit.Test;

import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.*;

public class GameClientControllerTest {
    Factory mockedFactory = mock(Factory.class);

    @Test
    public void joinShouldTakeServerAddressAndPlayerNameAndStartGameClient() {

        GameClient gameClient = mock(GameClient.class);
        when(mockedFactory.getGameClient(any(GameClientObserver.class))).thenReturn(gameClient);
        GameClientController controller = new GameClientController(mockedFactory);

        controller.join("serverAddress", "playerName");
        verify(gameClient, atLeastOnce()).start(anyString(), anyString());
    }


    @Test
    public void onDrawShouldCallGameClientsDraw() {
        GameClient gameClient = mock(GameClient.class);
        when(mockedFactory.getGameClient(any(GameClientObserver.class))).thenReturn(gameClient);
        GameClientController controller = new GameClientController(mockedFactory);

        controller.onDraw();
        verify(gameClient, atLeastOnce()).draw();
    }

    @Test
    public void onPlayShouldCallGameClientsPlay() {
        GameClient gameClient = mock(GameClient.class);
        when(mockedFactory.getGameClient(any(GameClientObserver.class))).thenReturn(gameClient);
        GameClientController controller = new GameClientController(mockedFactory);

        controller.play(new Card());
        verify(gameClient, atLeastOnce()).play(any(Card.class));
    }

    @Test
    public void testOnSnapshotReceived() {
//        JoinGameView joinGameView = mock(JoinGameView.class);
//        GameClientController controller = new GameClientController(mockedFactory);
//        controller.onSnapshotReceived(new Snapshot());
//        verify(joinGameView,atLeastOnce()).switchToPlayerView();
    }

    @Test
    public void testOnDisconnected() {

//        GameClientController controller = new GameClientController(mockedFactory);
//        PlayerView mockedPlayerView= mock(PlayerView.class);
//        controller.onDisconnected();
//        verify(mockedPlayerView,atLeastOnce()).showDisconnected();


    }

    @Test
    public void testWaitForTurn() {

    }
}
