/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sokeri.videopokeri.gui;
/**
 *
 * @author Ilmari
 */
/*
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
*/

import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JComponent;
import java.net.URL;
import java.awt.Dimension;
import javax.swing.ImageIcon;
import java.awt.Insets;
import java.awt.event.WindowEvent;
import java.awt.event.WindowAdapter;
import com.sokeri.videopokeri.Pokeri;


public class PokeriGUI  {

    /**
    * Controls the GUI
    */
    JFrame window;
    JPanel cards;
    public PokeriGUI(Pokeri pokeri) {
        EventListener listener = new EventListener(pokeri);
        window = new JFrame("Videopokeri");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

 
        Table table = new Table();
        Card card = new Card(0);
        card.setLocation(0,0);
        table.add(card);
        card = new Card(1);
        card.setLocation(200,0);
        table.add(card);
       
        Buttons buttons = new Buttons();
        JButton placeBet = new JButton("place_bet");
        placeBet.setLocation(200,100);
        placeBet.setSize(100,50);
        placeBet.setMargin(new Insets(0, 0, 0, 0));
        placeBet.addActionListener(listener);
        buttons.add(placeBet);
        buttons.setLocation(0,0);
        
        window.getContentPane().add(buttons);
        window.getContentPane().add(table);
        
        window.setLocation(0,0);
        window.pack();
        window.setResizable(false);
        window.setVisible(true);
        window.setSize(640,400);
        window.setLayout(null);




    }
    
    public void cleanPanel(JPanel panel){
        panel.setLocation(0,0);
        panel.setVisible(true);
        panel.setLayout(null);
    }
    
    public void dealCards(int[] cards){
        System.out.println("dealCards");
        JPanel content = new JPanel();
        window.setContentPane(content);
        for (int i=0; i<cards.length; i++){
            if (cards[i] != -1){
                Card card = new Card(cards[i]);
                card.setLocation(Card.CARD_WIDTH*i,100);
                window.getContentPane().add(card);
            }
        }
        window.setLayout(null);
    }

    private ImageIcon loadImageIcon(String src){

        URL imgURL = PokeriGUI.class.getResource(src);
        if (imgURL != null) {
            return new ImageIcon(imgURL);
        } else {            
            System.err.println("Couldn't find file: " + src);
            return null;
        }
     }
}
