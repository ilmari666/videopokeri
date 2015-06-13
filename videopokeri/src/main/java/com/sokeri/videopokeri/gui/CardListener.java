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
          int result = hand.testClick(e.getX(), e.getY());
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
    
}
