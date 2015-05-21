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
    public TestDeck(int size){
        super(size);
    }
    public TestDeck(boolean autofill, int jokers){
        super(autofill, jokers);
    }
    public Card getCardAtIndex(int index){
        return this.cards[index];
    }
    public int getDealCount(){
        return this.cursor;
    }
}
