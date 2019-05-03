package logics;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.mycompany.muistipeli.logics.Deck;
import com.mycompany.muistipeli.logics.DeckInitiator;
import java.io.FileNotFoundException;
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
    public void initiatorFillsDeck() throws FileNotFoundException {
        Deck deck = new Deck();
        assertEquals(0, deck.deckSize());
        initor.chooseDeck("animaldeck.txt");
        initor.initiateDeck(deck);

        assertEquals(20, deck.deckSize());

    }

    @Test
    public void chooseAnimalDeckChoosesDeck() throws FileNotFoundException {
        initor.chooseDeck("animaldeck.txt");
        boolean animalIsFound = false;

        Deck deck = new Deck();
        initor.initiateDeck(deck);

        for (int i = 0; i < deck.deckSize(); i++) {
            if (deck.getWord(i).equals("Kana")) {
                animalIsFound = true;
            }
        }

        assertEquals(true, animalIsFound);
    }
    
    @Test
    public void choosePlantDeckChoosesDeck() throws FileNotFoundException {
        initor.chooseDeck("plantdeck.txt");
        boolean plantIsFound = false;

        Deck deck = new Deck();
        initor.initiateDeck(deck);

        for (int i = 0; i < deck.deckSize(); i++) {
            if (deck.getWord(i).equals("Lumme")) {
                plantIsFound = true;
            }
        }

        assertEquals(true, plantIsFound);
    }

}
