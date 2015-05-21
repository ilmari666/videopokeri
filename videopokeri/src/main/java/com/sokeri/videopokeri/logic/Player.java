
package com.sokeri.videopokeri.logic;

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
