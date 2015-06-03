package com.sokeri.videopokeri.logic;

import com.sokeri.videopokeri.logic.Card;
import java.util.Arrays;

/**
 *
 * @author Ilmari
 */
public class Hand {
    Card[] cards;
    
    public Hand(){
        this.cards = new Card[5];
    }
    
    public Hand(int size){
        this.cards = new Card[size];
    }
    
    public Card discard(Card card){
        return discard(getCardIndex(card));
    }
    
    public Card[] keep(int[] locked){
        int i, j, cursor=0;
        Card[] discarded = new Card[cards.length-locked.length];
        for (i=0;i<cards.length;i++){
            for (j=0;j<locked.length;j++){
                if (locked[j] == i){
                    break;
                }
            }
            if (j == locked.length){
                discarded[cursor] = this.discard(i);
                cursor++;
            }
        }
        return discarded;
    }
    
    public Card[] discardAll(){
        Card[] tmp = this.cards;
        this.cards = null;
        return tmp;
    }
    public Card discard(int cardIndex){
        Card discarded;
        if (cardIndex>=0 && cardIndex<this.cards.length){
            discarded = this.cards[cardIndex];
            this.cards[cardIndex] = null;
            discarded.location = -1;
            return discarded;
        }
        return null;
    }
    
    public int getFreeSlots(){
        int freeSlots = 0;
        for (int i = 0; i<this.cards.length;i++){
            if (this.cards[i] == null){
                freeSlots++;
            }
        }
        return freeSlots;
    }
    
    public Card deal(Card card){
        for (int i = 0; i<this.cards.length;i++){
            if (this.cards[i] == null){
                this.cards[i] = card;
                card.location = i;
                return card;
            }
        }
        return null;
    }
    
    
    public Card[] getCardsWithoutWilds(){
        int i=0, len = this.cards.length, cursor=0;
        Card card;
        
        Card[] returnedCards = new Card[this.getCardCount()]; 
        for (;i<len;i++){
            card = this.cards[i];
            if (card!=null && !card.isWild()){
                returnedCards[cursor] = card;
                cursor++;
            }
        }
        return returnedCards;
    }
    
    public Card[] getCards(){
        // returns null slots too
        return this.cards;
    }
    
    public int getCardCount(){
        int count = 0, i=0, len = this.cards.length;
        for (;i<len;i++){
            if (this.cards[i] != null){
                count++;
            }
        }
        return count;
    }
    
    
    public int getCardIndex(Card card){
        // different implementation to card.location for testing purposes
        for (int i=0; i < this.cards.length; i++){
            if (card.equals(this.cards[i])){
                return i;
            }
        }
        return -1;
    }
    
}
