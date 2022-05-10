package com._1irda.cebapi.services;

import com._1irda.ceb.models.Operand;
import com._1irda.ceb.models.Solver;
import com._1irda.cebapi.dto.SolutionDto;
import com._1irda.cebapi.models.Objective;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class CebService {

    public List<SolutionDto> computeSolutions(Objective objective) {

        List<Operand> operands = Arrays
                .stream(objective.operands())
                .mapToObj(Operand::new)
                .toList();
        return new Solver()
                .solve(operands, objective.goal(), 0)
                .getResult()
                .getSolutions()
                .stream()
                .map(SolutionDto::new)
                .toList();
    }
}