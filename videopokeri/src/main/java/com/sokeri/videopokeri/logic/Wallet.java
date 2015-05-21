package com.sokeri.videopokeri.logic;

/**
 *
 * @author Ilmari
 */
public class Wallet {
    protected long balance;
    public Wallet(){
        this.balance = 0;
    }
    public Wallet(long balance){
        this.balance = balance;
    }
    public boolean deposit(long sum){
        this.balance+=sum;
        return true;
    }
    
    public long getBalance(){
        return this.balance;
    }
    
    public boolean withdraw(long sum){
        if (sum<=this.balance){
            this.balance-=sum;
            return true;
        }
        return false;
    }
}
