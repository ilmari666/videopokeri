/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sokeri.videopokeri.gui;

/**
 *
 * @author ilmari
 */

import javax.swing.JPanel;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;



public class CardGraphics extends JPanel {
    public static int CARD_WIDTH = 79;
    public static int CARD_HEIGHT = 123;

    private static Image img;
    private int index;
    public boolean locked;
    public boolean lockable;
    public CardGraphics(int idx){
        System.out.println("create card "+idx);
        index = idx;
        if (img == null){
            img = new ImageIcon(CardGraphics.class.getResource("/img/cards.png")).getImage();
        }
        Dimension size = new Dimension(CARD_WIDTH, CARD_HEIGHT);
       
        setSize(size);
        setPreferredSize(size);
        setLayout(null);
     }

    public void toggleLock (){
        if (lockable){
            this.locked = !locked;
            repaint();
        }
    }
    /**
     * set state to non lockable
     * @param lockable allow locking
     */
    public void setLockableState(boolean lockable){
        this.lockable = lockable;
        this.locked = false;
        repaint();
    }
    
    @Override
    public void paintComponent(Graphics g) {
        
        int row, column, x, y;
        if (this.index!=0){
            row = (int) (this.index-1)/13;
            column = ((this.index-1)%13); //-1
        } else {
            row = 4;
            column=0;
        }
        x = CARD_WIDTH*column;
        y = CARD_HEIGHT*row;
        
    
        g.drawImage(img, 0, 0, CARD_WIDTH, CARD_HEIGHT,  x,y, x+CARD_WIDTH, y+CARD_HEIGHT, null);
        if (locked){
            g.drawImage(img, 0, 48, 79, 72, 237, 541, 316, 565, null);
        }
    }

}
