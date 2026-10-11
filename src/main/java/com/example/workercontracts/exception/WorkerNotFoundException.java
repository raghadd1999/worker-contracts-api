package com.example.workercontracts.exception;

public class WorkerNotFoundException extends RuntimeException {

    public WorkerNotFoundException(Long id) {
        super("Worker not found: " + id);
    }
}
