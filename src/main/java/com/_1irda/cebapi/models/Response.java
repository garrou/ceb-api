package com._1irda.cebapi.models;

import com._1irda.cebapi.dto.SolutionDto;

import java.util.List;

public record Response(double timeInSecs, int nbSolutions, List<SolutionDto> solutions) {
}
