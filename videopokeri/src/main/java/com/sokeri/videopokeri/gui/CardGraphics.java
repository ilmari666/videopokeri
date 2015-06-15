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
    public static int cardWidth = 79;
    public static int cardHeight = 123;

    private static Image img;
    private int index;
    public boolean locked;
    public boolean lockable;
    public CardGraphics(int idx) {
        index = idx;
        if (img == null) {
            img = new ImageIcon(CardGraphics.class.getResource("/img/cards.png")).getImage();
        }
        Dimension size = new Dimension(cardWidth, cardHeight);
       
        setSize(size);
        setPreferredSize(size);
        setLayout(null);
    }

    public void toggleLock() {
        if (lockable) {
            this.locked = !locked;
            repaint();
        }
    }
    /**
     * set state to non lockable
     * @param lockable allow locking
     */
    public void setLockableState(boolean lockable) {
        this.lockable = lockable;
        this.locked = false;
        repaint();
    }
    
    @Override
    public void paintComponent(Graphics g) {
        
        int row, column, x, y;
        if (this.index != 0) {
            row = (int) (this.index - 1) / 13;
            column = ((this.index - 1) % 13); //-1
        } else {
            row = 4;
            column = 0;
        }
        x = cardWidth * column;
        y = cardHeight * row;
        
    
        g.drawImage(img, 0, 0, cardWidth, cardHeight,  x, y, x + cardWidth, y + cardHeight, null);
        if (locked) {
            g.drawImage(img, 0, 48, 79, 72, 237, 541, 316, 565, null);
        }
    }

}
