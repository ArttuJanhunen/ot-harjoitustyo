/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.muistipeli.ui;

import com.mycompany.muistipeli.logics.Card;
import com.mycompany.muistipeli.logics.Deck;
import com.mycompany.muistipeli.logics.DeckInitiator;
import com.mycompany.muistipeli.logics.Player;
import java.util.ArrayList;
import java.util.Collections;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author ajanhune
 */
public class GraphicInterface extends Application {

    private Deck deck;
    private DeckInitiator initor;
    private ArrayList<Button> singleGameButtonList;
    private ArrayList<Button> multiGameButtonList;
    private ArrayList<Integer> flippedList;
    private Label time;
    private long beginning;
    private long ending;
    private ArrayList<Player> highscore;
    private ArrayList<Label> highscoresAsLabels;
    private int p1;
    private int p2;
    private int playerTurn;
    private int pairsLeftBefore;

    @Override
    public void init() {
        this.deck = new Deck();
        this.initor = new DeckInitiator();
        this.singleGameButtonList = new ArrayList<>();
        this.multiGameButtonList = new ArrayList();
        this.flippedList = new ArrayList<>();
        this.time = new Label();
        this.highscore = new ArrayList();
        this.highscoresAsLabels = new ArrayList<>();
        this.p1 = 0;
        this.p2 = 0;
    }

