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
//    public Rule[] pattern;
    private Card[] cards;
    private int wildCards;
    public Win win;
    
    public Match(Card[] cards, Win win, int wildCards){
        this.cards = cards;
        this.wildCards = wildCards;
        this.win = win;
        Rule [] pattern = win.getPattern().pattern;
        Suite s;
        int x, y, matched, cardCount = this.cards.length;
        Card card;
        Rule rule;
        
        for (int i=0;i<cardCount;i++){
            matched = 0;
            used = new boolean[cardCount]; // todo reset instead of recreating
            s = null;
            x = -1;
            y = -1;
            for (int j=0;j<pattern.length;j++){
                rule = pattern[j];
                card = this.cards[i];
                int cardToBeTestedIndex = i;
                for (int k=0;k<=cardCount;k++){
                    if (!used[cardToBeTestedIndex] && card != null){
                        boolean matches = true;
                        if (rule.testSuite){
                            matches &= (card.suite == s);
                        }
                        if (rule.testX){
                            if (x == -1){
                                x = card.value;
                            } else {
                                if (!(card.value == 1 && x+rule.offset == 14)){ // skip if we're looking for an ace to finish off a straight
                                   matches &= (card.value == x+rule.offset);
                                }
                            }
                        } else if (rule.testY){
                            if (y == -1){
                                y = card.value;
                            } else {
                                if (!(card.value == 1 && y+rule.offset == 14)){ // skip if we're looking for an ace to finish off a straight
                                    matches &= (card.value == y+rule.offset);
                                }
                            }
                        } else if (rule.testSpecific != -1){
                            matches &= (card.value == rule.testSpecific);
                        }
                        if (matches){
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
            
            if (matched+wildCards>=pattern.length){
                this.isMatch = true;
                break;
            }
        }        
    }
    
}
