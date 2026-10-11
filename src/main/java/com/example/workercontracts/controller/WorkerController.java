package com.example.workercontracts.controller;

import com.example.workercontracts.dto.WorkerRequest;
import com.example.workercontracts.dto.WorkerResponse;
import com.example.workercontracts.service.WorkerService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/workers")
public class WorkerController {

    private final WorkerService workerService;

    public WorkerController(WorkerService workerService) {
        this.workerService = workerService;
    }

    @GetMapping
    public List<WorkerResponse> getAll() {
        return workerService.findAll();
    }

    @GetMapping("/{id}")
    public WorkerResponse getById(@PathVariable Long id) {
        return workerService.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public WorkerResponse create(@RequestBody WorkerRequest request) {
        return workerService.create(request);
    }

    @PutMapping("/{id}")
    public WorkerResponse update(
            @PathVariable Long id,
            @RequestBody WorkerRequest request
    ) {
        return workerService.update(id, request);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        workerService.delete(id);
    }
}
