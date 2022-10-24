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
            case ADDITION -> result = new Operand(left.value() + right.value());
            case SUBTRACTION -> {
                if (isCorrectSubtraction()) {
                    result = new Operand(left.value() - right.value());
                }
            }
            case MULTIPLICATION -> {
                if (isCorrectMultiplication()) {
                    result = new Operand(left.value() * right.value());
                }
            }
            case DIVISION -> {
                if (isCorrectDivision()) {
                    result = new Operand(left.value() / right.value());
                }
            }
        }
        return this;
    }

    private boolean isCorrectSubtraction() {
        return left.value() > right.value();
    }

    private boolean isCorrectMultiplication() {
        return left.value() != 1 && right.value() != 1;
    }

    private boolean isCorrectDivision() {
        return right.value() != 0 && right.value() != 1 && left.value() % right.value() == 0;
    }

    public Operand getResult() {
        return result;
    }

    @Override
    public String toString() {
        return left.value()
                + " "
                + operator.getSymbol()
                + " "
                + right.value()
                + " = "
                + result.value();
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
                && result.value() == toCompare.result.value()
                && (left.value() == toCompare.left.value()
                    && right.value() == toCompare.right.value())
                || (left.value() == toCompare.right.value()
                    && right.value() == toCompare.left.value());
    }
}