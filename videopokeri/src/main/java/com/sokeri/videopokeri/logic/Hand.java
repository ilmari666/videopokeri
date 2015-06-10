package com.sokeri.videopokeri.logic;

import com.sokeri.videopokeri.logic.Card;
import java.util.Arrays;

/**
 *
 * @author Ilmari
 */

/**
 * Logical representation of a player's hand 
 */
public class Hand {
    public final int SIZE = 5; // default size
    
    private Card[] cards;
    
    public Hand(){
        cards = new Card[SIZE];
        System.out.println("hand! "+cards.length);
    }
    
    public Hand(int size){
        cards = new Card[size];
    }
   /**
    * Discards a Card object from the hand and returns it;
    * @param target 
    * @return removed item
    */
    public Card discard(Card card){
        card.location = -1;
        return discard(getCardIndex(card));
    }
    /**
     * Discards all but cards in given indices
     * @param locked array of card indices to be kept
     * @return discarded cards
     */
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
    /**
     * Discards everything
     * @return discarded and empty
     */
    public Card[] discardAll(){
        Card[] tmp = cards;
        cards = new Card[cards.length];
        return tmp;
    }
    public Card discard(int cardIndex){
        Card discarded;
        if (cardIndex>=0 && cardIndex<cards.length){
            discarded = cards[cardIndex];
            cards[cardIndex] = null;
            discarded.location = -1;
            return discarded;
        }
        return null;
    }
    /**
     * get the amount of free slots in the hand (mainly for dealing new cards)
     * @return number of free slots
     */
    public int getFreeSlots(){
        int freeSlots = 0;
        System.out.println(cards);
        for (int i = 0; i<cards.length;i++){
            if (cards[i] == null){
                freeSlots++;
            }
        }
        return freeSlots;
    }
    /**
     * deal a card to the next available slot
     * @param card card to be dealt
     * @return the dealt cart is successful, else null
     */
    public Card deal(Card card){
       
        for (int i = 0; i<cards.length;i++){
            if (cards[i] == null){
                cards[i] = card;
                card.location = i;
                return card;
            }
        }
        return null;
    }
    

    /**
     * get an array of cards in hand but discard empty slots and cards that are set wild
     * @return a list of non wild cards
    */    
    public Card[] getCardsWithoutWilds(){
        int i=0, len = cards.length, cursor=0;
        Card card;
        
        Card[] returnedCards = new Card[getCardCount()]; 
        for (;i<len;i++){
            card = cards[i];
            if (card!=null && !card.isWild()){
                returnedCards[cursor] = card;
                cursor++;
            }
        }
        return returnedCards;
    }
    /**
     * returns all cards (and also null slots)
     * @return the array representing the players hand
     */
    
    public Card[] getCards(){
        // returns null slots too
        return this.cards;
    }
    
    /**
     * get a count of used slots
     * @return count of used slots
     */
    public int getCardCount(){
        int count = 0, i=0, len = this.cards.length;
        for (;i<len;i++){
            if (this.cards[i] != null){
                count++;
            }
        }
        return count;
    }
    
    /**
     * get a cards index in the hand
     * @param card which card
     * @return if matched the index, else -1
     */
    
    public int getCardIndex(Card card){
        // different implementation to card.location for testing purposes
        for (int i=0; i < this.cards.length; i++){
            if (card.equals(this.cards[i])){
                return i;
            }
        }
        return -1;
    }
    
    /**
     * returns the player hand as simple numbers for visualisation purposes
     */
    public int[] getCardValues(){
        int[] values = new int[cards.length];
        for (int i = 0;i<cards.length;i++){
            values[i] = cards[i].getValueAsInt();
        }
        return values;
    }
    
}
