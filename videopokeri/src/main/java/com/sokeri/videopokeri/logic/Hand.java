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
public class Hand {
    Card[] cards;
    int cursor;
    
    public Hand(){
        this.cursor = 0;
        this.cards = new Card[5];
    }
    
    public Hand(int size){
        this.cursor = 0;
        this.cards = new Card[size];
    }
    
    public Card discard(Card card){
        return discard(getCardIndex(card));
    }
    
    public Card discard(int cardIndex){
        Card discarded;
        if (cardIndex>=0 && cardIndex<this.cards.length){
            discarded = this.cards[cardIndex];
            this.cards[cardIndex] = null;
            return discarded;
        }
        return null;
    }
    
    
    public Card deal(Card card){
        for (int i = 0; i<this.cards.length;i++){
            if (this.cards[i] == null){
                this.cards[i] = card;
                return card;
            }
        }
        return null;
    }
    
    public int getCardIndex(Card card){
        for (int i=0; i < this.cursor; i++){
            if (this.cards[i]== card){
                return i;
            }
        }
        return -1;
    }
}
