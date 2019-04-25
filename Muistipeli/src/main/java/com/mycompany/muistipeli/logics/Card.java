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
public class Card {

    private String word;
    private boolean flipped;
    private boolean isPaired;

    public Card(String word) {
        this.word = word;
        this.flipped = false;
        this.isPaired = false;
    }

    /**
     * 
     * @return the word that card holds
     */
    public String getWord() {
        return this.word;
    }

    /**
     * 
     * @return boolean that indicates if the card is turned visible or not
     */
    public boolean isFlipped() {
        return this.flipped;
    }

    /**
     * this method turns the card visible when it wasn't and hides the card if it was visible
     */
    public void flipCard() {
        this.flipped = !this.flipped;
    }

    /**
     * 
     * @return returns boolean value that indicates if the card and it's pair is already found
     */
    public boolean isPaired() {
        return this.isPaired;
    }
    
    /**
     * Sets the card paired when it's pair is found. This means it changes cards isPaired value to true
     *
     */
    public void setPaired() {
        this.isPaired = true;
    }
}
