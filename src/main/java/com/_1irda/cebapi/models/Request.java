package com._1irda.cebapi.models;

import javax.validation.constraints.*;

import java.util.Arrays;

import static com._1irda.cebapi.CebApiApplication.MAX_OPERANDS;

public record Request(
        @NotEmpty(message = "You must define " + MAX_OPERANDS + " operands")
        @Size.List({@Size(min = MAX_OPERANDS), @Size(max = MAX_OPERANDS)}) int[] operands,
        @Min(value = 0, message = "Min goal is {value}") int goal) {

    public Request(int[] operands, int goal) {
        this.operands = operands;
        this.goal = goal;
    }

    public boolean isValid() {
        return Arrays.stream(operands).allMatch(op -> op > 0);
    }

    @Override
    public int[] operands() {
        return operands;
    }

    @Override
    public int goal() {
        return goal;
    }
}
