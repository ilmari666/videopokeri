
package com.sokeri.videopokeri.player;
import com.sokeri.videopokeri.logic.Hand;
import com.sokeri.videopokeri.money.Wallet;

/**
 *
 * @author Ilmari
 */
public class Player {
    protected Wallet wallet;
    public Hand hand;
    public long bet; // 
    
    public Player() {
        wallet = new Wallet();
        hand = new Hand();
    }
    
    public void addMoney(long sum) {
        this.wallet.deposit(sum);
    }
    public long getBalance() {
        return wallet.getBalance();
    }
    /**
     * used to withdraw money from a players account
     * @param sum how much to bet
     * @return how much was successfully wagered
     */
    public long placeBet(long sum) {
        if (this.wallet.withdraw(sum)) {
            this.bet = sum;
        } else {
            this.bet = 0; // TODO is this needed?
        }
        return this.bet;
    }
}
