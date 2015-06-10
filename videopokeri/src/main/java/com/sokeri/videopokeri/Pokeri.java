/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sokeri.videopokeri;

import com.sokeri.videopokeri.math.PokerMath;
import com.sokeri.videopokeri.math.MathLoader;
import com.sokeri.videopokeri.money.Wallet;
import com.sokeri.videopokeri.logic.Deck;
import com.sokeri.videopokeri.money.Player;
import com.sokeri.videopokeri.money.BetHandler;
import com.sokeri.videopokeri.logic.Result;
import com.sokeri.videopokeri.gui.PokeriGUI;
/**
 *
 * @author Ilmari
 */
/**
 * The main instance of the game which currently controls the flow.
 */
public class Pokeri {
  
    private final Deck deck;
    private enum States {DEPOSIT, PLACE_BET, PLAYER_SELECT, DOUBLE};
    private States state;
    private Player player;
    private BetHandler betHandler;
    private PokerMath math;
    private PokeriGUI gui;
    
    public Pokeri(){
        /**
         * @todo need to sort out the flow between states
        */
        this.math = new PokerMath("/math.json");
        this.betHandler = new BetHandler(math.betSteps);
        state = States.PLACE_BET; //States.DEPOSIT;
        deck = new Deck(true,1); // create a full deck with one joker
        player = new Player();
        gui = new PokeriGUI(this);
        
        
    }
    /**
    * method tries to place a bet to start the game round if the state allows
    * when successful shuffles the deck and deals a handful of cards to the player before 
    * continuing to the next state
    * @return true if successful, false if fails
    */
   public boolean startRound(){
       System.out.println("startRound "+state+" "+betHandler.getBet());
 
        // place bet and deal the first round of cards
        if (state == States.PLACE_BET && player.placeBet(betHandler.getBet()) != 0){
            System.out.println(" and action!");

            player.hand.discardAll();
            deck.shuffle();
            deck.dealCards(player.hand);
            gui.dealCards(player.hand.getCardValues());
            state = States.PLAYER_SELECT;
        }
     
        return false;
    }
    /**
     * method deals a new set of cards to the player but keeps the cards the player has elected to keep
     * generates the round result and (when implemented) gives it to the gui later before finally switching state
     * @param keptIndices card slots in player's hand that won't we swapped in the secondary deal
     * 
     */
    public void lockAndDeal(int[] keptIndices){
        Result result = null;
        if (state == States.PLAYER_SELECT){
            player.hand.keep(keptIndices);
            deck.dealCards(player.hand);
            result = new Result(this.math.checkWins(player.hand), betHandler.getBet());
            if (result.win != null){
                player.addMoney(result.getWinSum());
                // gfx display result etc
            }
        }
        // check for remaining money (-> state.deposit)
        state = States.PLACE_BET;
    }
    public Player getPlayer(){
        // for development time purposes
        return this.player;
    }
    public BetHandler getBetHandler(){
        // for developement time use
        return this.betHandler;
    }
    
    
    public static void main(String[] args) {
        
        Pokeri poker = new Pokeri();
        Player player = poker.getPlayer();
        BetHandler betHandler = poker.getBetHandler();
        player.addMoney(10000);
        betHandler.step(player);
//        poker.startRound();
//        poker.lockAndDeal(new int[]{2,3});
        
        
        
    }
}
