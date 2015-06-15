package com.sokeri.videopokeri.logic;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Ilmari
 */
public class HandTest {
    Hand hand;
    public HandTest() {
    }
 
    @Before
    public void setUp() {
        hand = new Hand();
    }
    
    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    @Test
    public void dealCard(){
       Card card = new Card(1, Suite.spade);
       hand.deal(card);
       assertEquals(0, hand.getCardIndex(card));
    }
    
    @Test
    public void dealTooManyCards(){
        for (int i=0;i<5;i++){
            hand.deal(new Card(i));
        }
        assertEquals(null, hand.deal(new Card(5)));
    }
    
    @Test
    public void discardCard(){
       Card card = new Card(1, Suite.spade);
       hand.deal(card);
       hand.discard(card);
       assertEquals(-1, hand.getCardIndex(card));
    }
}
