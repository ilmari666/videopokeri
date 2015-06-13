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
import javax.swing.JLabel;
import javax.swing.JComponent;
import java.net.URL;
import java.awt.Dimension;
import javax.swing.ImageIcon;
import java.awt.Insets;
import java.awt.event.WindowEvent;
import java.awt.event.WindowAdapter;






import com.sokeri.videopokeri.Pokeri;
import java.text.DecimalFormat;


public class PokeriGUI  {

    /**
    * Controls the GUI
    */
    JFrame window;
    JPanel cards;
    JLabel money;
    public Hand hand;
    Buttons buttons;
    EventListener listener;
    public PokeriGUI(Pokeri pokeri, int handSize) {
        this.listener = new EventListener(pokeri, window);
        window = new JFrame("Videopokeri");
        window.setLayout(null);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setLocation(0,0);
        window.pack();
        window.setResizable(false);
        window.setVisible(true);
        window.setSize(640,400);
        //this.buttons = createButtons();
        this.buttons = new Buttons(listener);
        money = new JLabel();
        money.setSize(100,100);
        money.setLocation(300,275);
 
        hand = new Hand(handSize, window, listener);
        /*
        Card card = new Card(0);
        card.setLocation(0,0);
        table.add(card);
        card = new Card(1);
        card.setLocation(200,0);
        table.add(card);
       */

        
        window.getContentPane().add(buttons);
        window.getContentPane().add(hand);
        window.getContentPane().add(money);
        window.setFocusable(true);
        window.setFocusTraversalKeysEnabled(false);
        window.addKeyListener(new KeyboardListener(hand));
        window.addMouseListener(new CardListener(hand));

        window.repaint();
    }
    
    public void updateMoney(long balance){
        DecimalFormat df = new DecimalFormat(".00");
        System.out.println(df.format(balance/100));
        System.out.println(money);
        money.setText("Saldo: "+df.format(balance/100)+"mk");
    }

    /*
    public Buttons createButtons(){
        Buttons btns = new Buttons();
        JButton placeBet = new JButton("play");
        placeBet.setLocation(0,100);
        placeBet.setSize(100,50);
        placeBet.setMargin(new Insets(0, 0, 0, 0));
        placeBet.addActionListener(listener);
        btns.add(placeBet);
     
        JButton stepBet = new JButton("step_bet");
        stepBet.setLocation(120,100);
        stepBet.setSize(100,50);
        stepBet.setMargin(new Insets(0, 0, 0, 0));
        stepBet.addActionListener(listener);
        btns.add(stepBet);
        btns.setLocation(0,200);
        
        return btns;
    }
 */
        
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
