package com.step.uno.client;

import com.step.communication.channel.MessageChannel;
import com.step.communication.channel.MessageChannelListener;
import com.step.communication.factory.CommunicationFactory;
import com.step.uno.client.controller.GameClientController;
import com.step.uno.client.view.JoinGameView;
import com.step.uno.client.view.PlayerView;
import com.step.uno.factory.Factory;
import com.step.uno.messages.Introduction;
import org.junit.Before;
import org.junit.Test;

import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.*;

public class GameClientTest {
    StubFactory stub = new StubFactory(mock(CommunicationFactory.class));

    PlayerView playerView = mock(PlayerView.class);
    JoinGameView joinGameView = mock(JoinGameView.class);
    MessageChannel mockMessageChannel = mock(MessageChannel.class);
    MessageChannelListener messageChannelListener = mock(MessageChannelListener.class);
    private GameClientController controller;

    @Before
    public void setup() {
        when(joinGameView.switchToPlayerView()).thenReturn(playerView);
        when(stub.communication.connectTo(anyString(), any(MessageChannelListener.class))).thenReturn(mockMessageChannel);
        controller = new GameClientController(stub);
    }

    @Test
    public void sendsIntroductionAfterJoiningGame() {
        controller.join("serverAddress", "me");
        verify(stub.communication.connectTo("127",messageChannelListener), times(1)).send(any(Introduction.class));
    }

    class StubFactory extends Factory {

        StubFactory(CommunicationFactory communicationFactory) {
            this.communication = communicationFactory;
        }
    }
}
