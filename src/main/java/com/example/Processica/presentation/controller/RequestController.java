package com.example.Processica.presentation.controller;

import com.example.Processica.domain.request.RequestService;
import com.example.Processica.presentation.dto.RsRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/request")
public class RequestController {

    private final RequestService requestService;

    @Autowired
    RequestController(RequestService requestService) {
        this.requestService = requestService;
    }

    @GetMapping("/all")
    public List<RsRequest> searchByAddress() {
        return this.requestService.getAll();
    }

    @GetMapping("/{requestId}")
    public RsRequest getById(@PathVariable String requestId) {
        return this.requestService.getById(requestId);
    }

    @PostMapping("/save")
    public RsRequest save(@RequestParam String text) {
        return this.requestService.save(text);
    }

    @DeleteMapping("/{requestId}")
    public String remove(@PathVariable String requestId) {
        return this.requestService.remove(requestId);
    }
}
