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
public class Card {
    public enum Suites {SPADE, HEART, CLUB, DIAMOND, WILD}
    private String[] valueStrings = {"Joker","Ace","Deuce","3","4","5","6","7","8","9","10", "Jack","Queen", "King"};
    
    public int value;
    public Suites suite;
    public Card (int value, Suites suite){
        this.value = value;
        this.suite = suite;
    }
    public Card (int seedValue){

        // lazy constructor that enables deck to be created in a single loop
        // eats values from 0 to 52 and creates cards accordingly
        
        if (value == 0){
            this.value = 0;
            this.suite = Suites.WILD;
        } else if (value < 53){
            value--;
            this.value = value%13;
            this.suite = Suites.values()[(int) Math.floor(value/13)];
        } else {
            throw new Error("Unable to create card #"+value);
        }
    }
    
    @Override
    public String toString (){
        if (this.value != 0){
            return (valueStrings[this.value]+" of "+this.suite.toString()+"s");
        }
        return valueStrings[this.value];
    }
}
