
package com.sokeri.videopokeri.money;
import com.sokeri.videopokeri.logic.Hand;

/**
 *
 * @author Ilmari
 */
public class Player {
    protected Wallet wallet;
    public Hand hand;
    public long bet; // 
    
    public Player(){
        this.wallet = new Wallet();
        this.hand = new Hand();
    }
    public void addMoney(long sum){
        this.wallet.deposit(sum);
    }
    /**
     * used to withdraw money from a players account
     * @param sum how much to bet
     * @return how much was successfully wagered
     */
    public long placeBet(long sum){
        if (this.wallet.withdraw(sum)){
            this.bet = sum;
        } else {
            this.bet = 0; // TODO is this needed?
        }
        return this.bet;
    }
}
