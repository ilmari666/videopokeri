/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sokeri.videopokeri;

import com.sokeri.videopokeri.math.PokerMath;
import com.sokeri.videopokeri.math.MathLoader;
import com.sokeri.videopokeri.logic.Round;
import com.sokeri.videopokeri.logic.Money;
/**
 *
 * @author Ilmari
 */
public class Videopokeri {
    public Videopokeri(){
        pokerMath = new PokerMath(new MathLoader("conf/math.json"));
        playerMoney = new Money(0);
    }
    
    
    public boolean deposit(long money){
            
        return true;
    }
    
    public static void main(String[] args) {
          VideoPokeri poker = new VideoPokeri();
          poker.deposit(20000);
    }
}
