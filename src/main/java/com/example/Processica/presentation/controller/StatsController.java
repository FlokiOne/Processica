package com.example.Processica.presentation.controller;

import com.example.Processica.domain.stats.StatsService;
import com.example.Processica.presentation.dto.RsStats;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/stats")
public class StatsController {

    private final StatsService statsService;

    @Autowired
    StatsController(StatsService statsService) {
        this.statsService = statsService;
    }

    @GetMapping("/all")
    public List<RsStats> getAll() {
        return this.statsService.getAll();
    }

    @GetMapping("/all/unique")
    public List<RsStats> getUnique(@RequestParam(required = false, name = "requestId") String requestId) {
        return this.statsService.getUnique(requestId);
    }

    @GetMapping("/{statsId}")
    public RsStats getById(@PathVariable String statsId) {
        return this.statsService.getById(statsId);
    }

    @GetMapping("")
    public List<RsStats> getByWord(@RequestParam String word) {
        return this.statsService.findByWord(word);
    }

    @GetMapping("/request/{requestId}")
    public List<RsStats> getByRequest(@PathVariable String requestId) {
        return this.statsService.getByRequest(requestId);
    }
}
