/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sokeri.videopokeri.math;

/**
 *
 * @author makktonnikala
 */
// win types
// straights
// flushes
// straight flushes
// pair(s)
// high cards

public class Win {
    private String name;
    private String pattern;
    private long multiplier;
    private boolean checkflush;
    
    public Win(){

    }
    public String getPattern(){
        return this.pattern;
    }
}
