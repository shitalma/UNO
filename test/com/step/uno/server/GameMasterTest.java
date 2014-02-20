package com.step.uno.server;

import com.step.uno.factory.Factory;
import com.step.uno.model.Game;
import com.step.uno.model.Player;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

import static org.mockito.Mockito.*;

public class GameMasterTest {

    FactoryStub stub = new FactoryStub();

    @Test
    public void testWhenAllPlayersJoinGameShouldStart() throws Exception {


        GameMaster gameMaster = new GameMaster(2, 1, stub);

        Player uday = new Player("uday");
        Player raj = new Player("raj");
        List<Player> players = new LinkedList<Player>();
        players.add(uday);
        players.add(raj);

        gameMaster.onPlayerRegistered(raj);
        gameMaster.onPlayerRegistered(uday);

        verify(stub.game, times(1)).initialize();
    }

    private class FactoryStub extends Factory {
        Game game = mock(Game.class);

        @Override
        public Game createGame(int totalPacks, List<Player> players) {
            return game;
        }
    }
}
