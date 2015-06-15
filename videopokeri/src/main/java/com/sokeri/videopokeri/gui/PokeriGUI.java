
package com.sokeri.videopokeri.gui;
/**
 *
 * @author Ilmari
 */


import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.net.URL;
import javax.swing.ImageIcon;
import com.sokeri.videopokeri.Pokeri;
import java.text.DecimalFormat;


public class PokeriGUI  {

    /**
    * Controls the GUI
    */
    JFrame window;
    JPanel cards;
    JLabel money;
    JLabel info;
    public Hand hand;
    Buttons buttons;
    EventListener listener;
    public PokeriGUI(Pokeri pokeri, int handSize) {
        buildGUI(pokeri, handSize);
    }

    public void buildGUI(Pokeri pokeri, int handSize) {
        window = new JFrame("Videopokeri");
        window.setLayout(null);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setLocation(0, 0);
        window.pack();
        window.setResizable(false);
        window.setVisible(true);
        window.setSize(640, 400);
        //this.buttons = createButtons();
        this.buttons = new Buttons();
        this.listener = new EventListener(pokeri, window, this.buttons);
        this.buttons.createButtons(this.listener);

        money = new JLabel();
        money.setSize(200, 100);
        money.setLocation(400, 275);

        info = new JLabel();
        info.setSize(400, 50);
        info.setLocation(0, 0);

        
        hand = new Hand(handSize, window, listener);
        window.getContentPane().add(buttons);
        window.getContentPane().add(hand);
        window.getContentPane().add(money);
        window.getContentPane().add(info);
        window.setFocusable(true);
        window.setFocusTraversalKeysEnabled(false);
        window.addKeyListener(new KeyboardListener(hand));
        window.addMouseListener(new CardListener(hand));

        window.repaint();

    }
    
    public void updateMoney(long balance) {
        DecimalFormat df = new DecimalFormat(".00");
        money.setText("Saldo: " + df.format(balance / 100) + "mk");
    }

    public void updateInfo(String text) {
        this.info.setText(text);
    }
    public void updateBet(long sum) {
        this.buttons.setBet(sum);
    }
        
    private ImageIcon loadImageIcon(String src) {

        URL imgURL = PokeriGUI.class.getResource(src);
        if (imgURL != null) {
            return new ImageIcon(imgURL);
        } else {            
            System.err.println("Couldn't find file: " + src);
            return null;
        }
    }
}
