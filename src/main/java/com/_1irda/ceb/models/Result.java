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
            if (solution.equals(toCheck)) {
                return false;
            }
        }
        return true;
    }

    public List<Solution> getSolutions() {
        return solutions;
    }
}
