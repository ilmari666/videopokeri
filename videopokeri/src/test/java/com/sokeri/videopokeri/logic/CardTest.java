/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
    
    public void indexOutOfBoundException(){
        Card card = new Card(53);
        assertEquals(card.toString(), "??");
    }

}
