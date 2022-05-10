package com._1irda.ceb.models;

import com._1irda.ceb.enums.Operator;

public class ComputedOperand {

    private final Operand left;

    private final Operand right;

    private final Operator operator;

    private Operand result;

    public ComputedOperand(Operand l, Operand r, Operator op) {
        left = l;
        right = r;
        operator = op;
    }

    public ComputedOperand compute() {
        switch (operator) {
            case ADDITION -> result = new Operand(left.getValue() + right.getValue());
            case SUBTRACTION -> result = new Operand(left.getValue() - right.getValue());
            case MULTIPLICATION -> {
                if (isCorrectMultiplication()) {
                    result = new Operand(left.getValue() * right.getValue());
                }
            }
            case DIVISION -> {
                if (isCorrectDivision()) {
                    result = new Operand(left.getValue() / right.getValue());
                }
            }
        }
        return this;
    }

    private boolean isCorrectMultiplication() {
        return left.getValue() != 1 && right.getValue() != 1;
    }

    private boolean isCorrectDivision() {
        return right.getValue() != 0 && right.getValue() != 1 && left.getValue() % right.getValue() == 0;
    }

    public Operand getResult() {
        return result;
    }

    @Override
    public String toString() {
        return left.getValue()
                + " "
                + operator.getSymbol()
                + " "
                + right.getValue()
                + " = "
                + result.getValue();
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof ComputedOperand toCompare)) {
            return false;
        }
        return operator == toCompare.operator
                && result.getValue() == toCompare.result.getValue()
                && (left.getValue() == toCompare.left.getValue()
                    && right.getValue() == toCompare.right.getValue())
                || (left.getValue() == toCompare.right.getValue()
                    && right.getValue() == toCompare.left.getValue());
    }
}