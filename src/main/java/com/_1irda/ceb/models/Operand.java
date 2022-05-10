package com._1irda.ceb.models;

public record Operand(int value) {

    @Override
    public String toString() {
        return String.valueOf(value);
    }
}