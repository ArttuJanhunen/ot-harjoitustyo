/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.muistipeli.ui;

import com.mycompany.muistipeli.logics.Deck;
import com.mycompany.muistipeli.logics.DeckInitiator;
import java.util.Scanner;

/**
 *
 * @author ajanhune
 */
public class TextInterface {

    private Deck deck;
    private DeckInitiator init;

    public TextInterface() {
        this.deck = new Deck();
        this.init = new DeckInitiator();
        init.initiateDeck(deck);
        deck.shuffleDeck();
    }

    public void run(Scanner scanner) {
        System.out.println("Pelataan muistipeliä!");
        System.out.println("Valitse kortti antamalla kortin numero");
        System.out.println("Peli loppuu kun olet löytänyt kaikki parit");
        System.out.println("Pelin voi lopettaa syöttämällä merkin x");
        System.out.println("Pareja on: " + deck.deckSize() / 2);
        System.out.println("Kortteja on: " + deck.deckSize());
        while (true) {

            if (deck.isDone()) {
                System.out.println("Onnistuit!");
                System.out.println("Pelailemisiin!");
                break;
            }
            System.out.println("Pareja jäljellä: " + deck.pairsLeft());
            System.out.println("Kortteja jäljellä: " + deck.cardsLeft());
            System.out.println("Jäljellä olevat numerot: ");
            deck.availableCards();
            System.out.println("");

            System.out.println("Valitse ensimmäinen kortti: ");
            String input = scanner.nextLine();
            try {
                int firstCardNumber = Integer.parseInt(input);
                deck.flipCard(firstCardNumber - 1);
                String firstCard = deck.getWord(firstCardNumber);
                System.out.println("Ensimmäinen kortti: " + firstCardNumber + " Sisältö: " + firstCard);

                System.out.println("Valitse toinen kortti: ");
                String secondInput = scanner.nextLine();
                try {
                    int secondCardNumber = Integer.parseInt(secondInput);
                    deck.flipCard(secondCardNumber - 1);
                    String secondCard = deck.getWord(secondCardNumber);
                    System.out.println("Toinen kortti: " + secondCardNumber + " Sisältö: " + secondCard);
                    deck.checkPair(firstCardNumber, secondCardNumber);
                } catch (NumberFormatException e) {
                    if ("x".equals(secondInput)) {
                        break;
                    }
                    System.out.println("Syötä lukuarvo!");
                }

            } catch (NumberFormatException e) {
                if ("x".equals(input)) {
                    break;
                }
                System.out.println("Syötä lukuarvo!");
            }
            System.out.println("");
            System.out.println("");

        }
    }

    /*public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TextInterface memoryGame = new TextInterface();

        memoryGame.run(scanner);
    }*/
}
