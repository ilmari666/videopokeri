/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sokeri.videopokeri.math;

import com.sokeri.videopokeri.logic.Hand;
import com.sokeri.videopokeri.logic.Card;
import java.util.Arrays;
/**
 *
 * @author Ilmari
 */
public class PokerMath {
    private Win[] wins;
    public long[] betSteps;
    /**
     * Creates a PokerMath instance
     * @param src JSON configuration source to be mapped to a MathConfig instance
     */
    public PokerMath (String src){
        MathLoader loader = new MathLoader();
        MathConfig config = loader.load(src);
        this.wins = config.getWins();
        
        this.betSteps = config.getBetSteps();
    }
    
    public PokerMath(){
        
    }
 
    public void setWins(Win[] wins){
        // for developement
        this.wins = wins;
    }
    
    
    /**
     * Takes a players hand and compares it against a presorted array of wins and returns the first matching win
     * @param hand Players hand
     * @return match instance if one is found
     */
    public Match checkWins(Hand hand){
        Card[] cards = hand.getCardsWithoutWilds(); // get cards to be tested

        //Arrays.sort(cards); // sort them for easy matching
       // if rising +1 +2 strings would be reversed you could reverse the win check sort would also get biggest pairs first in games played with larger than five card decks. ie 22 44 55 would yield 55 and 44
        // still needs to address the ace issue in pair comparison and in straights
        int wildCount = hand.getCards().length - cards.length; // returns invalid count if  hand not full
    
        for (int i=0, len = this.wins.length; i<len; i++){
            Match match = new Match (cards, this.wins[i], wildCount);
            if (match.isMatch){
                return match;
            }
        }
        return null;
    }
}
