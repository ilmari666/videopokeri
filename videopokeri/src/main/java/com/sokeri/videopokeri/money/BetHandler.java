
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
    

    /**
     * find next afforded bet or loop
     * @return current bet amount, 0 if player has not enough money for any bet
     * @param player the player is revealed as a parameter to check if he can afford the bet
     */
    public long step(Player player){
        // @todo: loop until next affordable bet, or the lowest bet when player cant afford any
        if (currentBetIndex<steps.length-1){
            currentBetIndex++;
        } else {
            currentBetIndex = 0;
        }
        while (currentBetIndex != 0 && !player.canAfford(steps[currentBetIndex])){
            currentBetIndex--;
        }
        return this.steps[currentBetIndex];
    }
}
