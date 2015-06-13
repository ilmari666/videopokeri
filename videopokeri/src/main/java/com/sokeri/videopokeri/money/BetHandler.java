
package com.sokeri.videopokeri.money;
import com.sokeri.videopokeri.Pokeri;

/**
 *
 * @author Ilmari

 */
public class BetHandler {
    
    int currentBetIndex = 0;
    protected long[] steps; // @TODO move to conf
    public long amount;
    public Player player;
    Pokeri main;
    /**
     * A class handles the logic related to betting
     * @param steps a list of allowed bets that the player can surf through
     */
    public BetHandler(Pokeri main, long[] steps, Player player){
        this.main = main;
        this.steps = steps;
        this.player = player;
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
    public long step(){
        if (main.state == Pokeri.States.PLACE_BET){
            if (currentBetIndex<steps.length-1){
                currentBetIndex++;
            } else {
                currentBetIndex = 0;
            }
            while (currentBetIndex != 0 && !player.canAfford(steps[currentBetIndex])){
                currentBetIndex--;
            }
        }
        return this.steps[currentBetIndex];
    }
}
