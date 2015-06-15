package com.sokeri.videopokeri.math;
import java.util.Arrays;
import com.sokeri.videopokeri.logic.Card;
/**
 *
 * @author Ilmari
 * A piece of rule information used in matching a pattern
 */
public class Rule {
    public boolean testSuite;
    public boolean testX;
    public boolean testY;
    
    public int offset = 0;
    public int testSpecific = -1;
    
   
    public Rule(String rule) {
        this.setRule(rule);
    }
    /**
     * Set and parse a set of rules to be matched against in a Match instance
     * @param rule String defining a rule (a piece of a WinPattern) loaded through MathLoader
     */
    public void setRule(String rule) {
        String[] tmp = rule.split("");
        // we do an ugly chew to create beauty and effectiveness in the live rule matching
        boolean complete = false;
        for (int i = 0; i < tmp.length; i++) {
            String instruction = tmp[i];
            if (complete) {
                break;
            }
            switch (instruction) {
                case "x":
                    this.testX = true;
                    break;
                case "y":
                    this.testY = true;
                    break;
                case "s":
                    this.testSuite = true;
                    break;
                case "+":
                    this.offset = Integer.parseInt(rule.split("\\+")[1]);
                    complete = true;
                    break;
                case "-":
                    this.offset = -Integer.parseInt(rule.split("-")[1]);
                    complete = true;
                    break;
                case "A":
                    this.testSpecific = 1;
                    break;
                case "2":
                    this.testSpecific = 2;
                    break;
                case "3":
                    this.testSpecific = 3;
                    break;
                case "4":
                    this.testSpecific = 4;
                    break;
                case "5":
                    this.testSpecific = 5;
                    break;
                case "6":
                    this.testSpecific = 6;
                    break;
                case "7":
                    this.testSpecific = 7;
                    break;
                case "8":
                    this.testSpecific = 8;
                    break;
                case "9":
                    this.testSpecific = 9;
                    break;
                case "T":
                    this.testSpecific = 10;
                    break;
                case "J":
                    this.testSpecific = 11;
                    break;
                case "Q":
                    this.testSpecific = 12;
                    break;
                case "K":
                    this.testSpecific = 13;
                    break;
            }
        }        
    }
    
    @Override
    public String toString() {
        String str = "";
        if (this.testX) {
            str += "x";
        }
        if (this.testY) {
            str += "y";
        }
        if (this.offset > 0) {
            str = str + "+" + this.offset;
        } else if (this.offset < 0) {
            str = str + this.offset;
        }
        if (this.testSpecific != -1) {
            str = str + Card.VALUE_CHARS[this.testSpecific];
        }
        if (this.testSuite) {
            str = str + "s";
        }
        
        return str;
    }

}
