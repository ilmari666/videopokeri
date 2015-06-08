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
import java.net.URL;
import java.awt.Dimension;
import javax.swing.ImageIcon;


public class PokeriGUI  {

    /**
    * Controls the GUI
    */
    public PokeriGUI() {
        System.out.println("new pokerigui");
        

        JFrame frame = new JFrame();
        JPanel panel = new JPanel();
        frame.setSize(400,400);
        Card card = new Card(1); // should this be moved to a conf file?
        frame.getContentPane().add(card);
        
        JButton placeBet = new JButton("place_bet", loadImageIcon("/img/play.png"));
        EventListener listener = new EventListener();
        
        placeBet.addActionListener(listener);
       
        frame.pack();
        frame.setVisible(true);

        frame.getContentPane().add(placeBet);

        Dimension size = new Dimension(640, 480);
        frame.setPreferredSize(size);
        frame.setMinimumSize(size);
        frame.setMaximumSize(size);
        frame.setSize(size);
        frame.setLayout(null);
        
        // http://math.hws.edu/javanotes/source/
        // https://docs.oracle.com/javase/7/docs/api/javax/swing/JPanel.html
        // http://math.hws.edu/javanotes/source/chapter6/HighLowGUI.java
        // http://math.hws.edu/javanotes/source/
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
