/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sokeri.videopokeri.gui;
import com.sokeri.videopokeri.Pokeri;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author makktonnikala
 */
public class EventListener implements ActionListener{
    Pokeri mainLogic;
    public EventListener(Pokeri main){
        mainLogic = main;
    }
    public void actionPerformed(ActionEvent evt) {
        String command = evt.getActionCommand();
        if (command.equals("place_bet")){
            mainLogic.startRound();
        }
        System.out.println(command);
    }
}
