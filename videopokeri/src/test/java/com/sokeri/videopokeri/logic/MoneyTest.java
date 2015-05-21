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
public class MoneyTest {
    Money money;
    public MoneyTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        money = new Money();
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void addMoney(){
        money.deposit(20);
        assertEquals(money.getBalance(), 20);
    }

    @Test
    public void withdrawTooMuchFails(){
        money.deposit(20);
        assertEquals(money.withdraw(30), false);
    }

    @Test
    public void failedWithDrawDoesntAlterBalance(){
        money.deposit(20);
        money.withdraw(30);
        assertEquals(money.getBalance(), 20);
    }
    

}