    @Override
    public void start(Stage stage) throws Exception {
        int height = 700;
        int width = 600;
        stage.setTitle("Muistipeli");
        stage.setHeight(height);
        stage.setWidth(width);

        //Setup for buttons
        for (int i = 0; i < 20; i++) {
            Button newButton = new Button(String.valueOf(i));
            Button newButton2 = new Button(String.valueOf(i));
            singleGameButtonList.add(newButton);
            multiGameButtonList.add(newButton2);
        }

        //Single game view
        GridPane table = new GridPane();
        table.setAlignment(Pos.CENTER);

        Button checkSingleButton = new Button("Tarkasta");
        checkSingleButton.setMinHeight(100);
        checkSingleButton.setMinWidth(100);

        Button exitSingleGame = new Button("Poistu");
        exitSingleGame.setMinHeight(100);
        exitSingleGame.setMinWidth(100);

        TextField playerName = new TextField("Anna nimi");
        playerName.setMaxWidth(100);
        Button submitPlayer = new Button("Tallenna" + "\n" + "tuloksesi!");

        checkSingleButton.setOnAction(e -> {
            checkCardPair();
            if (deck.isDone()) {
                ending = (System.currentTimeMillis() - beginning) / 1000;
                time.setText(String.valueOf(ending));
                for (int i = 0; i < deck.deckSize(); i++) {
                    singleGameButtonList.get(i).setText("Voitit!");

                }
            }
        });

        for (Button button : singleGameButtonList) {
            button.setMinHeight(100);
            button.setMinWidth(100);
            button.setOnAction(e -> {
                try {
                    int cardNumber = Integer.parseInt(button.getText());
                    deck.flipCard(cardNumber);
                    flippedList.add(cardNumber);
                    button.setText(deck.getWord(cardNumber));
                    flipFlippedCards(singleGameButtonList);
                    time.setText(String.valueOf((System.currentTimeMillis() - beginning) / 1000));
                } catch (NumberFormatException a) {

                }
            });
        }
        for (int x = 0, i = 0; x < 4; x++) {
            for (int y = 0; y < 5; y++) {
                table.add(singleGameButtonList.get(i), y, x);
                i++;
            }
        }
        table.add(checkSingleButton, 2, 5);
        table.add(exitSingleGame, 2, 6);
        time.setPadding(new Insets(30, 30, 30, 30));
        table.add(time, 3, 5);
        table.add(playerName, 0, 5);
        table.add(submitPlayer, 0, 6);

        Scene gameView = new Scene(table);

        //Multiplayer view
        GridPane multiplayerTable = new GridPane();
        multiplayerTable.setAlignment(Pos.CENTER);

        Button exitMultiGame = new Button("Poistu");
        exitMultiGame.setMinHeight(100);
        exitMultiGame.setMinWidth(100);

        Button checkMultiButton = new Button("Tarkasta");
        checkMultiButton.setMinHeight(100);
        checkMultiButton.setMinWidth(100);

        Label player1 = new Label("Pelaaja 1: " + p1);
        Label player2 = new Label("Pelaaja 2: " + p2);
        Label turn = new Label("Pelaajan 1" + "\n" + "vuoro");

        checkMultiButton.setOnAction(e -> {
            checkCardPair();
            if (pairsLeftBefore != deck.pairsLeft() && pairsLeftBefore == 1) {
                if (playerTurn == 2) {
                    p2 += 1;
                    player2.setText("Pelaaja 2: " + p2);
                } else if (playerTurn == 1) {
                    p1 += 1;
                    player1.setText("Pelaaja 1: " + p1);
                }
                pairsLeftBefore = deck.pairsLeft();
            }
            if (deck.isDone()) {
                for (int i = 0; i < deck.deckSize(); i++) {
                    if (p1 > p2) {
                        multiGameButtonList.get(i).setText("Peli ohi!" + "\n" + "Eka voitti!");
                    } else if (p2 > p1) {
                        multiGameButtonList.get(i).setText("Peli ohi!" + "\n" + "Toka voitti!");
                    } else {
                        multiGameButtonList.get(i).setText("Tasapeli!");
                    }
                }
            }
        });

        for (Button button : multiGameButtonList) {
            button.setMinHeight(100);
            button.setMinWidth(100);
            button.setOnAction(e -> {
                try {
                    int cardNumber = Integer.parseInt(button.getText());
                    if (amountOfVisibleCards() >= 2) {
                        if (playerTurn == 1) {
                            playerTurn = 2;
                            turn.setText("Pelaajan 2" + "\n" + "vuoro");
                        } else if (playerTurn == 2) {
                            playerTurn = 1;
                            turn.setText("Pelaajan 1" + "\n" + "vuoro");
                        }
                    }
                    deck.flipCard(cardNumber);
                    flippedList.add(cardNumber);
                    button.setText(deck.getWord(cardNumber));
                    flipFlippedCards(multiGameButtonList);
                    if (pairsLeftBefore != deck.pairsLeft()) {
                        if (playerTurn == 1) {
                            p2 += 1;
                            player2.setText("Pelaaja 2: " + p2);
                        } else if (playerTurn == 2) {
                            p1 += 1;
                            player1.setText("Pelaaja 1: " + p1);
                        }
                        pairsLeftBefore = deck.pairsLeft();
                    }
                } catch (NumberFormatException a) {

                }
            });
        }

        for (int x = 0, i = 0; x < 4; x++) {
            for (int y = 0; y < 5; y++) {
                multiplayerTable.add(multiGameButtonList.get(i), y, x);
                i++;
            }
        }

        multiplayerTable.add(exitMultiGame, 2, 6);
        multiplayerTable.add(checkMultiButton, 2, 5);
        multiplayerTable.add(player1, 3, 5);
        multiplayerTable.add(player2, 3, 6);
        multiplayerTable.add(turn, 1, 5);

        Scene multiplayerView = new Scene(multiplayerTable);

        //Menu view
        FlowPane menu = new FlowPane();
        Button startSingleGame = new Button("Aloita yksinpeli!");
        Button startMultiplayerGame = new Button("Pelaa moninpeli!");
        Button goToHighscores = new Button("Huipputulokset");
        menu.getChildren().add(startSingleGame);
        menu.getChildren().add(startMultiplayerGame);
        menu.getChildren().add(goToHighscores);
        menu.setAlignment(Pos.CENTER);

        Scene menuView = new Scene(menu);

        //Highscore view
        FlowPane highscores = new FlowPane();
        Button backToMenu = new Button("Takaisin valikkoon");
        highscores.getChildren().add(backToMenu);
        highscores.setAlignment(Pos.TOP_CENTER);
        VBox listOfPlayers = new VBox();
        highscores.getChildren().add(listOfPlayers);

        Scene highscoreView = new Scene(highscores);

        //Button actions
        startSingleGame.setOnAction(e -> {
            initor.initiateDeck(deck);
            deck.shuffleDeck();
            for (int index = 0; index < singleGameButtonList.size(); index++) {
                singleGameButtonList.get(index).setText(String.valueOf(index));
            }
            stage.setScene(gameView);
            beginning = System.currentTimeMillis();
            time.setText("0");
        });

        startMultiplayerGame.setOnAction(e -> {
            playerTurn = 1;
            turn.setText("Pelaajan 1" + "\n" + "vuoro");
            initor.initiateDeck(deck);
            pairsLeftBefore = deck.pairsLeft();
            deck.shuffleDeck();
            for (int index = 0; index < multiGameButtonList.size(); index++) {
                multiGameButtonList.get(index).setText(String.valueOf(index));
            }
            stage.setScene(multiplayerView);
        });

        exitSingleGame.setOnAction(e -> {
            stage.setScene(menuView);
            deck.clear();
        });

        exitMultiGame.setOnAction(e -> {
            stage.setScene(menuView);
            deck.clear();
            playerTurn = 0;
            p1 = 0;
            p2 = 0;
            player1.setText("Pelaaja 1: 0");
            player2.setText("Pelaaja 2: 0");
        });

        submitPlayer.setOnAction(e -> {
            try {
                String player = playerName.getText();
                if (ending > 0) {
                    listOfPlayers.getChildren().clear();
                    highscore.add(new Player(player, ending));
                    Collections.sort(highscore);
                    for (Player playerInList : highscore) {
                        Label playersInList = new Label("Pelaajan nimi: " + playerInList.getName() + " Aika: " + playerInList.getTime());
                        listOfPlayers.getChildren().add(playersInList);
                    }
                    ending = 0;
                }

            } catch (Exception a) {

            }
        });

        backToMenu.setOnAction(e -> {
            stage.setScene(menuView);
        });

        goToHighscores.setOnAction(e -> {
            stage.setScene(highscoreView);
        });

        stage.setScene(menuView);
        stage.show();
    }

