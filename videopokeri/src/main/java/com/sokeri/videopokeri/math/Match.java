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
            int j;
            
            matched = 0;
            boolean[] used = new boolean[cardCount]; // todo reset instead of recreating
            rule = testPattern[0];
            if (rule.testSpecific != 0){
                j = 1;
                x = cards[i].value;
                y = -1;
                used[i] = true;
            } else {
                x = -1;
                y = -1;
                j = 0;
            }
            if (rule.testSuite){
                s = cards[i].suite;
            } else {
                s = null;
            }
            
            for (;j<testPattern.length;j++){
                rule = testPattern[j];
                for (int k=0;k<cardCount;k++){
                    if (!used[k]){
                        card = cards[k];
                        boolean ok = true;
                        if (rule.testSuite){
                            ok &= card.suite == s;
                        }
                        if (rule.testX){
                            ok &= (card.value == x+rule.offset);
                        } else if (rule.testY){
                            if (y == -1){
                                y = card.value;
                            } else {
                                ok &= (card.value == y+rule.offset);
                            }
                        } else if (rule.testSpecific != -1){
                            ok &= (card.value == rule.testSpecific);
                        }
                        
                        if (ok){
                            matched++;
                            used[k]=true;
                        }
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
