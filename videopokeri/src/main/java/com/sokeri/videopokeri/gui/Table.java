/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sokeri.videopokeri.gui;
import javax.swing.JComponent;
/**
 *
 * @author Ilmari
 */
public class Table extends JComponent {
    Card[] cards;
    
    public Table(){
        super();
        setSize(640,400);
        setLayout(null);
    }
    public void deal(Card card){
        add(card);
    }
}
