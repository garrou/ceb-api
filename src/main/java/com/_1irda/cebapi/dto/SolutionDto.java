package com._1irda.cebapi.dto;

import com._1irda.ceb.models.Solution;

import java.util.stream.IntStream;

public class SolutionDto {

    private final String[] operations;

    public SolutionDto(Solution solution) {
        operations = new String[solution.getOperations().length];
        IntStream.range(0, operations.length)
                .forEach(i -> operations[i] = solution.getOperations()[i].toString());
    }

    public String[] getOperations() {
        return operations;
    }
}
