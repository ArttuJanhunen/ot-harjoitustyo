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
        flippedList = new ArrayList();
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

        for (int i = 1; i <= deck.deckSize(); i++) {
            Button newButton = new Button(String.valueOf(i));
            newButton.setMinHeight(100);
            newButton.setMinWidth(100);
            newButton.setOnAction(e -> {
                try {
                    int cardNumber = Integer.parseInt(newButton.getText());
                    deck.flipCard(cardNumber - 1);
                    if (deck.getCard(cardNumber - 1).isFlipped()) {
                        newButton.setText(deck.getWord(cardNumber));
                    }
                    checkFlipped();
                } catch (NumberFormatException a) {

                }

            });

            buttonList.add(newButton);
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

    public void checkFlipped() {

        for (int i = 0; i < deck.deckSize(); i++) {
            if (deck.getCard(i).isFlipped()) {
                flippedList.add(i);
            }
        }

        if (flippedList.size() == 2) {
            deck.checkPair(flippedList.get(0) + 1, flippedList.get(1) + 1);
            pairedCards();
            flipCards();
            flippedList.clear();
        }
    }

    public void flipCards() {
        for (int i = 0; i < deck.deckSize(); i++) {
            if (deck.getCard(i).isFlipped() && !deck.getCard(i).isPaired()) {
                deck.getCard(i).flipCard();
                buttonList.get(i).setText(String.valueOf(i + 1));
            }
        }
    }

    public void pairedCards() {
        for (int i = 0; i < deck.deckSize(); i++) {
            if (deck.getCard(i).isPaired()) {
                buttonList.get(i).setText("Kortti pelattu");
            }
        }
    }

    public static void main(String[] args) {
        launch(GraphicInterface.class);
    }

}
