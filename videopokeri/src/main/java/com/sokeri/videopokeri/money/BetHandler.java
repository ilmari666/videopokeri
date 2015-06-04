
package com.sokeri.videopokeri.money;

/**
 *
 * @author Ilmari

 */
public class BetHandler {
    
    int currentBetIndex = 0;
    protected long[] steps; // @TODO move to conf
    public long amount;
    /**
     * A class handles the logic related to betting
     * @param steps a list of allowed bets that the player can surf through
     */
    public BetHandler(long[] steps){
 
        this.steps = steps;
    }
    /**
     * 
     * @return current bet
     */
    public long getBet(){
        //@todo return 0 if the player cant afford the current bet
        return steps[currentBetIndex];
    }
    
    public boolean canAfford(Player player, long sum){
        
        return true;
    }
    /**
     * find next afforded bet or loop
     * @return current bet amount, 0 if player has not enough money for any bet
     */
    public long nextBet(){
        // @todo: loop until next affordable bet, return 0 if player can not afford a bet
        if (currentBetIndex<steps.length-1){
            currentBetIndex++;
        } else {
            currentBetIndex = 0;
        }
        
        return this.steps[currentBetIndex];
    }
}
