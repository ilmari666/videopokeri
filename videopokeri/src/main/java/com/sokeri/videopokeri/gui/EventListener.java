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
public class EventListener implements ActionListener {
    Pokeri mainLogic;
    JFrame mainWindow;
    Buttons buttons;
    public EventListener(Pokeri main, JFrame mainWindow, Buttons buttons) {
        mainLogic = main;
        this.mainWindow = mainWindow;
        this.buttons = buttons;
    }
    @Override
    public void actionPerformed(ActionEvent evt) {
        String command = evt.getActionCommand();
        if (command.equals("Jaa")) {
            mainLogic.continueRound();
        } else if (command.indexOf("Panos") != -1) {
            buttons.setBet(mainLogic.getBetHandler().step(false));
        } else if (command.equals("Talleta 5.00mk")) {
            mainLogic.deposit(500);
        } else {
            System.out.println(command);
        }
              
    }


}
