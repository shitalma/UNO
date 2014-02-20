package com.step.uno.client;

import com.step.communication.factory.CommunicationFactory;
import com.step.uno.client.controller.GameClientController;
import com.step.uno.client.screen.JoinScreen;

public class UnoClient {
    public static void main(String[] args) {

        CommunicationFactory factory = new CommunicationFactory();

        GameClientController controller = new GameClientController(factory);
        JoinScreen joinScreen = new JoinScreen(controller);
        joinScreen.showScreen();
    }
}
