package com.step.uno.model;

import com.step.uno.messages.GameResult;
import com.step.uno.messages.Snapshot;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Game {
    private int currentPlayerIndex = 0;
    public final List<Player> players;
    private final Deck closedDeck;
    private final Deck openDeck;
    private boolean isInAscendingOrder = true;
    private Colour runningColour;
    private int draw2Run=0;
    private String hint;
    private String activity = " ";

    public Game(int packs, List<Player> givenPlayers) {
        players = new ArrayList<>(givenPlayers);
        closedDeck = new Deck(Card.createNewPacks(packs));
        openDeck = new Deck();
        //in one pack
        // 4 X {wildcard,wild+4}, 2 X {1-9, +2, reverse, skip}, 0,  for colours {red, green, blue, yellow},

        //get cards for the given number of packs
        //shuffle cards in closedDeck
        //shuffle players
        // from closedDeck give a card to each player seven times
        // put one card to openDeck
        //set current turn to first player
    }

    public void initialize() {
        Collections.shuffle(players);
        closedDeck.shuffle();
        for (int i = 0; i < 7; i++) {
            for (Player player : players) {
                player.take(draw());
            }
        }
        //handle special cards in open card
        Card topCard = draw();
        openDeck.add(topCard);
        getStatusHint(topCard);
    }

    public Deck getOpenDeck() {
        return openDeck;
    }

    private Card draw(){
        //if cards are over, need to shuffle and pick from the bottom of open pile
        if(closedDeck.isEmpty()){
            closedDeck.addAll(openDeck.drawAllButLast());
            closedDeck.shuffle();
        }
        return closedDeck.draw();
    }

    public void populate(Snapshot snapshot, Player player) {
        player.populateSelf(snapshot);
        snapshot.myPlayerIndex = players.indexOf(player);
        List<PlayerSummary> summaries = new ArrayList<>();
        for (Player p : players) {
            summaries.add(p.generateSummary());
        }
        snapshot.player = this.players;
        snapshot.playerSummaries = summaries.toArray(new PlayerSummary[]{});
        snapshot.currentPlayerIndex = currentPlayerIndex;
        snapshot.openCard = openDeck.lookAtLast();
        snapshot.isInAscendingOrder = this.isInAscendingOrder;
        snapshot.runningColour = runningColour;
        snapshot.draw2Run = draw2Run;
        snapshot.hint = hint;
        snapshot.activity = activity;
    }

        //handle action of card
    public void playCard(Player player, Card card) {
        RuleEngine ruleEngine = new RuleEngine();
        Card lastCard = openDeck.lookAtLast();
        boolean isCardValid = ruleEngine.isCardValidToPlay(card, lastCard);
        if(!isCardValid) return;
        player.play(card);
        openDeck.add(card);
        getStatusHint(card);
        getActivity(player,card);
//        handleReverse(card);
//        handleSkip(card);
        handleDrawTwo(card);
//        handleWildCard(card, newColour);
        nextTurn();
    }

    private void getActivity(Player player, Card card) {
        this.activity = player.getName() + " placed "+ runningColour +" "+ card.sign.getValue();
    }

    private void getStatusHint(Card card) {
        this.hint = "U can put " + card.colour + " or "+card.sign.getValue();
    }

    private void handleReverse(Card card) {
        if (!card.sign.equals(Sign.Reverse)) return;
        isInAscendingOrder=!isInAscendingOrder;
    }

    private void handleSkip(Card card) {
        if (!card.sign.equals(Sign.Skip)) return;
        nextTurn();
    }

    private void handleDrawTwo(Card card) {
        if (!card.sign.equals(Sign.DrawTwo)) return;
        draw2Run = draw2Run + 2;

    }

    private void handleWildCard(Card card, Colour newColour) {
        runningColour = card.colour.equals(Colour.Black) ? newColour : card.colour;
        if (card.sign.equals(Sign.WildDrawFour)) applyDrawFour();
    }

    private void applyDrawFour() {
        nextTurn();
        Player player = players.get(currentPlayerIndex);
        for (int i = 0; i < 4; i++) {
            player.take(draw());
        }
    }

    private void nextTurn() {
        //handle reverse and skip
        int increment = isInAscendingOrder?1:-1;
        currentPlayerIndex = currentPlayerIndex + increment + players.size();
        currentPlayerIndex %= players.size();
    }

    public Card drawCard(Player player) {
        //Can play the same card in that turn
        Card newCard = draw();
        player.take(newCard);
        nextTurn();
        return newCard;
    }

    public void declareUno(Player player) {
        player.declareUno();
    }

    public void catchUno(Player player, int playerIndex) {
        Player caughtPlayer = players.get(playerIndex);
        if (caughtPlayer.checkUno()) {
            caughtPlayer.take(draw());
            caughtPlayer.take(draw());
        }
    }

    public void populate(GameResult result) {
        List<PlayerResult> playerResults = new ArrayList<>();
        for (Player player : players) {
            playerResults.add(player.generateResult());
        }
        result.players = playerResults.toArray(new PlayerResult[]{});
        for (PlayerResult playerResult : playerResults) {
            System.out.println(playerResult.name +" "+playerResult.cards +" "+ playerResult.points);
        }
    }

    public void drawTwoCards(Player player) {
        for (int i = 0; i < draw2Run * 2; i++) player.take(draw());
        draw2Run = 0;
        nextTurn();
    }

    public void moveForwardAsPlayerTookNoActionOnDrawnCard() {
        nextTurn();
    }
    public List<Player> getPlayers() {
        return this.players;
    }
 
}
