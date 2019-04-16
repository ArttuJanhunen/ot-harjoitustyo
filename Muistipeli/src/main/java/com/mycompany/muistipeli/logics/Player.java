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

    public String getName() {
        return this.name;
    }

    public long getTime() {
        return this.time;
    }

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
