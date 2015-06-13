/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sokeri.videopokeri.gui;
import javax.swing.JComponent;

import javax.swing.JFrame;
import javax.swing.JButton;


/**
 *
 * @author Ilmari
 */
public class Hand extends JComponent {
    Card[] cards;
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
        cards = new Card[size];
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
    /**
     * remove selected cards from hand ie keep them 'locked'
     * @param indices 
     */
    public void removeCards(int[] indices){
        for (int i = 0;i<indices.length;i++){
            int idx = indices[i];
            if (cards[idx] != null){
                remove(cards[idx]);
                cards[idx]=null;
            }
        }
        repaint();
        parent.repaint();
    }

    public void dealCards(int[] cards){
         System.out.println("gui dealCards");
//        JPanel content = new JPanel();
  //      window.setContentPane(content);
        for (int i=0; i<cards.length; i++){
            if (cards[i] != -1){
                Card card = new Card(cards[i]);
                dealCard(card, i);
            }
        }
        repaint();
        parent.repaint();
    }
    
    public void dealCard(Card card, int location){
        System.out.println("... "+location);
       
        card.setLocation(location*(Card.CARD_WIDTH+CARD_MARGIN),0);
       // card.addActionListener(listener);
        add(card);
    }
}
