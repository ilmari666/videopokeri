
package com.sokeri.videopokeri.money;

/**
 *
 * @author Ilmari
 */
public class BetHandler {
    
    int currentBetIndex = 0;
    protected long[] steps; // @TODO move to conf
    public long amount;
    
    public BetHandler(long[] steps){
 
        this.steps = steps;
    }
    
    public long getBet(){
        return steps[currentBetIndex];
    }
    
    public boolean canAfford(Player player, long sum){
        
        return true;
    }
    
    public long nextBet(){
        // @todo: loop until next affordable bet
        if (currentBetIndex<steps.length-1){
            currentBetIndex++;
        } else {
            currentBetIndex = 0;
        }
        
        return this.steps[currentBetIndex];
    }
}
