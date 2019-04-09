/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.muistipeli.ui;

import com.mycompany.muistipeli.logics.Card;
import com.mycompany.muistipeli.logics.Deck;
import com.mycompany.muistipeli.logics.DeckInitiator;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 *
 * @author ajanhune
 */
public class GraphicInterface extends Application {

    private Deck deck;
    private DeckInitiator initor;
    private ArrayList<Button> buttonList;
    ArrayList<Integer> flippedList;

    @Override
    public void init() {
        this.deck = new Deck();
        this.initor = new DeckInitiator();
        initor.initiateDeck(deck);
        deck.shuffleDeck();
        flippedList = new ArrayList<>();
    }

    @Override
    public void start(Stage stage) throws Exception {
        int height = 500;
        int width = 600;
        stage.setTitle("Muistipeli");
        stage.setHeight(height);
        stage.setWidth(width);

        GridPane table = new GridPane();
        table.setAlignment(Pos.CENTER);

        buttonList = new ArrayList();
        for (int i = 0; i < deck.deckSize(); i++) {
            Button newButton = new Button(String.valueOf(i));
            buttonList.add(newButton);
        }

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

        Scene tableView = new Scene(table);

        stage.setScene(tableView);
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
        if (deck.isDone()) {
            for (int i = 0; i < deck.deckSize(); i++) {
                buttonList.get(i).setText("Voitit!");
            }
        }
    }

    public static void main(String[] args) {
        launch(GraphicInterface.class);
    }

}
