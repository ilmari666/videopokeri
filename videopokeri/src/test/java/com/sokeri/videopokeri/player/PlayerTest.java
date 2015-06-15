/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sokeri.videopokeri.player;

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
    
    @Before
    public void setUp() {
        player = new Player();
    }


    @Test
    public void testDeposit() {
        player.addMoney(10);
        assertEquals(10, player.getBalance());
    }
    
    @Test
    public void testPlaceBett() {
        player.addMoney(10);
        player.placeBet(10);
        assertEquals(0, player.getBalance());
    }
    

    
}
