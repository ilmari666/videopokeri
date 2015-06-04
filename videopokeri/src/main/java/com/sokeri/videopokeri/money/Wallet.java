package com.sokeri.videopokeri.money;

/**
 *
 * @author Ilmari
 * 
 * A logical representation of a players wallet.
 */
public class Wallet {
    protected long balance;
    public Wallet(){
        this.balance = 0;
    }
    public Wallet(long balance){
        this.balance = balance;
    }
    /**
     * Deposit money to the wallet
     * @param sum amount
     */
    public void deposit(long sum){
        this.balance+=sum;
    }
    
    public long getBalance(){
        return this.balance;
    }
    /**
     * Withdraw money from the Wallet
     * @param sum amount
     * @return true if sufficient funds, else false
     */
    public boolean withdraw(long sum){
        if (sum<=this.balance){
            this.balance-=sum;
            return true;
        }
        return false;
    }
}
