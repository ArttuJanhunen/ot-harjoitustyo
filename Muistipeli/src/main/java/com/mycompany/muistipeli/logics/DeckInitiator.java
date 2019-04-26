/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.muistipeli.logics;

/**
 *
 * @author ajanhune
 */
public class DeckInitiator {

    private String[] words;

    public DeckInitiator() {
        this.words = new String[10];
        words[0] = "Kala";
        words[1] = "Porsas";
        words[2] = "Kana";
        words[3] = "Lehmä";
        words[4] = "Koira";
        words[5] = "Kissa";
        words[6] = "Käärme";
        words[7] = "Siili";
        words[8] = "Kameleontti";
        words[9] = "Kameli";
    }

    /**
     * 
     * @param deck this method initiates the deck that is given as parameter. It 
     * goes trough a list of objects, creates cards from these objects and calls addCard-method that belongs to the
     * given deck
     * @see Deck#addCard(com.mycompany.muistipeli.logics.Card) 
     */
    public void initiateDeck(Deck deck) {
        for (String word : words) {
            deck.addCard(new Card(word));
        }
    }
}
