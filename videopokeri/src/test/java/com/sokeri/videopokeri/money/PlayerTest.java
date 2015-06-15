/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sokeri.videopokeri.money;

import com.sokeri.videopokeri.player.Player;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author makktonnikala
 */
public class PlayerTest {
    Player player;
    public PlayerTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {

    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
         player=new Player();
    }
    
    @After
    public void tearDown() {
    }


    @Test
    public void testDeposit() {
        player.addMoney(10);
        assertEquals(10, player.getBalance());
    }
    
    @Test
    public void cantAffordTest(){
        player.addMoney(10);
        assertEquals(false, player.canAfford(20));
    }
    
    @Test
    public void canAffordTest(){
        player.addMoney(20);
        assertEquals(true, player.canAfford(10));
    }
    
}
