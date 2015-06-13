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
    }
    @Override
    public void actionPerformed(ActionEvent evt) {
        String command = evt.getActionCommand();
        if (command.equals("play")){
            mainLogic.continueRound();
        }
        System.out.println(command);
    //    mainWindow.requestFocusInWindow(true);
    }
}
