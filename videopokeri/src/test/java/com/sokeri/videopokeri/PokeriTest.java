/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sokeri.videopokeri;

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
public class PokeriTest {
    Pokeri pokeri;
    
    @Before
    public void setUp() {
        pokeri = new Pokeri();
    }
    

    @Test
    public void playerNeedsToDepositMoneyBeforeABetCanBePlaced(){
        assertEquals(false,  pokeri.startRound());
    }
    
    @Test
    public void gameRoundCanStartAfterPlayerHasDeposited(){
        pokeri.deposit(500);
        assertEquals(true, pokeri.startRound());
    }
    
    
}
