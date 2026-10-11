package com.example.workercontracts.dto;

import com.example.workercontracts.model.Worker;

public record WorkerResponse(Long id, String name, String nationality) {

    public static WorkerResponse from(Long id, Worker worker) {
        return new WorkerResponse(
                id,
                worker.getName(),
                worker.getNationality()
        );
    }
}
