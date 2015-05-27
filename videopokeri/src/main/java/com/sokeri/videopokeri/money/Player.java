
package com.sokeri.videopokeri.money;

/**
 *
 * @author Ilmari
 */
public class Player {
    protected Wallet wallet;
    public Player(){
        this.wallet = new Wallet();
    }
    public boolean addMoney(long sum){
        return this.wallet.deposit(sum);
    }
    
}
