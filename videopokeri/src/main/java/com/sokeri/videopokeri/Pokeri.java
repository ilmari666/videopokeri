/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sokeri.videopokeri;

import com.sokeri.videopokeri.math.PokerMath;
import com.sokeri.videopokeri.math.MathLoader;
import com.sokeri.videopokeri.logic.Wallet;
import com.sokeri.videopokeri.logic.Deck;
import com.sokeri.videopokeri.logic.Player;
/**
 *
 * @author Ilmari
 */
public class Pokeri {
    protected Deck deck;
    public enum States {DEPOSIT, START_ROUND, PLAYER_SELECT, DOUBLE};
    
    public Pokeri(){
        PokerMath pokerMath = new PokerMath(new MathLoader("conf/math.json"));
        deck = new Deck(true, 1); // create a full deck with one joker
    }
    
    public static void main(String[] args) {
        Pokeri poker = new Pokeri();
        Player player = new Player();
        player.addMoney(20000);
    }
}
