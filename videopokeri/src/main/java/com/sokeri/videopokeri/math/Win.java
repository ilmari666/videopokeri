package com.sokeri.videopokeri.math;

/**
 *
 * @author Ilmari
 * A simple container class for win information
 */
public class Win {
    private String name;
    private WinPattern pattern;
    private long multiplier;
    
    public Win(RawWin config) {
        this.name = config.name;
        this.multiplier = config.multiplier;
        this.pattern = new WinPattern(config.pattern);
    }
    
    public long getMultiplier() {
        return this.multiplier;
    }
    public WinPattern getPattern() {
        return this.pattern;
    }
    
    public String getName() {
        return this.name;
    }
}
