package com.tw.uno.lib;

import com.tw.uno.lib.card.Card;
import com.tw.uno.lib.card.CardColor;
import com.tw.uno.lib.card.CardValue;
import com.tw.uno.lib.card.NumberCard;
import com.tw.uno.ui.elements.UNOButton;
import com.tw.uno.ui.screen.CreateGameScreen;
import com.tw.uno.ui.screen.GameMasterWindow;
import com.tw.uno.ui.screen.LoginScreen;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

public class UNOFactory {
    Pile pile = new Pile();

    public ServerSocket createServerSocket() {
        try {
            return new ServerSocket(8080);
        } catch (IOException e) {
            throw new RuntimeException("Unable to start the server", e);
        }
    }

    public MessageChannel acceptClient(ServerSocket serverSocket) {
        try {
            Socket socket = serverSocket.accept();
            return new MessageChannel(socket);
        } catch (IOException e) {
            throw new RuntimeException("not able to accept the client");
        }
    }

    public Socket createClientSocket(String serverAddress) {
        try {
            return new Socket(serverAddress, 8080);
        } catch (IOException e) {
            throw new RuntimeException("could not connect to " + serverAddress + " at " + 8080, e);
        }
    }

    public LoginScreen showPlayerLoginScreen(LoginObserver observer) {
        return new LoginScreen(observer);
    }

    public CreateGameScreen showServerStartScreen(ServerScreenObserver observer) {
        return new CreateGameScreen(observer);
    }

    public GameMasterWindow showServerScreen(int numOfPacks, int numOfPlayers) {

        return new GameMasterWindow(numOfPacks, numOfPlayers);
    }

    public NumberCard createCard(String color, String value) {
        Map<String, CardColor> colors = new HashMap<>(4);
        Map<String, CardValue> values = new HashMap<>(10);

        colors.put("RED", CardColor.RED);
        colors.put("BLUE", CardColor.BLUE);
        colors.put("GREEN", CardColor.GREEN);
        colors.put("YELLOW", CardColor.YELLOW);

        String[] numbers = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "drawtwo"};
        CardValue[] cardValues = {CardValue.ZERO, CardValue.ONE, CardValue.TWO, CardValue.THREE,
                CardValue.FOUR, CardValue.FIVE, CardValue.SIX, CardValue.SEVEN,
                CardValue.EIGHT, CardValue.NINE, CardValue.DRAWTWO};

        for (int index = 0; index < numbers.length; index++) {
            values.put(numbers[index], cardValues[index]);
        }

        return new NumberCard(colors.get(color), values.get(value));

    }

    public Card GetTopCardOnPile(){
        return pile.getLastPlacedCard();
    }
    public void addRemovedCardToPile(Card card) {
        pile.addCardToPile(card);
    }

}
