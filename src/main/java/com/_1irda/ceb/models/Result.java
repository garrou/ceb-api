package com._1irda.ceb.models;

import java.util.ArrayList;
import java.util.List;

public class Result {

    private final ArrayList<Solution> solutions;

    public Result() {
        solutions = new ArrayList<>();
    }

    public void add(Solution solution) {
        if (isUnique(solution)) {
            solutions.add(solution);
        }
    }

    private boolean isUnique(Solution toCheck) {
        for (Solution solution : solutions) {

            ComputedOperand[] sol = solution.getOperations();
            ComputedOperand[] solToCheck = toCheck.getOperations();

            if (sol.length == solToCheck.length) {
                int same = 0;

                for (int i = 0; i < sol.length; i++) {
                    if (sol[i].equals(solToCheck[i])) {
                        same++;
                    }
                }
                if (same == sol.length) {
                    return false;
                }
            }
        }
        return true;
    }

    public List<Solution> getSolutions() {
        return solutions;

    }
}
