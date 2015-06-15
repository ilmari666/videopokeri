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
    JLabel info;
    public Hand hand;
    Buttons buttons;
    EventListener listener;
    public PokeriGUI(Pokeri pokeri, int handSize) {
        buildGUI(pokeri, handSize);
    }

    public void buildGUI(Pokeri pokeri, int handSize){
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
        money.setSize(200,100);
        money.setLocation(300,275);

        info = new JLabel();
        info.setSize(400,50);
        info.setLocation(0,0);
        info.setText("Aloita kierros");
        
        hand = new Hand(handSize, window, listener);
        window.getContentPane().add(buttons);
        window.getContentPane().add(hand);
        window.getContentPane().add(money);
        window.getContentPane().add(info);
        window.setFocusable(true);
        window.setFocusTraversalKeysEnabled(false);
        window.addKeyListener(new KeyboardListener(hand));
        window.addMouseListener(new CardListener(hand));

        window.repaint();

    }
    
    public void updateMoney(long balance){
        DecimalFormat df = new DecimalFormat(".00");
        money.setText("Saldo: "+df.format(balance/100)+"mk");
    }

    public void updateInfo(String text){
        info.setText(text);
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
