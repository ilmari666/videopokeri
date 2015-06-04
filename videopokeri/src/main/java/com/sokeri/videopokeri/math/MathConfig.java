/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sokeri.videopokeri.math;

/**
 *
 * @author ilmari
 */
/**
 * A container class filled from a JSON configuration file
 */
public class MathConfig {
    private RawWin[] wins;
    private long[] betSteps;
    public Win[] getWins(){
        // create and return actual win objects with matching patterns etc
        Win[] ret = new Win[this.wins.length];
        for (int i=0;i<this.wins.length;i++){
            ret[i] = new Win(this.wins[i]);
        }
        return ret;
    }
    public long[] getBetSteps(){
        return this.betSteps;
    }
}
