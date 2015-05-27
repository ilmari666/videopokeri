/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sokeri.videopokeri.math;
import com.sokeri.videopokeri.logic.Hand;
import com.sokeri.videopokeri.logic.Card;
import com.sokeri.videopokeri.logic.Suite;
/**
 *
 * @author Ilmari
 */
public class Match {
    public boolean isMatch;
    
    public Match(Card[] cards, Win win, int wilds){
        boolean checkflush;
        Suite suite;
        String[] testPattern = win.getPattern().split(",");
        if (testPattern[0].indexOf('s')!=-1){
        // simple check will suffice as there's no mixed suit combinations
            checkflush = true;
            suite = cards[0].suite;
        } else {
            checkflush = false;

        }
        for (int i=0,len=testPattern.length;i<len;i++){
            if (checkflush){
                
            }
        }        
        
        
    }
    
}
