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
    public boolean[] used;    
    public Match(Card[] cards, Win win, int wildCards){
        boolean checkflush;
        boolean matches;
        Suite s;
        int x, y, matched, cardCount = cards.length;
        Card card;
        
       
        Rule rule;
        Rule[] testPattern = win.getPattern().pattern;
        for (int i=0;i<cards.length;i++){
            // @todo if sorted cards[0] == ace do a special check round
            matched = 0;
            boolean[] used = new boolean[cardCount]; // todo reset instead of recreating
            rule = testPattern[0];

            s = null;
            x = -1;
            y = -1;
            for (int j=0;j<testPattern.length;j++){
                rule = testPattern[j];
                
                card = cards[i];
                int cardToBeTestedIndex = i;
                for (int k=0;k<=cardCount;k++){
                    
                    if (!used[cardToBeTestedIndex] && card != null){
                        boolean ok = true;
                        if (rule.testSuite){
                            ok &= (card.suite == s);
                        }
                        if (rule.testX){
                            if (x == -1){
                                x = card.value;
                            } else {
                                if (!(card.value == 1 && x+rule.offset == 14)){ // skip if we're looking for an ace to finish off a straight
                                    ok &= (card.value == x+rule.offset);
                                }
                                
                            }
                        } else if (rule.testY){
                            if (y == -1){
                                y = card.value;
                            } else {
                                if (!(card.value == 1 && y+rule.offset == 14)){ // skip if we're looking for an ace to finish off a straight
                                    ok &= (card.value == y+rule.offset);
                                }
                            }
                        } else if (rule.testSpecific != -1){
                            ok &= (card.value == rule.testSpecific);
                        }
                        if (ok){
                            matched++;
                            used[cardToBeTestedIndex]=true;
                        }
                    }
                    if (k!=cardCount){
                        card = cards[k];
                        cardToBeTestedIndex = k;
                    }
                }
            }
            
            if (matched+wildCards>=testPattern.length){
                this.isMatch = true;
                this.used = used;
                break;
            }
        }
    }
    
}
