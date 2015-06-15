package com.sokeri.videopokeri.logic;


/**
 *
 * @author Ilmari
 */

/**
* Logical representation of a  Card which holds information (value,suite,hand slot index) of a card;
*/
public class Card implements Comparable<Card> {
  

    public static final String[] VALUE_STRINGS = { "Joker", "Ace", "Deuce", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King" };
    public static final char[] VALUE_CHARS = { '*', 'A', '2', '3', '4', '5', '6', '7', '8', '9', 'T', 'J', 'Q', 'K' };
    
    
    public int value;
    public Suite suite;
    public int location;
    /**
     * 
     * @param value int (0-13)
     * @param suite instance of Suite
     */
    public Card(int value, Suite suite) {
        this.value = value;
        this.suite = suite;
        this.location = -1; // location relative to the hand dealt
    }
    /** 
     * @param value int (0-13)
     * @param suite int indexed suit value to give to a Suite constructor
    */
    public Card(int value, int suite) {
        
        this.value = value;
        this.suite = new Suite(suite);
        this.location = -1;
    }
    /**
     * lazy constructor that enables deck to be created in a single loop
     * 0 = joker
     * 1 = ace of spades
     * 13 = king of spades
     * 14 = ace of hearts
     * @param value int (0-52)
    */
    public Card(int seedValue) {
        if (seedValue == 0) {
            this.value = 0;
            this.suite = new Suite(Suite.wild);
        } else if (seedValue < 53) {
            seedValue--;
            this.value = (seedValue % 13) + 1;
            this.suite = new Suite((int) Math.floor(seedValue / 13));

            
        } else {
            this.value = -1;
            this.suite = new Suite();
        }
        this.location = -1;
    }
    public boolean isWild() {
        return (this.suite.getValue() == Suite.wild);
    }

    /**
     * @return value as an integer seed. Utilized in graphics.
     */
    public int getValueAsInt() {
        if (value == 0) {
            return value;
        }
        return suite.getValue() * 13 + value;

    }
    
    public String valueAsString() {
        return "" + VALUE_CHARS[this.value];
    }
    
    @Override
    public int compareTo(Card o) {
        return this.value - o.value;
    }
    @Override
    public String toString() {
        if (this.value == -1) {
            return "?" + this.suite;
        }
        return "" + VALUE_CHARS[this.value] + this.suite;
    }


}
