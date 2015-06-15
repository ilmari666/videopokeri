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
public class CardTest {
   
    public CardTest() {
    }
  
    @Test
    public void createLazyJoker(){
        Card card = new Card(0);
        assertEquals("**", card.toString());
    }
    @Test
    public void aceOfSpades(){
        Card card = new Card(1);
        assertEquals("As", card.toString());
    }
    
    @Test
    public void createKingOfDiamonds(){
        Card card = new Card(52);
        assertEquals("Kd", card.toString());
    }
    
    @Test
    public void revertBackToSeed(){
        Card card = new Card (24);
        assertEquals(24, card.getValueAsInt());
    }
    
    
    @Test
    public void indexOutOfBoundException(){
        Card card = new Card(53);
        assertEquals(card.toString(), "??");
    }

}
