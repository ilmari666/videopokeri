/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sokeri.videopokeri.gui;
import java.awt.Insets;
import java.text.DecimalFormat;
import javax.swing.JComponent;
import javax.swing.JButton;
/**
 *
 * @author Ilmari
 */
public class Buttons extends JComponent {
    private EventListener listener;
    private JButton stepBet;
    public Buttons(){
        super();
    //    listener = eventlistener;
        setSize(640,400);
        setLayout(null);
       
    }

    public void setBet(long sum){
        DecimalFormat df = new DecimalFormat(".00");
        stepBet.setText("Panos "+df.format(sum/100)+"mk");
        
    }
    
    public void createButtons(EventListener eventListener){
        listener = eventListener;
        JButton placeBet = new JButton("Jaa");
        placeBet.setLocation(0,100);
        placeBet.setSize(100,50);
        placeBet.setMargin(new Insets(0, 0, 0, 0));
        placeBet.addActionListener(listener);
        add(placeBet);
     
        stepBet = new JButton("Panos 1.00mk");
        stepBet.setLocation(120,100);
        stepBet.setSize(100,50);
        stepBet.setMargin(new Insets(0, 0, 0, 0));
        stepBet.addActionListener(listener);
        add(stepBet);
           
        JButton deposit = new JButton("Talleta 5.00mk");
        deposit.setLocation(240,100);
        deposit.setSize(100,50);
        deposit.setMargin(new Insets(0, 0, 0, 0));
        deposit.addActionListener(listener);
        add(deposit);
        setLocation(0,200);
        
    }
 
}
