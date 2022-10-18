package com._1irda.cebapi.controllers;

import com._1irda.cebapi.dto.SolutionDto;
import com._1irda.cebapi.models.Response;
import com._1irda.cebapi.models.Request;
import com._1irda.cebapi.services.CebService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(path = "api/compute")
public class CebController {

    private final CebService cebService;

    @Autowired
    public CebController(CebService cebService) {
        this.cebService = cebService;
    }

    @GetMapping
    public  ResponseEntity<String> get() {
        return ResponseEntity.ok("https://github.com/garrou/ceb-api");
    }

    @PostMapping
    public ResponseEntity<Response> postOperandsAndGoal(@Valid @RequestBody Request request) {
        if (!request.isValid()) {
            return ResponseEntity.badRequest().body(new Response(0, 0, null));
        }
        double start = System.currentTimeMillis();
        List<SolutionDto> solutions = cebService.computeSolutions(request);
        double end = (System.currentTimeMillis() - start) / 1000.0;
        return ResponseEntity.ok(new Response(end, solutions.size(), solutions));
    }
}