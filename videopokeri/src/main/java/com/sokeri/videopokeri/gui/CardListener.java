/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sokeri.videopokeri.gui;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
/**
 *
 * @author Ilmari
 */
public class CardListener implements MouseListener {
    private Hand hand;
    public CardListener(Hand hand){
        this.hand = hand;
    }

    @Override
      public void mousePressed(MouseEvent e) {
          
          
          
          int result = testClick(e.getX(), e.getY());
          if (result != -1){
              hand.toggleLock(result);
          }
    }
     
    @Override
    public void mouseReleased(MouseEvent e) {
    }
     
    @Override
    public void mouseEntered(MouseEvent e) {
    }
     
    public void mouseExited(MouseEvent e) {
    }
     
    @Override
    public void mouseClicked(MouseEvent e) {
    }
    /**
     * Test if a card was clicked by a simple bounding box test.
     * @param x x-coordinate
     * @param y y-coordinate
     * @return -1 if no cards were matched, otherwise the cards index in hand
     */
    public int testClick(int x,int y){
        CardGraphics [] cards = hand.cards;
        for (int i = 0; i < cards.length; i++){
            CardGraphics card = cards[i];
            if (card != null){
                int cardX = card.getX();
                int cardY = card.getY();

                if (x>=cardX && x<cardX+CardGraphics.CARD_WIDTH && y>=cardY && cardY<cardY+CardGraphics.CARD_HEIGHT){
                   return i;
                }
            }
        }
        return -1;
    }
   
}
