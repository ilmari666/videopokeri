/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sokeri.videopokeri.gui;
import java.awt.Insets;
import javax.swing.JComponent;
import javax.swing.JButton;
/**
 *
 * @author Ilmari
 */
public class Buttons extends JComponent {
    private EventListener listener;
    public Buttons(EventListener eventlistener){
        super();
        listener = eventlistener;
        setSize(640,400);
        setLayout(null);
        createButtons();
    }

    private void   createButtons(){
        JButton placeBet = new JButton("Jaa");
        placeBet.setLocation(0,100);
        placeBet.setSize(100,50);
        placeBet.setMargin(new Insets(0, 0, 0, 0));
        placeBet.addActionListener(listener);
        add(placeBet);
     
        JButton stepBet = new JButton("Panos 1.00mk");
        stepBet.setLocation(120,100);
        stepBet.setSize(100,50);
        stepBet.setMargin(new Insets(0, 0, 0, 0));
        stepBet.addActionListener(listener);
        add(stepBet);
        setLocation(0,200);
        
    }
 
}
