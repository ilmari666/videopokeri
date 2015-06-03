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
/**
 *
 * @author Ilmari
 */
public class Pokeri {
    private final Deck deck;
    private enum States {DEPOSIT, PLACE_BET, PLAYER_SELECT, DOUBLE};
    private States state;
    private Player player;
    private BetHandler betHandler;
    private PokerMath math;
    
    public Pokeri(){
        this.math = new PokerMath("/math.json");
        this.betHandler = new BetHandler(math.betSteps);
        state = States.DEPOSIT;
        deck = new Deck(true,1); // create a full deck with one joker
        player = new Player();
        
    }
    public boolean startRound(){
        // place bet and deal the first round of cards
        if (state == States.PLACE_BET && player.placeBet(betHandler.getBet()) != 0){
            player.hand.discardAll();
            deck.shuffle();
            deck.dealCards(player.hand);
            state = States.PLAYER_SELECT;
        }
     
        return false;
    }
    public Result lockAndDeal(int[] keptIndices){
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
        return result;
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
        betHandler.nextBet();
        poker.startRound();
        poker.lockAndDeal(new int[]{2,3});
        
        
        
    }
}
