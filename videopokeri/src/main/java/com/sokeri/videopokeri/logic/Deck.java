package com.sokeri.videopokeri.logic;

import com.sokeri.videopokeri.logic.Card;

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
    
    public Deck(boolean autofill, int jokers){
        cards = new Card[52+jokers];
        int i;
        for (i = 0; i < 52;i++){
            cards[i] = new Card(i+1);
        }
        for (;i<cards.length;i++){
            cards[i] = new Card(0);
        }
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
    
    public Card[] dealCards(Hand hand){
        int freeSlots = hand.getFreeSlots();
        Card[] dealt = new Card[freeSlots];
        for (int i=0;i<freeSlots;i++){
            if (this.cursor<this.cards.length-1){
                 dealt[i] = hand.deal(this.cards[this.cursor]);
                 if (dealt[i] != null){
                     this.cursor++;
                 }
            }
        }
        return dealt;
    }
    
    
    
  
}
