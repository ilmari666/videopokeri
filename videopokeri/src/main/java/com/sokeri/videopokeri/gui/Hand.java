/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sokeri.videopokeri.gui;
import javax.swing.JComponent;
import com.sokeri.videopokeri.logic.Card;

import javax.swing.JFrame;
import javax.swing.JButton;


/**
 *
 * @author Ilmari
 */
public class Hand extends JComponent {
    CardGraphics[] cards;
    public int size;
    EventListener listener;
    boolean[] lockedCards;
    private int CARD_MARGIN = 20; // card margin when dealt on the table.
    private JFrame parent;
    
    public Hand(int size, JFrame parent, EventListener listener){
        super();
        this.size = size;
        this.parent = parent;
        this.listener = listener;
        cards = new CardGraphics[size];
        lockedCards = new boolean[size];
        setSize(640,400);
        setLayout(null);
    }

    
    /**
     * remove all cards from the hand
     */
    
    public void removeCards(){
        for (int i = 0;i<cards.length;i++){
            if (cards[i] != null){
                remove(cards[i]);
                cards[i]=null;
            }
        }
        repaint();
        parent.repaint();
    }
    
    public void toggleLock(int index){
        if (cards[index] != null){
            cards[index].toggleLock();
        }
    }
    
    public void setLockableState(boolean lockable){
        for (int i = 0; i < cards.length; i++){
            cards[i].setLockableState(lockable);
        }
        repaint();
        parent.repaint();
        
    }
    /**
     * remove selected cards from hand ie keep them 'locked'
     * @param indices 
     */
    public void removeCards(int[] indices){
        for (int i = 0;i<indices.length;i++){
            int idx = indices[i];
            removeCard(idx);
        }
        repaint();
        parent.repaint();
    }
    public void removeCard(int idx){
        if (cards[idx] != null){
            remove(cards[idx]);
            cards[idx]=null;
        }
    }
    /**
     * Highlights winning cards
     * @param hits boolean[] cards used in win
     */
    public void highlight(boolean[] hits){
        for (int i = 0; i < hits.length; i++){
            if (hits[i]){
                cards[i].setLocation(cards[i].getX(),0);
            }
        }
    }
    
    public void removeNonLockedCards(){
        for (int i = 0;i<cards.length;i++){
            if (cards[i] != null){
                if (cards[i].locked == false){
                    remove(cards[i]);
                    cards[i]=null;
                }
            }
        }
        repaint();
        parent.repaint();
    }

    public int countLocked(){
        int count = 0;
        for (CardGraphics card : cards) {
            if (card.locked) {
                count++;
            }
        }
        return count;
    }
    public int[] getLocked(){
        int [] locked = new int[countLocked()];
        int cursor = 0;
        for (int i = 0; i < cards.length;i++){
            if (cards[i].locked){
                locked[cursor] = i;
                cursor++;
            }
        }
        return locked;
    }
    
    /**
     * Turn logical cards in to visual ones and deal them
     * @param dealtCards Array of cards to be dealt
     */
    public void dealCards(Card[] dealtCards){
        for (Card dealtCard : dealtCards) {
            dealCard(new CardGraphics(dealtCard.getValueAsInt()));
        }
    }
    /**
     * Turn logical cards in to visual ones and deal them
     * @param dealtCards Array of card values to be dealt
     */
    public void dealCards(int[] dealtCards){
        for (int i=0; i<dealtCards.length; i++){
            if (dealtCards[i] != -1){
                CardGraphics card = new CardGraphics(dealtCards[i]);
                dealCard(card, i);
            }
        }
        repaint();
        parent.repaint();
    }
    /**
     * Find an empty slot and fit it with a card
     * @param card 
     */
    public void dealCard(CardGraphics card){
        for (int i=0;i<this.cards.length;i++){
            if (this.cards[i]==null){
                dealCard(card,i);
                break;
            }
        }
    }
    /**
     * Deals a new card in to a predefined slot (taken or not)
     * @param card
     * @param location slot #
     */
    public void dealCard(CardGraphics card, int location){
        this.cards[location] = card;
        card.setLocation(location*(CardGraphics.CARD_WIDTH+CARD_MARGIN),20);
        add(card);
    }
}
