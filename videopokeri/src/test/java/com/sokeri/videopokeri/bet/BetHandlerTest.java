package com.sokeri.videopokeri.bet;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.sokeri.videopokeri.bet.BetHandler;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import com.sokeri.videopokeri.Pokeri;
import com.sokeri.videopokeri.player.Player;


/**
 *
 * @author Ilmari
 */
public class BetHandlerTest {
    
    BetHandler betHandler;
    long[] betSteps = {50,100,200};
    Player player;
    Pokeri pokeri;
    public BetHandlerTest() {
        pokeri = new Pokeri();
        pokeri.state = Pokeri.States.PLACE_BET;
    }

    @Before
    public void setUp() {


    }
    
    @Test
    public void playerChangesBet(){
        player = new Player();
        betHandler = new BetHandler(pokeri, betSteps, player);
        player.addMoney(betSteps[1]);
        betHandler.step(false);
        assertEquals(betSteps[1], betHandler.getBet());
    }
    
    @Test
    public void playerCantAffordBetBetLoops(){
        player = new Player();
        betHandler = new BetHandler(pokeri, betSteps, player);
        player.addMoney(betSteps[1]);
        betHandler.step(false);
        betHandler.step(false);
        assertEquals(betSteps[0], betHandler.getBet());
    }

    @Test
    public void playerCantAffordBetBetStepsBack(){
        player = new Player();
        betHandler = new BetHandler(pokeri, betSteps, player);
        player.addMoney(betSteps[1]);
        betHandler.step(false);
        betHandler.step(true);
        assertEquals(betSteps[1], betHandler.getBet());
    }
    @Test
    public void playerCantAffordCurrentBet(){
        player = new Player();
        betHandler = new BetHandler(pokeri, betSteps, player);        
        player.addMoney(betSteps[2]);
        betHandler.step(false);
        betHandler.step(false); // now at bet level #3
        player.placeBet(betSteps[1]);
        assertEquals(false, betHandler.playerAffordsCurrentBet());
    }
    
    
}
