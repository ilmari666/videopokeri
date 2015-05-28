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
//         System.out.println(StringUtils.join(hand.getCards(), ","));
         RawWin raw =  new RawWin();
         raw.pattern = "x,x+1,x+2,x+3,x+4";
         raw.multiplier = 4;
         raw.name = "teststraight";
         Win win = new Win(raw);
  //       System.out.println(StringUtils.join(win.getPattern().pattern, ","));
         
         PokerMath pMath = new PokerMath();
         pMath.setWins(new Win[]{win});
         Match result = new Match (hand.getCards(), win, 0);
         assertEquals(true, result.isMatch);
         
         
     }
}
