package com.step.programs;

import com.step.uno.client.GameClient;
import com.step.uno.factory.Factory;

public class ClientApp {
    public static void main(String[] args) {
        System.out.println(" 11 hello in am3eClient");

        new GameClient(new Factory()).start(args[0],args[1]);
    }

}
