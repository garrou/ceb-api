package com._1irda.ceb.models;

import com._1irda.ceb.enums.Operator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com._1irda.cebapi.CebApiApplication.MAX_OPERANDS;

public class Solver {

    private final Result result;

    private final ComputedOperand[] operations;

    public Solver() {
        result = new Result();
        operations = new ComputedOperand[MAX_OPERANDS - 1];
    }

    public Solver solve(List<Operand> ops, int target, int depth) {

        for (Operand left : ops) {
            for (Operand right : ops) {
                if (left != right) {
                    for (Operator operator : Operator.values()) {
                        ComputedOperand newOpe = new ComputedOperand(left, right, operator).compute();

                        if (newOpe.getResult() != null) {
                            operations[depth] = newOpe;

                            if (newOpe.getResult().value() == target) {
                                result.add(new Solution(Arrays.copyOfRange(operations, 0, depth + 1)));
                            } else {
                                ArrayList<Operand> newOps = new ArrayList<>(ops);
                                newOps.remove(left);
                                newOps.remove(right);
                                newOps.add(newOpe.getResult());

                                depth++;
                                solve(newOps, target, depth);
                                depth--;
                            }
                        }
                    }
                }
            }
        }
        return this;
    }

    public Result getResult() {
        return result;
    }
}