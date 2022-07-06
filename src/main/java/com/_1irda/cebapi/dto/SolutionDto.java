package com._1irda.cebapi.dto;


import com._1irda.ceb.models.ComputedOperand;
import com._1irda.ceb.models.Solution;

import java.util.stream.IntStream;

public class SolutionDto {

    private final String[] operations;

    public SolutionDto(Solution solution) {
        ComputedOperand[] solutions = solution.getOperations();
        operations = new String[solutions.length];

        IntStream.range(0, operations.length)
                .forEach(i -> operations[i] = solutions[i].toString());
    }

    public String[] getOperations() {
        return operations;
    }
}