    /**
     *
     * @return returns the amount of cards that are flipped so that their
     * isFlipped-value is true
     */
    public int amountOfVisibleCards() {
        int current = 0;
        for (int i = 0; i < deck.deckSize(); i++) {
            if (deck.getCard(i).isFlipped() && !deck.getCard(i).isPaired()) {
                current++;

            }
        }
        return current;
    }

    /**
     *
     * @param buttonList list of the buttons in the game. This parameter is used
     * because single player game and multiplayer game have different
     * buttonlists Flips cards back so the words that they contain are hidden
     * again. If card is paired it sets text to the button that indicates that
     * the card is "found".
     * @see #amountOfVisibleCards()
     * @see #checkCardPair()
     * @see Card#isFlipped()
     * @see Deck#flipCard(int)
     */
    public void flipFlippedCards(ArrayList<Button> buttonList) {
        if (amountOfVisibleCards() > 2) {
            checkCardPair();
            for (int i = 0; i < deck.deckSize(); i++) {
                buttonList.get(i).setText(String.valueOf(i));
                if (deck.getCard(i).isPaired()) {
                    buttonList.get(i).setText("Löydetty");
                } else if (deck.getCard(i).isFlipped()) {
                    deck.flipCard(i);
                }

            }
        }

    }

    /**
     * When two cards are turned visible in the deck this method uses deck's
     * method that checks if the two card are a match
     */
    public void checkCardPair() {
        if (amountOfVisibleCards() >= 2) {
            deck.checkPair(flippedList.get(0), flippedList.get(1));
            flippedList.clear();
        }
    }

    public static void main(String[] args) {
        launch(GraphicInterface.class);
    }

}
