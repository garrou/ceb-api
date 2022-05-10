package com._1irda.ceb.models;

public class Operand {

    private final int value;

    public Operand(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }
}