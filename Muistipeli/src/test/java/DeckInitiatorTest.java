/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.mycompany.muistipeli.logics.Deck;
import com.mycompany.muistipeli.logics.DeckInitiator;
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
public class DeckInitiatorTest {

    private DeckInitiator initor;

    @Before
    public void setUp() {
        initor = new DeckInitiator();
    }

    @Test
    public void initiatorFillsDeck() {
        Deck deck = new Deck();
        assertEquals(0, deck.deckSize());

        initor.initiateDeck(deck);

        assertEquals(20, deck.deckSize());

    }

}
