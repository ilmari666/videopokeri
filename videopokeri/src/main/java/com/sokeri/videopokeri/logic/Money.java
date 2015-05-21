/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sokeri.videopokeri.logic;

/**
 *
 * @author Ilmari
 */
public class Money {
    protected long balance;
    public Money(){
        this.balance = 0;
    }
    public Money(long balance){
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
