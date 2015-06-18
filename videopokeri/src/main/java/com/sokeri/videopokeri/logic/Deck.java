package com.sokeri.videopokeri.logic;

import com.sokeri.videopokeri.logic.Card;

/**
 *
 * @author Ilmari
 */
/**
 * Logical representation of Deck, holds a set number of cards which can be shuffled and dealed
 */
public class Deck  {
    protected int cursor; // which card index to deal next
    protected Card[] cards;
    
    public Deck() {
        cards = new Card[52];
    }
    public Deck(int size) {
        cards = new Card[size];
    }
    /**
     * constructor that creates a deck and fills it with a common range of cards
     * @param autofill boolean (only used in deciding which constructor is used)
     * @param jokers int number of jokers to pad the deck with
     */
    public Deck(boolean autofill, int jokers) {
        cards = new Card[52 + jokers];
        int i;
        for (i = 0; i < 52; i++) {
            cards[i] = new Card(i + 1);
        }
        for (; i < cards.length; i++) {
            cards[i] = new Card(0);
        }
    }
    /**
     * shuffle the deck
     */
    public void shuffle() {
        // reset dealt and randomize
        Card tmp;
        int rnd;
        this.cursor = 0;
        for (int i = this.cards.length - 1; i >= 0; i--) {
            tmp = this.cards[i];
            tmp.location = -1;
            rnd = (int) (Math.random() * i);
            this.cards[i] = this.cards[rnd];
            this.cards[rnd] = tmp;
        }
    }
    /** 
     * Deals one card to to a given hand
     * @param hand destination hand
     * @return dealt if successful, the dealt card, else null
     */
 
    public Card deal(Hand hand) {
        Card dealt;
        if (this.cursor < this.cards.length - 1) {
            dealt = hand.deal(this.cards[this.cursor]);
            if (dealt != null) {
                this.cursor++;
            }
            return dealt;
        }
        return null;
    }
    /**
     * Deals a given hand 'full' ie fills all null slots
     * @param hand target Hand
     * @return dealt Cards
     */
    public Card[] dealCards(Hand hand) {
        int freeSlots = hand.getFreeSlots();
        Card[] dealt = new Card[freeSlots];
        for (int i = 0; i < freeSlots; i++) {
            if (this.cursor < this.cards.length - 1) {
                dealt[i] = hand.deal(this.cards[this.cursor]);
                if (dealt[i] != null) {
                    this.cursor++;
                }
            }
        }
        return dealt;
    }
}
