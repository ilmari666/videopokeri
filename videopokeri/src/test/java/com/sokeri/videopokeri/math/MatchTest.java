/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sokeri.videopokeri.math;

import com.sokeri.videopokeri.logic.Card;
import com.sokeri.videopokeri.logic.Hand;
import org.apache.commons.lang.StringUtils;
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
public class MatchTest {
    
    public MatchTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

     @Test
     public void testMatchStraight() {
         Hand hand = new Hand();
         hand.deal(new Card(1));
         hand.deal(new Card(2));
         hand.deal(new Card(3));
         hand.deal(new Card(4));
         hand.deal(new Card(5));
         RawWin raw =  new RawWin();
         raw.pattern = "x,x+1,x+2,x+3,x+4";
         raw.multiplier = 4;
         raw.name = "teststraight";
         Win straight = new Win(raw);
         
         Match result = new Match (hand.getCards(), straight, 0);
         assertEquals(true, result.isMatch);
     }
     
     @Test
     public void testTwoPair() {
         Hand hand = new Hand();
         hand.deal(new Card(1));
         hand.deal(new Card(1));
         hand.deal(new Card(3));
         hand.deal(new Card(3));
         RawWin raw =  new RawWin();
         raw.pattern = "x,x,y,y";
         raw.multiplier = 4;
         raw.name = "testtwopair";
         Win twopair = new Win(raw);
         
         Match result = new Match (hand.getCards(), twopair, 0);
         assertEquals(true, result.isMatch);
     }
     
     @Test
     public void testAceHighStraight(){
         Card[] cards = new Card[5];
         cards[0] = new Card(1);
         cards[1] = new Card(10);
         cards[2] = new Card(11);
         cards[3] = new Card(12);
         cards[4] = new Card(13);
         RawWin raw =  new RawWin();
         raw.pattern = "x,x+1,x+2,x+3,x+4";
         raw.multiplier = 4;
         raw.name = "teststraight";
         Win acehighstraight = new Win(raw);
         Match result = new Match(cards, acehighstraight, 0);
         assertEquals(true, result.isMatch);
     }
     
     @Test
     public void testNotTwoPair(){
         Hand hand = new Hand();
         hand.deal(new Card(1));
         hand.deal(new Card(1));
         hand.deal(new Card(2));
         hand.deal(new Card(3));
         hand.deal(new Card(4));
         RawWin raw =  new RawWin();
         raw.pattern = "x,x,y,y";
         raw.multiplier = 4;
         raw.name = "testtwopair";
         Win twopair = new Win(raw);
         
         Match result = new Match (hand.getCards(), twopair, 0);
         assertEquals(false, result.isMatch);
     }
     
     @Test
     public void testFlush(){
         Hand hand = new Hand();
         hand.deal(new Card(3));
         hand.deal(new Card(4));
         hand.deal(new Card(7));
         hand.deal(new Card(8));
         hand.deal(new Card(9));
         RawWin raw =  new RawWin();
         raw.pattern = "s,s,s,s,s";
         raw.multiplier = 4;
         raw.name = "testflush";
         Win flush = new Win(raw);
         
         Match result = new Match (hand.getCards(), flush, 0);
         assertEquals(true, result.isMatch);
     }
/**
 * 
 fail: 
 * 
 * 
0 Qc
1 8c
2 **
3 Kc
4 Ac
pair 200mk [Z@7c2f2087
* 
* 
* 
 * 0 9d
1 Th
2 Qh
3 Tc
4 Qs
straight 1000mk [Z@1e20d04b
 
 */
     
/*
     
     0 **
1 8d
2 Qd
3 5d
4 5h
     */
}
