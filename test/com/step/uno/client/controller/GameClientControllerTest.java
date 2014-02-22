package com.step.uno.client.controller;

import com.step.uno.client.GameClient;
import com.step.uno.client.GameClientObserver;
import com.step.uno.client.screen.PlayerViewObserver;
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
    public void shouldStartGameClient() {

        GameClient gameClient = mock(GameClient.class);
        when(mockedFactory.getGameClient(any(GameClientObserver.class))).thenReturn(gameClient);
        GameClientController controller = new GameClientController(mockedFactory);

        controller.join("serverAddress", "playerName");
        verify(gameClient, atLeastOnce()).start(anyString(), anyString());
    }


    @Test
    public void shouldDrawACard() {
        GameClient gameClient = mock(GameClient.class);
        when(mockedFactory.getGameClient(any(GameClientObserver.class))).thenReturn(gameClient);
        GameClientController controller = new GameClientController(mockedFactory);

        controller.onDraw();
        verify(gameClient, atLeastOnce()).draw();
    }

    @Test
    public void playerShouldPlayACard() {
        GameClient gameClient = mock(GameClient.class);
        when(mockedFactory.getGameClient(any(GameClientObserver.class))).thenReturn(gameClient);
        GameClientController controller = new GameClientController(mockedFactory);

        controller.play(new Card());
        verify(gameClient, atLeastOnce()).play(any(Card.class));
    }

    @Test
    public void shouldSwitchAPlayerView() {
        JoinGameView joinGameView = mock(JoinGameView.class);
        GameClientController controller = new GameClientController(mockedFactory);
        when(joinGameView.switchToPlayerView()).thenReturn(mock(PlayerView.class));

        controller.bindView(joinGameView);
        Snapshot mockSnapShot = mock(Snapshot.class);
        controller.onSnapshotReceived(mockSnapShot);

        verify(joinGameView, times(1)).switchToPlayerView();
    }

    @Test
    public void shouldUpdateAPlayerViewOnPlayerAction() throws Exception {
        JoinGameView joinGameView = mock(JoinGameView.class);
        GameClientController controller = new GameClientController(mockedFactory);
        PlayerView mockPlayerView = mock(PlayerView.class);
        when(joinGameView.switchToPlayerView()).thenReturn(mockPlayerView);

        controller.bindView(joinGameView);
        Snapshot mockSnapShot = mock(Snapshot.class);
        controller.onSnapshotReceived(mockSnapShot);

        verify(joinGameView, times(1)).switchToPlayerView();
        verify(mockPlayerView,times(1)).update(any(Snapshot.class),any(PlayerViewObserver.class));
    }

    @Test
    public void shouldInformUserWhenServerIsClosed() {
        JoinGameView joinGameView = mock(JoinGameView.class);
        GameClientController controller = new GameClientController(mockedFactory);
        PlayerView mockPlayerView = mock(PlayerView.class);
        when(joinGameView.switchToPlayerView()).thenReturn(mockPlayerView);

        controller.bindView(joinGameView);
        Snapshot mockSnapShot = mock(Snapshot.class);
        controller.onSnapshotReceived(mockSnapShot);
        controller.onDisconnected();
        verify(joinGameView, times(1)).switchToPlayerView();
        verify(mockPlayerView,times(1)).update(any(Snapshot.class),any(PlayerViewObserver.class));
        verify(mockPlayerView,times(1)).showDisconnected();
    }
}
