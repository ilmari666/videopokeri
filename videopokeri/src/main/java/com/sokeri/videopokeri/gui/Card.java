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



public class Card extends JPanel {
    public static int CARD_WIDTH = 79;
    public static int CARD_HEIGHT = 123;

    private static Image img;
    private int index;
    public Card(int idx){
        index = idx;
        if (img == null){
            img = new ImageIcon(Card.class.getResource("/img/cards.png")).getImage();
        }
        Dimension size = new Dimension(CARD_WIDTH, CARD_HEIGHT);

        setSize(size);
        setPreferredSize(size);
        setLayout(null);
     }
    
    @Override
    public void paintComponent(Graphics g) {
        
        int row, column, x, y;
        if (this.index!=0){
            row = (int) (this.index-1)/13;
            column = (this.index%13)-1;
        } else {
            row = 4;
            column=0;
        }
        x = CARD_WIDTH*column;
        y = CARD_HEIGHT*row;
    
        g.drawImage(img, 0, 0, CARD_WIDTH, CARD_HEIGHT,  x,y, x+CARD_WIDTH, y+CARD_HEIGHT, null);
    }

}
