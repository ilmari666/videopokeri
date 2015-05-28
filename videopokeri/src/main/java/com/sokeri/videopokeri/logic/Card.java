package com.sokeri.videopokeri.logic;


/**
 *
 * @author Ilmari
 */
public class Card implements Comparable<Card>{
    //public enum Suites {SPADE, HEART, CLUB, DIAMOND, WILD}

    public static final String[] valueStrings = {"Joker","Ace","Deuce","3","4","5","6","7","8","9","10", "Jack","Queen", "King"};
    public static final char[] valueChars = {'*','A','2','3','4','5','6','7','8','9','T','J','Q','K'};
    
    
    public int value;
    public Suite suite;
    public int location;
    
    public Card (int value, Suite suite){
        this.value = value;
        this.suite = suite;
        this.location = -1; // location relative to the hand dealt
    }
    
    public Card (int value, int suite){
        this.value = value;
        this.suite = new Suite(suite);
        this.location = -1;
    }
    public Card (int seedValue){

        // lazy constructor that enables deck to be created in a single loop
        // eats values from 0 to 52 and creates cards accordingly
        // 0 = joker
        // 1 = ace of spades
        // 13 = king of spades
        
        if (seedValue == 0){
            this.value = 0;
            this.suite = new Suite(Suite.WILD);
        } else if (seedValue < 53){
            seedValue--;
            this.value = (seedValue%13)+1;
            this.suite = new Suite((int) Math.floor(seedValue/13));

            
        } else {
            this.value = -1;
            this.suite = new Suite();
        }
        this.location = -1;
    }
    public boolean isWild(){
        return (this.suite.getValue() == Suite.WILD);
    }

    public String valueAsString(){
        return ""+valueChars[this.value];
    }
    
    @Override
    public int compareTo(Card o){
        return this.value-o.value;
    }
    @Override
    public String toString (){
        if (this.value == -1){
            return "?"+this.suite;
        }
        return ""+valueChars[this.value]+this.suite;
    }


}
