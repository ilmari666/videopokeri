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
    
    public Match checkWins(Hand hand){
        // check wins relies on priority ordered configuration file and thus returns the first match
        Card[] cards = hand.getCardsWithoutWilds(); // get cards to be tested
        Arrays.sort(cards); // sort them for easy matching
        int wildCount = hand.getCards().length - cards.length;
    
        for (int i=0, len = this.wins.length; i<len; i++){
            Match match = new Match (cards, this.wins[i], wildCount);
            if (match.isMatch){
                return match;
            }
        }
        return null;
    }
}
