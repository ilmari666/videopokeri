package com.sokeri.videopokeri.math;

/**
 *
 * @author Ilmari
 * A simple container for a set of rules that form a pattern used in checking for matching wins
 */
public class WinPattern {
    public Rule[] pattern;
    public WinPattern(String pattern) {
        String[] tmp = pattern.split(",");
        this.pattern = new Rule[tmp.length];
        for (int i = 0; i < tmp.length; i++) {
            this.pattern[i] = new Rule(tmp[i]);
        }
    }
}
