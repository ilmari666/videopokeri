/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sokeri.videopokeri.math;

/**
 *
 * @author Ilmari
 */
public class Win {
    private String name;
    private WinPattern pattern;
    private long multiplier;
    
    public Win(RawWin config){
        this.name = config.name;
        this.multiplier = config.multiplier;
        this.pattern = new WinPattern(config.pattern);
    }
    public WinPattern getPattern(){
        return this.pattern;
    }
}
