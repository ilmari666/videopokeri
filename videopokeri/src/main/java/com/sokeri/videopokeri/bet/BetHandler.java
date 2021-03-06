
package com.sokeri.videopokeri.bet;
import com.sokeri.videopokeri.player.Player;
import com.sokeri.videopokeri.Pokeri;

/**
 *
 * @author Ilmari

 */
public class BetHandler {
    
    private int currentBetIndex = 0;
    protected long[] steps; // @TODO move to conf
    public long amount;
    public Player player;
    Pokeri main;
    /**
     * A class handles the logic related to betting
     * @param steps a list of allowed bets that the player can surf through
     * @param player is the instance of player the handler is linked to
     */
    public BetHandler(Pokeri main, long[] steps, Player player) {
        this.main = main;
        this.steps = steps;
        this.player = player;
    }
    /**
     * 
     * @return current bet
     */
    public long getBet() {
        //@todo return 0 if the player cant afford the current bet
        return steps[currentBetIndex];
    }
    
    
    public boolean playerAffordsCurrentBet() {
        return (player.getBalance() - steps[currentBetIndex] >= 0);
    }
    public long levelOfBetAfforded() {
        long balance = player.getBalance();
        while (!playerAffordsCurrentBet() && currentBetIndex > 0) {
            currentBetIndex--;
        }
        if (playerAffordsCurrentBet()) {
            return steps[currentBetIndex];
        }
        return 0;
    }

    /**
     * find next afforded bet or loop
     * @return current bet amount, 0 if player has not enough money for any bet
     */
   
    public long step(boolean automatic) {
        if (main.state == Pokeri.States.PLACE_BET) {
            int oldIndex = currentBetIndex;
            
            if (currentBetIndex < steps.length - 1) {
                currentBetIndex++;
            } else {
                currentBetIndex = 0;
            }
            if (automatic) { // if triggered by the system
                while (currentBetIndex != 0 && !playerAffordsCurrentBet()) {
                    currentBetIndex--;
                }
            } else {
                if (!playerAffordsCurrentBet()) {
                    currentBetIndex = 0;
                }
            }
        }
        return this.steps[currentBetIndex];
    }
}
