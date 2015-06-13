/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sokeri.videopokeri.gui;
import com.sokeri.videopokeri.Pokeri;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JButton;
import java.text.DecimalFormat;

/**
 *
 * @author ilmari
 */
public class EventListener implements ActionListener{
    Pokeri mainLogic;
    JFrame mainWindow;
    public EventListener(Pokeri main, JFrame mainWindow){
        mainLogic = main;
        this.mainWindow = mainWindow;
        System.out.println("EventListener");
    }
    @Override
    public void actionPerformed(ActionEvent evt) {
        String command = evt.getActionCommand();
        if (command.equals("Jaa")){
            mainLogic.continueRound();
        } else if (command.indexOf("Panos")!=-1){
            JButton source = (JButton)evt.getSource();
            DecimalFormat df = new DecimalFormat(".00");
            source.setText("Panos "+df.format(mainLogic.getBetHandler().step()/100)+"mk");
        } else {
             System.out.println(command);
        }
    }


}
