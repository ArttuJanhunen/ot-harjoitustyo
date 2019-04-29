/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.muistipeli.logics;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *
 * @author ajanhune
 */
public class DeckInitiator {

    private String[] words;

    public DeckInitiator() {
        this.words = new String[10];
    }

    /**
     *
     * @param deck this method initiates the deck that is given as parameter. It
     * goes trough a list of objects, creates cards from these objects and calls
     * addCard-method that belongs to the given deck
     * @see Deck#addCard(com.mycompany.muistipeli.logics.Card)
     */
    public void initiateDeck(Deck deck) {
        for (String word : words) {
            deck.addCard(new Card(word));
        }
    }

    public void chooseDeck(String file) throws FileNotFoundException {
        File deck = new File(file);
        Scanner scanner = new Scanner(deck);
        int i = 0;
        while (scanner.hasNext()) {
            String line = scanner.nextLine();
            words[i] = line;
            i++;
        }
    }
}
