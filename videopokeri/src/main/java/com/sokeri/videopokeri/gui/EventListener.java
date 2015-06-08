/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sokeri.videopokeri.gui;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author makktonnikala
 */
public class EventListener implements ActionListener{
    public EventListener(){
        
    }
    public void actionPerformed(ActionEvent evt) {
        String command = evt.getActionCommand();
        System.out.println(command);
    }
}
