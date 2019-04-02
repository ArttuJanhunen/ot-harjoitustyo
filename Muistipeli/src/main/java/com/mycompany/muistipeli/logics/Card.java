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

    public String getWord() {
        return this.word;
    }

    public boolean isFlipped() {
        return this.flipped;
    }

    public void flipCard() {
        this.flipped = !this.flipped;
    }

    public boolean isPaired() {
        return this.isPaired;
    }

    public void setPaired() {
        this.isPaired = true;
    }
}
