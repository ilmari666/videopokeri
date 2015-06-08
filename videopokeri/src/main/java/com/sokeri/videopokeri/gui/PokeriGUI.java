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
import java.awt.event.WindowEvent;
import java.awt.event.WindowAdapter;


public class PokeriGUI  {

    /**
    * Controls the GUI
    */
    public PokeriGUI() {
        System.out.println("new pokerigui");
        

        JFrame frame = new JFrame();
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent windowEvent){
                System.exit(0);
            }        
        });           
        
        JPanel panel = new JPanel();
        frame.setSize(400,400);
        Card card = new Card(5); // should this be moved to a conf file?
        frame.getContentPane().add(card);
        
        JButton placeBet = new JButton("place_bet", loadImageIcon("/img/play.png"));
        EventListener listener = new EventListener();
        

        placeBet.addActionListener(listener);
       

        frame.getContentPane().add(placeBet);

        Dimension size = new Dimension(640, 480);
        frame.setPreferredSize(size);
        frame.setMinimumSize(size);
        frame.setMaximumSize(size);
        frame.setSize(size);
        frame.setLayout(null);
        frame.pack();
        frame.setVisible(true);

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
