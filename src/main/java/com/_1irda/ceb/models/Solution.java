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

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof Solution toCompare)) {
            return false;
        }
        ComputedOperand[] opsToCheck = toCompare.getOperations();

        if (operations.length == opsToCheck.length) {
            int same = 0;

            for (int i = 0; i < operations.length; i++) {
                if (Arrays.asList(operations).contains(opsToCheck[i])) {
                    same++;
                }
            }
            return same == operations.length;
        }
        return false;
    }
}
