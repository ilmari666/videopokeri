package com.sokeri.videopokeri.math;

import com.sokeri.videopokeri.logic.Hand;
import com.sokeri.videopokeri.logic.Card;
import java.util.Arrays;
/**
 *
 * @author Ilmari
 */
public class PokerMath {
    private Win[] wins;
    public long[] betSteps;
    public boolean loaded;
    /**
     * Creates a PokerMath instance
     * @param src JSON configuration source to be mapped to a MathConfig instance
     */
    public PokerMath(String src) {
        MathLoader loader = new MathLoader();
        MathConfig config = loader.load(src);
        if (config != null) {
            this.wins = config.getWins();
            this.betSteps = config.getBetSteps();
            this.loaded = true;
        }
    }
    
    public PokerMath() {
        
    }
 
    public void setWins(Win[] wins) {
        // for developement
        this.wins = wins;
    }
    
    
    /**
     * Takes a players hand and compares it against a presorted array of wins and returns the first matching win
     * @param hand Players hand
     * @return match instance if one is found
     */
    public Result checkWins(Hand hand, long bet) {
       // Card[] cards = hand.getCardsWithoutWilds(); // get cards to be tested

        //Arrays.sort(cards); // sort them for easy matching
       // if rising +1 +2 strings would be reversed you could reverse the win check sort would also get biggest pairs first in games played with larger than five card decks. ie 22 44 55 would yield 55 and 44
        // still needs to address the ace issue in pair comparison and in straights

        Card[] cards = hand.getCards();
        for (int i = 0, len = this.wins.length; i < len; i++) {
            Match match = new Match(cards, this.wins[i]);
            if (match.isMatch) {
                return new Result(match, bet);
            }
        }
        return new Result(null, bet);
    }
}
