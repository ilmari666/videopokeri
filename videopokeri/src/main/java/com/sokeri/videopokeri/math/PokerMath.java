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
    public PokerMath (String src){
        MathLoader loader = new MathLoader();
        MathConfig config = loader.load(src);
        this.wins = config.getWins();
    }
    
    public PokerMath(){
        
    }
    public void setWins(Win[] wins){
        this.wins = wins;
    }
    public Match checkWins(Hand hand){
        // check wins relies on priority ordered configuration file and thus returns the first match
        Card[] cards = hand.getCardsWithoutWilds(); // get cards to be tested

        //Arrays.sort(cards); // sort them for easy matching
       // if rising +1 +2 strings would be reversed you could reverse the win check sort would also get biggest pairs first in games played with larger than five card decks. ie 22 44 55 would yield 55 and 44
        // still needs to address the ace issue in pair comparison and in straights
        int wildCount = hand.getCards().length - cards.length;
    
        for (int i=0, len = this.wins.length; i<len; i++){
            System.out.println("i "+i);
            Match match = new Match (cards, this.wins[i], wildCount);
            if (match.isMatch){
                return match;
            }
        }
        return null;
    }
}
