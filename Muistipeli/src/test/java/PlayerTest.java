/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.mycompany.muistipeli.logics.Player;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author ajanhune
 */
public class PlayerTest {
    
    private Player player;
    
    @Before
    public void setUp() {
        this.player = new Player("Arttu", 20);
    }
    
    @Test
    public void getNameReturnsName() {
        assertEquals("Arttu", player.getName());
    }
    
    @Test
    public void getTimeReturnsTime() {
        assertEquals(20, player.getTime());
    }
    
    @Test
    public void compareToComparesCorrectly() {
        Player test = new Player("Test", 21);
        Player test1 = new Player("Test", 19);
        Player test2 = new Player("Test", 20);
        
        assertEquals(-1, player.compareTo(test));
        assertEquals(1, player.compareTo(test1));
        assertEquals(0, player.compareTo(test2));
        
    }
    
}
