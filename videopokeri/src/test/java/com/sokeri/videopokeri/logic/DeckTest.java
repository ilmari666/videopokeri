package com.sokeri.videopokeri.logic;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class DeckTest {

    @Test
    public void createAutoFilledDeck() {
        TestDeck deck = new TestDeck(true, 1);
        assertEquals("2s",  deck.getCardAtIndex(1).toString());
    }
}
