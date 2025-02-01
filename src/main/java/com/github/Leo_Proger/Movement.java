package com.github.Leo_Proger;

public enum Movement {
    CROSS("X"),
    ZERO("O");

    private final String symbol;
    Movement(String symbol) {
        this.symbol = symbol;
    }

    public String getSymbol() {
        return symbol;
    }
}
