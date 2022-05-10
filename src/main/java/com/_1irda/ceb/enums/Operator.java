package com._1irda.ceb.enums;

public enum Operator {

    ADDITION('+'),

    SUBTRACTION('-'),

    MULTIPLICATION('x'),

    DIVISION('/');

    private final char symbol;

    Operator(char symbol) {
        this.symbol = symbol;
    }

    public char getSymbol() {
        return this.symbol;
    }
}