/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sokeri.videopokeri.logic;

/**
 *
 * @author Ilmari
 */
public class Deck  {
    protected int cursor; // which card index to deal next
    protected Card[] cards;
    
    public Deck(){
        cards = new Card[52];
    }
    public Deck(int size){
        cards = new Card[size];
    }
    
    public void shuffle(){
        // reset dealt and randomize
        Card tmp;
        int rnd;
        this.cursor = 0;
        for (int i = this.cards.length-1; i>=0; i--){
           tmp = this.cards[i];
           rnd = (int) (Math.random()*i);
           this.cards[i] = this.cards[rnd];
           this.cards[rnd] = tmp;
        }
    }
    
    public Card deal(Hand hand){
        Card dealt;
        if (this.cursor<this.cards.length-1){
             dealt = hand.deal(this.cards[this.cursor]);
             if (dealt != null){
                 this.cursor++;
             }
            return dealt;
        }
        return null;
    }
    
  
}
