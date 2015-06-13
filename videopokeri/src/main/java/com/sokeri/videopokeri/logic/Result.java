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
    /**
     * Object which holds information on players possible win on a given round
     * @param match null if no matches where found,otherwise a winning match will be given
     * @param bet amount the player placed on the game round
     */
    
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
    @Override
    public String toString(){
        return ""+(win.getName()+" "+winSum+"mk "+winningCards);
    }
    
}
