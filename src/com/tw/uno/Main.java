package com.tw.uno;

import com.tw.uno.screen.*;

/**
 *run all windows for testing and debugging.
 */
public class Main {
    public static void main(String[] args) {
        new CreateGameScreen().createFirstScreenFromServerSide();
        new GameMasterWindow();
        new LoginScreen();
        new PlayerScreen();
        new WaitingScreen();
    }
}
