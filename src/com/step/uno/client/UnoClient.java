package com.step.uno.client;

import com.step.uno.client.controller.GameClientController;
import com.step.uno.client.screen.JoinScreen;
import com.step.uno.factory.Factory;

public class UnoClient {
    public static void main(String[] args) {

        Factory factory = new Factory();

        GameClientController controller = new GameClientController(factory);
        JoinScreen joinScreen = new JoinScreen(controller);
        joinScreen.showScreen();
    }
}
