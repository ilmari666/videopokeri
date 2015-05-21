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
public class WalletTest {
    Wallet wallet;
    public WalletTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        wallet = new Wallet();
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void addMoney(){
        wallet.deposit(20);
        assertEquals(20, wallet.getBalance());
    }

    @Test
    public void withdrawTooMuchFails(){
        wallet.deposit(20);
        assertEquals(false, wallet.withdraw(30));
    }

    @Test
    public void failedWithDrawDoesntAlterBalance(){
        wallet.deposit(20);
        wallet.withdraw(30);
        assertEquals(20, wallet.getBalance());
    }
    

}
