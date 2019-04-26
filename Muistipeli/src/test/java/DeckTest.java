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

    @Test
    public void checkPairworks() {
        deck.addCard(new Card("Kala"));

        assertEquals(false, deck.getCard(0).isPaired());
        assertEquals(false, deck.getCard(1).isPaired());

        deck.checkPair(0, 1);

        assertEquals(true, deck.getCard(0).isPaired());
        assertEquals(true, deck.getCard(1).isPaired());
    }

    @Test
    public void checkPairWorksWhenCardsDontMatch() {
        deck.addCard(new Card("Kala"));
        deck.addCard(new Card("Possu"));

        assertEquals(false, deck.getCard(0).isPaired());
        assertEquals(false, deck.getCard(2).isPaired());

        deck.checkPair(0, 2);

        assertEquals(false, deck.getCard(0).isPaired());
        assertEquals(false, deck.getCard(1).isPaired());

    }

    @Test
    public void checkpairFlipsCardOnlyOnceIfItChecksSameIndexTwice() {
        deck.addCard(new Card("Kala"));
        deck.checkPair(0, 0);

        assertEquals(false, deck.getCard(0).isFlipped());
        assertEquals(false, deck.getCard(0).isPaired());

        deck.flipCard(0);
        deck.checkPair(0, 0);

        assertEquals(false, deck.getCard(0).isFlipped());
    }

    @Test
    public void isDoneWorks() {
        deck.addCard(new Card("Kala"));

        assertEquals(false, deck.isDone());

        deck.checkPair(0, 1);

        assertEquals(true, deck.isDone());
    }

    @Test
    public void pairsLeftWorks() {
        deck.addCard(new Card("Kala"));

        assertEquals(1, deck.pairsLeft());
    }

    @Test
    public void cardsLeftWorks() {
        deck.addCard(new Card("Kala"));
        deck.addCard(new Card("Possu"));

        assertEquals(4, deck.cardsLeft());

        deck.getCard(0).setPaired();

        assertEquals(3, deck.cardsLeft());
    }

    @Test
    public void clearWorks() {
        deck.addCard(new Card("Kala"));
        deck.addCard(new Card("Possu"));

        assertEquals(4, deck.deckSize());

        deck.clear();

        assertEquals(0, deck.deckSize());
    }

    @Test
    public void whenPairsLeftIsCalledAndCardsArePairedIntCardsLeftReduces() {
        deck.addCard(new Card("Kala"));
        deck.addCard(new Card("Possu"));

        assertEquals(2, deck.pairsLeft());

        deck.getCard(0).setPaired();
        deck.getCard(1).setPaired();

        assertEquals(1, deck.pairsLeft());

    }

}
