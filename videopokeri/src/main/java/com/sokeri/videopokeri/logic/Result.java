/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sokeri.videopokeri.logic;
import com.sokeri.videopokeri.math.Win;
import com.sokeri.videopokeri.math.Match;
import com.sokeri.videopokeri.money.BetHandler;

/**
 *
 * @author Ilmari
 */
public class Result {
    protected long winSum = 0;
    public boolean[] winningCards;
    public Win win;
    
    public Result (Match match, long bet){
        if (match != null){
            this.win = match.win;
            this.winSum = match.win.getMultiplier()*bet;
            this.winningCards = match.used; // TODO remember to add wildcards before this
        }
    }
    public long getWinSum(){
        return this.winSum;
    }
    
}
