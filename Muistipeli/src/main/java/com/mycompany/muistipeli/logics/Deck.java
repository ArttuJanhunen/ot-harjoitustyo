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

    public void addCard(Card card) {
        deck.add(card);
        Card pair = new Card(card.getWord());
        deck.add(pair);
    }

    public void shuffleDeck() {
        Collections.shuffle(deck);
    }

    public int deckSize() {
        return deck.size();
    }

    public void flipCard(int chosen) {
        Card flipped = deck.get(chosen);
        flipped.flipCard();
        deck.set(chosen, flipped);
    }

    public void checkPair(int first, int second) {

        String firstWord = getWord(first);
        String secondWord = getWord(second);
        if (firstWord.equals(secondWord) && first != second) {
            deck.get(first - 1).setPaired();
            deck.get(second - 1).setPaired();
        }
        if (first != second) {
            flipCard(first - 1);
            flipCard(second - 1);
        } else {
            flipCard(first - 1);
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
        return deck.get(cardNumber-1).getWord();
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
    
    public void availableCards(){
        for (int i = 0; i<deck.size(); i++){
            if (!deck.get(i).isPaired()){
                System.out.print((i+1)+" ");
            }
        }
    }

}
