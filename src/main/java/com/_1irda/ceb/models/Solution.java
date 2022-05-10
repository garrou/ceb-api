package com._1irda.ceb.models;

import java.util.Arrays;

public class Solution implements Comparable<Solution> {

    private final ComputedOperand[] operations;

    public Solution(ComputedOperand[] ops) {
        operations = ops;
    }

    public ComputedOperand[] getOperations() {
        return operations;
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        Arrays.stream(operations).forEach(s::append);
        return s.toString();
    }

    @Override
    public int compareTo(Solution o) {
        return operations.length - o.operations.length;
    }
}
