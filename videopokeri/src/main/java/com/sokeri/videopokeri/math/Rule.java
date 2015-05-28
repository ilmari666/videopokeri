/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sokeri.videopokeri.math;
import java.util.Arrays;

/**
 *
 * @author Ilmari
 */
public class Rule {
    public boolean testSuite;
    public boolean testX;
    public boolean testY;
    
    public int offset = 0;
    public int testSpecific = -1;
    
    public Rule(){
        
    }
    
    public Rule(String rule){
        this.setRule(rule);
    }
    
    public void setRule(String rule){
       String[] tmp = rule.split("");
        // we do an ugly chew to create beauty and effectiveness in the live rule matching
        
        boolean complete = false;
        for (String instruction : tmp) {
            if (complete){
                break;
            }
            switch (instruction) {
                case "x":
                    this.testX = true;
                    break;
                case "y":
                    this.testY= true;
                    break;
                case "s":
                    this.testSuite = true;
                    break;
                case "+":
                    this.offset = Integer.parseInt(rule.split("+")[1]);
                    complete = true;
                    break;
                case "-":
                    this.offset = -Integer.parseInt(rule.split("+")[1]);
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
}
