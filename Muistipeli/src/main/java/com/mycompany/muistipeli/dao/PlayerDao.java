/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.muistipeli.dao;

import com.mycompany.muistipeli.logics.Player;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ajanhune
 */
public class PlayerDao {

    public void getHighscores(ArrayList<Player> highscores) throws IOException {
        String path = new File("highscores.txt").getAbsolutePath();
        File list = new File(path);
        Scanner scanner;
        try {
            scanner = new Scanner(list);
        } catch (FileNotFoundException ex) {
            list.createNewFile();
            scanner = new Scanner(list);
        }
        while (scanner.hasNext()) {
            String row = scanner.nextLine();
            String[] player = row.split(";");
            highscores.add(new Player(player[0], Long.parseLong(player[1])));
        }
    }

    public void saveHighScores(ArrayList<Player> highscores) throws IOException {
        String path = new File("highscores.txt").getAbsolutePath();
        File list = new File(path);
        FileWriter writer = new FileWriter(list);

        for (Player player : highscores) {
            writer.write(player.getName() + ";" + player.getTime() + "\n");
        }

        writer.flush();
        writer.close();

    }

}
