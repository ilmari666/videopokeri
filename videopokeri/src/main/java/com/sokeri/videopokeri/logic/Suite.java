package com.sokeri.videopokeri.logic;

/**
 *
 * @author Ilmari
 */
/**
 * 
 * A logical representation of a playing card's suite
 */
public class Suite {
    public static int spade = 0;
    public static int heart = 1;
    public static int club = 2;
    public static int diamond = 3;
    public static int wild = 4;
    
    public static char[] suiteChars = {'s', 'h', 'c', 'd', '*'};
    private int value;
    
    public Suite() {
        this.value = -1; // undefined
    }
    public Suite(int suite) {
        this.value = suite;
    }
    public int getValue() {
        return this.value;
    }
    @Override
    public String toString() {
        if (this.value >= 0) {
            return "" + suiteChars[this.value];
        }
        return "?";
    }
}
