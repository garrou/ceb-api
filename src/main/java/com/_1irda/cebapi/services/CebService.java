package com._1irda.cebapi.services;

import com._1irda.ceb.models.Operand;
import com._1irda.ceb.models.Solver;
import com._1irda.cebapi.dto.SolutionDto;
import com._1irda.cebapi.models.Request;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

@Service
public class CebService {

    public List<SolutionDto> computeSolutions(Request request) {

        List<Operand> operands = Arrays
                .stream(request.operands())
                .mapToObj(Operand::new)
                .toList();
        return new Solver()
                .solve(operands, request.goal(), 0)
                .getResult()
                .getSolutions()
                .stream()
                .sorted(Comparator.naturalOrder())
                .map(SolutionDto::new)
                .toList();
    }
}