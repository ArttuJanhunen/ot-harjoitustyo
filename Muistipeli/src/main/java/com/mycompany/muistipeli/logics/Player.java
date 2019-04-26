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
public class Player implements Comparable<Player> {

    private String name;
    private long time;

    public Player(String name, long time) {
        this.name = name;
        this.time = time;
    }

    /**
     * 
     * @return returns player's name
     */
    public String getName() {
        return this.name;
    }

    /**
     * 
     * @return returns player's time
     */
    public long getTime() {
        return this.time;
    }
    
    /**
     * Helps to sort players in highscore list so that the fastest player is the first one
     * @param t is another player
     * @return returns -1, 0, 1 depending on comparison of the times
     */
    @Override
    public int compareTo(Player t) {
        if (this.time < t.time) {
            return -1;
        } else if (this.time > t.time) {
            return 1;
        }
        return 0;
    }
}
