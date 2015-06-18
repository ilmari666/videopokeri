package com.sokeri.videopokeri;

import com.sokeri.videopokeri.math.PokerMath;
import com.sokeri.videopokeri.math.MathLoader;
import com.sokeri.videopokeri.player.Wallet;
import com.sokeri.videopokeri.logic.Deck;
import com.sokeri.videopokeri.player.Player;
import com.sokeri.videopokeri.bet.BetHandler;
import com.sokeri.videopokeri.math.Result;
import com.sokeri.videopokeri.gui.PokeriGUI;
import com.sokeri.videopokeri.logic.Card;
/**
 *
 * @author Ilmari
 */
/**
 * The main instance of the game which currently controls the flow.
 */
public class Pokeri {
  
    private final Deck deck;
    public enum States { DEPOSIT, PLACE_BET, PLAYER_SELECT, DOUBLE };
    public States state;
    private Player player;
    private BetHandler betHandler;
    private PokerMath math;
    public PokeriGUI gui;
    
    
    public Pokeri() {
        this.math = new PokerMath("/math.json");
        deck = new Deck(true, 1); // create a full deck with one joker
        player = new Player();
        this.betHandler = new BetHandler(this, math.betSteps, player);
        this.gui = new PokeriGUI(this, player.hand.getSize());
        changeState(States.DEPOSIT);
    }
    /**
    * method tries to place a bet to start the game round if the state allows
    * when successful shuffles the deck and deals a handful of cards to the player before 
    * continuing to the next state
    * @return true if successful, false if fails
    */
    public boolean startRound() {
        // place bet and deal the first round of cards
        if (state == States.PLACE_BET && player.placeBet(betHandler.getBet()) != 0) {
            player.hand.discardAll();
            gui.hand.removeCards();
            deck.shuffle();
            deck.dealCards(player.hand);
            gui.hand.dealCards(player.hand.getCardValues());
            gui.hand.setLockableState(true);
            gui.updateMoney(player.getBalance());
            changeState(States.PLAYER_SELECT);
            return true;
        }
     
        return false;
    }
    /**
     * method deals a new set of cards to the player but keeps the cards the player has elected to keep
     * generates the round result and  gives it to the gui later before finally switching state
     */
    public void lockAndDeal() {
     
        if (state == States.PLAYER_SELECT) {
            int[] keptIndices = gui.hand.getLocked();
            player.hand.keep(keptIndices);
            Card[] dealt = deck.dealCards(player.hand);
            gui.hand.removeNonLockedCards();

            gui.hand.dealCards(dealt);
            gui.hand.setLockableState(false);
            Result result = this.math.checkWins(player.hand, betHandler.getBet());
            if (result.win != null) {
                player.addMoney(result.winSum);
                gui.updateMoney(player.getBalance());
                gui.hand.highlight(result.winningCards);
                
            }
            String winMessage = result.win != null ? "\"" + result.win.getName() + "\" " : "";
            if (betHandler.playerAffordsCurrentBet()) {
                changeState(States.PLACE_BET, winMessage);
            } else if (betHandler.levelOfBetAfforded() != 0) {
                // if a player can afford a bet but not the current one, force bet down
                gui.updateBet(betHandler.step(true));
                changeState(States.PLACE_BET, winMessage);
            } else {
                // tell player to deposit
                gui.updateBet(betHandler.step(true));
                changeState(States.DEPOSIT, winMessage);
            }
        }
    }
    
    public States getState(){
        return this.state;
    }
    public Player getPlayer() {
        // for development time purposes
        return this.player;
    }
    public BetHandler getBetHandler() {
        // for developement time use
        return this.betHandler;
    }
    public void debugHand() {
        // for developement time purposes
        Card [] playerCards = player.hand.getCards();
        for (int i = 0; i < playerCards.length; i++) {
            System.out.println(i + " " + playerCards[i]);
        }
    }
    public void deposit(long sum) {
        player.addMoney(sum);
        if (state == States.DEPOSIT) {
            changeState(States.PLACE_BET);
        }
        gui.updateMoney(player.getBalance());
    }
    /**
     * User triggers round continuation by pressing 'Jaa'-button.
     * Depending on the state, either a new round will start, a second round of cards will be dealt, or nothing happens (States.DEPOSIT)
     *
     */
    public void continueRound() {
        if (state == States.PLACE_BET) {
            startRound();
        } else if (state == States.PLAYER_SELECT) {
            lockAndDeal();
        }
    }
    public void changeState(States newState) {
        changeState(newState, "");
    }
    /**
     * Changes the state and informs the GUI to update it's informational message accordingly.
     * @param newState new state
     * @param prefixMessage prefix a state message with another message.
     */
    public void changeState(States newState, String prefixMessage) {
        
        switch (newState) {
            case PLACE_BET:
                gui.updateInfo(prefixMessage + "Valitse panostaso ja aloita kierros.");
                break;
            case PLAYER_SELECT:
                gui.updateInfo(prefixMessage + "Lukitse haluamasi kortit ja jaa kierros loppuun");
                break;
            case DEPOSIT:
                gui.updateInfo(prefixMessage + "Talleta rahaa pelataksesi.");
                break;
            default:
                break;
        }
        state = newState;
                
    }
        

    public static void main(String[] args) {
        Pokeri poker = new Pokeri();
    }
}
