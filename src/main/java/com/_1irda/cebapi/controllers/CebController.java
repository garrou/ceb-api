package com._1irda.cebapi.controllers;

import com._1irda.cebapi.dto.SolutionDto;
import com._1irda.cebapi.models.Objective;
import com._1irda.cebapi.services.CebService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Collections;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(path = "api/v1/ceb")
public class CebController {

    private final CebService cebService;

    @Autowired
    public CebController(CebService cebService) {
        this.cebService = cebService;
    }

    @PostMapping
    public ResponseEntity<Map<String, List<SolutionDto>>> postOperandsAndGoal(@Valid @RequestBody Objective objective) {
        return ResponseEntity.ok(Collections.singletonMap("solutions", cebService.computeSolutions(objective)));
    }
}