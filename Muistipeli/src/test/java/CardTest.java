/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

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
public class CardTest {

    Card card;

    @Before
    public void setUp() {
        card = new Card("Kala");
    }

    @Test
    public void cardFlippedIsFalseInStart() {
        assertEquals(false, card.isFlipped());
    }

    @Test
    public void cardPairedIsFalseInStart() {
        assertEquals(false, card.isPaired());
    }

    @Test
    public void cardWordIsInitiarted() {
        assertEquals("Kala", card.getWord());
    }

}
