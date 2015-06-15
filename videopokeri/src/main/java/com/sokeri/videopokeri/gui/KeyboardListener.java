package com.sokeri.videopokeri.gui;
import javax.swing.JPanel;

import javax.swing.JFrame;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
/**
 *
 * @author Ilmari
 */
public class KeyboardListener extends KeyAdapter {
    private Hand hand;
    public KeyboardListener(Hand hand) {
        this.hand = hand;
    }
    @Override
    public void keyPressed(KeyEvent event) {
        int keyCode = event.getKeyChar();
        for (int i = 1; i <= hand.size; i++) {
            if (keyCode == ("" + i).charAt(0)) {
                hand.toggleLock(i);
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent event) {
    }
}
    

