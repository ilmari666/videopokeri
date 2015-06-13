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
    /**
     * This constructor method checks if a set of cards matches a certain win pattern
     * isMatch is set true if matched
     * used is a list of cards used in a match situation
     * win is the matching win that was checked against with
     * @param cards players hand not including wild cards
     * @param win win to be compared against to
     * @param wildCards number of wildcards in the hand 
     */
    public Match(Card[] cards, Win win){
        this.cards = cards;
        this.win = win;
        Rule [] pattern = win.getPattern().pattern;
        int s;
        int x, y, matched =0, cardCount = this.cards.length;
        Card card;
        Rule rule;
 
        // 7 7 5 6 6
        for (int i=0;i<cardCount;i++){
            matched = 0;
            used = new boolean[cardCount]; // todo reset instead of recreating
            s = -1;
            x = -1;
            y = -1;
            rule_loop:
            for (int j=0;j<pattern.length;j++){
                rule = pattern[j];
                card = this.cards[i];
                int cardToBeTestedIndex = i;
                card_loop:
                for (int k=0; k<=cardCount; k++){
                    if (!used[cardToBeTestedIndex] && card != null){
                        boolean matches = true;
                        if (card.isWild()){
                            matched++;
                            used[cardToBeTestedIndex] = true;

                            continue rule_loop;
                        }
                        if (rule.testSuite){
                            if (s == -1){
                                s = card.suite.getValue();
                            } else {
                                matches &= (s == card.suite.getValue());
                            }
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
                            continue rule_loop;
                        }
                    }
                    //if (k!=cardToBeT){
                    int next = cards.length-k-i;
                    while(next<0){
                        next+=cards.length;
                    }
                    while(next>=cards.length){
                        next-=cards.length;
                    }
                    card = cards[next];
                    cardToBeTestedIndex=next;
                      //  cardToBeTestedIndex = k-1;
                    }
                }
            //}
            
            if (matched>=pattern.length){
                this.isMatch = true;
                break;
            }
        }

    }
    
}
