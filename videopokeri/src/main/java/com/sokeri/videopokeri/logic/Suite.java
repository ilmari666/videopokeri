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
public class Suite {
    public static int SPADE = 0;
    public static int HEART = 1;
    public static int CLUB = 2;
    public static int DIAMOND = 3;
    public static int WILD = 4;
    
    public static char[] suiteChars = {'s','h','c','d','*'};
    private int value;
    
    public Suite (){
        this.value = -1; // undefined
    }
    public Suite(int suite){
        this.value = suite;
    }
    public int getValue(){
        return this.value;
    }
    @Override
    public String toString (){
        if (this.value>=0){
            return ""+suiteChars[this.value];
        }
        return "?";
    }
}
