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
import com.sun.prism.impl.PrismSettings;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
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
    private ArrayList<Button> buttonList;
    private ArrayList<Integer> flippedList;
    private Label time;
    private long beginning;
    private long ending;
    private ArrayList<Player> highscore;
    private ArrayList<Label> highscoresAsLabels;

    @Override
    public void init() {
        this.deck = new Deck();
        this.initor = new DeckInitiator();
        this.buttonList = new ArrayList<>();
        flippedList = new ArrayList<>();
        time = new Label();
        highscore = new ArrayList();
        highscoresAsLabels = new ArrayList<>();
    }

    @Override
    public void start(Stage stage) throws Exception {
        int height = 700;
        int width = 600;
        stage.setTitle("Muistipeli");
        stage.setHeight(height);
        stage.setWidth(width);

        //Game view
        GridPane table = new GridPane();
        table.setAlignment(Pos.CENTER);

        buttonList = new ArrayList();
        for (int i = 0; i < 20; i++) {
            Button newButton = new Button(String.valueOf(i));
            buttonList.add(newButton);
        }

        Button checkButton = new Button("Tarkasta");
        checkButton.setMinHeight(100);
        checkButton.setMinWidth(100);

        Button exitGame = new Button("Poistu");
        exitGame.setMinHeight(100);
        exitGame.setMinWidth(100);

        TextField playerName = new TextField("Anna nimi");
        playerName.setMaxWidth(100);
        Button submitPlayer = new Button("Tallenna" + "\n" + "tuloksesi!");

        checkButton.setOnAction(e -> {
            checkCardPair();
            if (deck.isDone()) {
                ending = (System.currentTimeMillis() - beginning) / 1000;
                time.setText(String.valueOf(ending));
                for (int i = 0; i < deck.deckSize(); i++) {
                    buttonList.get(i).setText("Voitit!");

                }
            }
        });

        for (Button button : buttonList) {
            button.setMinHeight(100);
            button.setMinWidth(100);
            button.setOnAction(e -> {
                try {
                    int cardNumber = Integer.parseInt(button.getText());
                    deck.flipCard(cardNumber);
                    flippedList.add(cardNumber);
                    button.setText(deck.getWord(cardNumber));
                    flipFlippedCards();
                    time.setText(String.valueOf((System.currentTimeMillis() - beginning) / 1000));
                } catch (NumberFormatException a) {

                }
            });
        }

        int i = 0;
        for (int x = 0; x < 4; x++) {
            for (int y = 0; y < 5; y++) {
                table.add(buttonList.get(i), y, x);
                i++;
            }
        }
        table.add(checkButton, 2, 5);
        table.add(exitGame, 2, 6);
        time.setPadding(new Insets(40, 40, 40, 40));
        table.add(time, 3, 5);
        table.add(playerName, 0, 5);
        table.add(submitPlayer, 0, 6);

        Scene gameView = new Scene(table);

        //Menu view
        FlowPane menu = new FlowPane();
        Button startGame = new Button("Aloita peli!");
        Button goToHighscores = new Button("Huipputulokset");
        menu.getChildren().add(startGame);
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

        startGame.setOnAction(e -> {
            initor.initiateDeck(deck);
            deck.shuffleDeck();
            for (int index = 0; index < buttonList.size(); index++) {
                buttonList.get(index).setText(String.valueOf(index));
            }
            stage.setScene(gameView);
            beginning = System.currentTimeMillis();
            time.setText("0");
        });

        exitGame.setOnAction(e -> {
            stage.setScene(menuView);
            deck.clear();
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

    public int amountOfVisibleCards() {
        int current = 0;
        for (int i = 0; i < deck.deckSize(); i++) {
            if (deck.getCard(i).isFlipped() && !deck.getCard(i).isPaired()) {
                current++;

            }
        }
        return current;
    }

    public void flipFlippedCards() {
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

    public void checkCardPair() {
        if (amountOfVisibleCards() >= 2) {
            System.out.println(flippedList.get(0));
            System.out.println(flippedList.get(1));
            deck.checkPair(flippedList.get(0), flippedList.get(1));
            flippedList.clear();
        }
    }

    public static void main(String[] args) {
        launch(GraphicInterface.class);
    }

}
