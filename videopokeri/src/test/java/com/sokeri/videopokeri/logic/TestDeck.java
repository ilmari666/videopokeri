package com.sokeri.videopokeri.logic;

/*
 *
 * @author Ilmari
 *
 * Reveal some Deck values for unit testing
 */
public class TestDeck extends Deck {
    
    public TestDeck(){
        super();
    }
    
    public Card getCardAtIndex(int index){
        return this.cards[index];
    }
    public int getDealCount(){
        return this.cursor;
    }
}
