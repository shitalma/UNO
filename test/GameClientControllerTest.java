import com.step.communication.channel.MessageChannel;
import com.step.communication.factory.CommunicationFactory;
import com.step.uno.client.controller.GameClientController;
import com.step.uno.client.view.JoinGameView;
import com.step.uno.client.view.PlayerView;
import com.step.uno.factory.Factory;
import com.step.uno.messages.Introduction;
import com.step.uno.messages.Snapshot;
import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.*;

public class GameClientControllerTest {
    StubFactory stub = new StubFactory(mock(CommunicationFactory.class));
//    StubFactory stub = mock(StubFactory.class);

    PlayerView playerView = mock(PlayerView.class);
    JoinGameView joinGameView = mock(JoinGameView.class);
    MessageChannel mockMessageChannel = mock(MessageChannel.class);

    private GameClientController controller;

    @Before
    public void setup() {
        when(joinGameView.switchToPlayerView()).thenReturn(playerView);
        when(stub.communication.connectTo(anyString(), any(GameClientController.class))).thenReturn(mockMessageChannel);
        controller = new GameClientController(stub);
    }

    @Test
    public void sendsIntroductionAfterJoiningGame() {
        controller.join("serverAddress","me");
        verify(stub.communication.connectTo("127",controller), times(1)).send(any(Introduction.class));
    }

    @Test
    public void doesNotInformUserWhenConnectionIsLostBeforeGameStarts() {
        controller.join("serverAddress", "me");
        controller.onConnectionClosed(mockMessageChannel);
        verify(playerView, times(0)).showDisconnected();
    }

    @Test
    public void displaysGameSnapshotAsItArrives() {
        controller.join("serverAddress", "me");
        Snapshot snapshot = new Snapshot();
        controller.onMessage(mockMessageChannel, snapshot);
        verify(playerView, times(1)).update(snapshot);
    }

    class StubFactory extends Factory {

        StubFactory(CommunicationFactory communicationFactory) {
            this.communication = communicationFactory;
        }
    }
}