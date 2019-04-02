/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.mycompany.muistipeli.logics.Deck;
import com.mycompany.muistipeli.logics.Card;
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
public class DeckTest {

    Deck deck;

    @Before
    public void setUp() {
        deck = new Deck();
    }

    @Test
    public void flipCardWorks() {
        deck.addCard(new Card("Kala"));

        deck.flipCard(0);
        assertEquals(true, deck.getCard(0).isFlipped());
    }

}
