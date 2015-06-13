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
import com.sokeri.videopokeri.logic.Card;
/**
 *
 * @author Ilmari
 */
/**
 * The main instance of the game which currently controls the flow.
 */
public class Pokeri {
  
    private final Deck deck;
    public enum States {DEPOSIT, PLACE_BET, PLAYER_SELECT, DOUBLE};
    public States state;
    private Player player;
    private BetHandler betHandler;
    private PokerMath math;
    public PokeriGUI gui;
    
    
    public Pokeri(){
        /**
         * @todo need to sort out the flow between states
        */
        this.math = new PokerMath("/math.json");
        deck = new Deck(true,1); // create a full deck with one joker
        player = new Player();
        this.betHandler = new BetHandler(this, math.betSteps, player);
        state = States.PLACE_BET; //States.DEPOSIT;
        this.gui = new PokeriGUI(this, player.hand.getSize());
        
        
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
            System.out.println("Start round successful!");

            player.hand.discardAll();
            gui.hand.removeCards();
            deck.shuffle();
            deck.dealCards(player.hand);
            debugHand();
            gui.hand.dealCards(player.hand.getCardValues());
            gui.hand.setLockableState(true);
            gui.updateMoney(player.getBalance());
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
    public void lockAndDeal(){
     
        if (state == States.PLAYER_SELECT){
            int[] keptIndices = gui.hand.getLocked();
           
            System.out.println("Player select complete");
            player.hand.keep(keptIndices);
            Card[] dealt = deck.dealCards(player.hand);
            gui.hand.removeNonLockedCards();

            gui.hand.dealCards(dealt);
            gui.hand.setLockableState(false);
            debugHand();
            Result result = new Result(this.math.checkWins(player.hand), betHandler.getBet());
            if (result.win != null){
                System.out.println(result);
                player.addMoney(result.getWinSum());
                gui.updateMoney(player.getBalance());
            }
            System.out.println("Player money: "+player.getBalance());
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
    public void debugHand(){
        Card [] playerCards = player.hand.getCards();
        for (int i = 0; i < playerCards.length;i++){
            System.out.println(i+" "+playerCards[i]);
        }
    
    }
    public void continueRound(){
        if (state == States.PLACE_BET){
            startRound();
        } else if (state == States.PLAYER_SELECT){
            lockAndDeal();
        }
    }
    public static void main(String[] args) {
        Pokeri poker = new Pokeri();
        Player player = poker.getPlayer();
        BetHandler betHandler = poker.getBetHandler();
        player.addMoney(10000);
        poker.gui.updateMoney(player.getBalance());
        
    }
}
