
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
         
         Match result = new Match (hand.getCards(), straight);
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
         
         Match result = new Match (hand.getCards(), twopair);
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
         Match result = new Match(cards, acehighstraight);
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
         
         Match result = new Match (hand.getCards(), twopair);
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
         
         Match result = new Match (hand.getCards(), flush);
         assertEquals(true, result.isMatch);
     }
     
    @Test
    public void testTwoPair2(){
         Hand hand = new Hand();
         hand.deal(new Card(6));
         hand.deal(new Card(4));
         hand.deal(new Card(2));
         hand.deal(new Card(4));
         hand.deal(new Card(2));
         RawWin raw =  new RawWin();
         raw.pattern = "x,x,y,y";
         raw.multiplier = 4;
         raw.name = "testtwopair";
         Win twopair = new Win(raw);
         
         Match result = new Match (hand.getCards(), twopair);
         assertEquals(true, result.isMatch);
    }
    
    @Test
    public void testTwoPairHeavy(){
        Card[] cards = new Card[]{new Card(4),new Card(4),new Card(2),new Card(6),new Card(6)};
        RawWin raw =  new RawWin();
        raw.pattern = "x,x,y,y";
        raw.multiplier = 4;
        raw.name = "testtwopair";
        Win twopair = new Win(raw);
        boolean allMatching = true;
        Hand hand = new Hand();
        int i;
        for (i = 0; i < 1000000; i++){
            hand.discardAll();
            for (int j = cards.length;j>0;j--){
                int rnd = (int) Math.random()*j;
                Card tmp = cards[j-1];
                cards[j-1] = cards[rnd];
                cards[rnd] = tmp;
                hand.deal(cards[j-1]);
            }
            Match result = new Match (hand.getCards(), twopair);
            allMatching &= result.isMatch;
         }
        assertEquals(true, allMatching);

         
    }
    
    
    @Test
    public void testStraight2(){
         Hand hand = new Hand();
         hand.deal(new Card(7));
         hand.deal(new Card(7));
         hand.deal(new Card(5));
         hand.deal(new Card(6));
         hand.deal(new Card(6));
         
         RawWin raw =  new RawWin();
         raw.pattern = "x,x+1,x+2,x+3,x+4";
         raw.multiplier = 4;
         raw.name = "teststraight";
         Win straight = new Win(raw);
         
         Match result = new Match (hand.getCards(), straight);
         assertEquals(false, result.isMatch);
    }

}
