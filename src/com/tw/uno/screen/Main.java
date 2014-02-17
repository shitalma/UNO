package com.tw.uno.screen;

/**
 *run all windows
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
