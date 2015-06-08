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

import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.ImageIcon;

public class Card extends JPanel {
    private final int CARD_WIDTH = 79;
    private final int CARD_HEIGHT = 123;

    private Image img;
    private int index;
    public Card(int index){
        this.img = new ImageIcon(Card.class.getResource("/img/cards.png")).getImage();
        this.index = index;
        //79x123
        // 13 per row
        // + wilds + backside
/*        Dimension size = new Dimension(img.getWidth(null), img.getHeight(null));
        setPreferredSize(size);
        setMinimumSize(size);
        setMaximumSize(size);
        setSize(size);
        setLayout(null);
        */
     }
    
    public void paintComponent(Graphics g) {
        int row, column;
        if (this.index!=0){
            row = (int) (this.index-1)/13;
            column = (this.index%13)-1;
        } else {
            row = 4;
            column=0;
        }
    
        g.drawImage(img, CARD_WIDTH*column, CARD_HEIGHT*row, null);
    }

}
