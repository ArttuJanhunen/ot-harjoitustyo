/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.muistipeli.logics;

import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author ajanhune
 */
public class Deck {

    private ArrayList<Card> deck;
    private ArrayList<Card> flippedCards;

    public Deck() {
        this.deck = new ArrayList();
        this.flippedCards = new ArrayList();
    }

    /**
     * 
     * @param card takes card as a value, duplicates it and adds both to the deck
     * @see DeckInitiator#initiateDeck(com.mycompany.muistipeli.logics.Deck) 
     */
    public void addCard(Card card) {
        deck.add(card);
        Card pair = new Card(card.getWord());
        deck.add(pair);
    }
    
    /**
     * Shuffles the deck
     */
    public void shuffleDeck() {
        Collections.shuffle(deck);
    }

    /**
     * 
     * @return returns size of the private list deck
     */
    public int deckSize() {
        return deck.size();
    }

    /**
     * 
     * @param chosen chosen is the index of the card to be flipped. 
     * Flips the card that is located in that index in private list deck
     * @see #getCard(int) 
     * @see Card#flipCard() 
     */
    public void flipCard(int chosen) {
        getCard(chosen).flipCard();
    }

    /**
     * 
     * @param first index of the first wanted card in deck
     * @param second index of the second wanted card in deck
     * Gets the words the cards have in them and checks if they match. If they match
     * both cards are set as paired. If not, both cards are flipped back around
     * @see Card#setPaired() 
     * @see #flipCard(int)
     * @see #getWord(int) 
     * 
     */
    public void checkPair(int first, int second) {

        String firstWord = getWord(first);
        String secondWord = getWord(second);
        if (firstWord.equals(secondWord) && first != second) {
            deck.get(first).setPaired();
            deck.get(second).setPaired();
        }
        if (first != second) {
            flipCard(first);
            flipCard(second);
        } else {
            flipCard(first);
        }

    }

    public boolean isDone() {
        for (Card card : deck) {
            if (!card.isPaired()) {
                return false;
            }
        }
        return true;
    }

    public String getWord(int cardNumber) {
        return deck.get(cardNumber).getWord();
    }

    public int pairsLeft() {
        int cardsLeft = deck.size();

        for (Card card : deck) {
            if (card.isPaired()) {
                cardsLeft--;
            }
        }

        int pairsLeft = cardsLeft / 2;

        return pairsLeft;
    }

    public int cardsLeft() {
        int cardsLeft = deck.size();

        for (Card card : deck) {
            if (card.isPaired()) {
                cardsLeft--;
            }
        }

        return cardsLeft;
    }

    public void availableCards() {
        for (int i = 0; i < deck.size(); i++) {
            if (!deck.get(i).isPaired()) {
                System.out.print((i) + " ");
            }
        }
    }

    public Card getCard(int index) {
        return deck.get(index);
    }

    public void clear() {
        deck.clear();
    }

}
