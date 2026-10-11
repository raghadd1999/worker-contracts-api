package com.example.workercontracts.service;

import com.example.workercontracts.dto.WorkerRequest;
import com.example.workercontracts.dto.WorkerResponse;
import com.example.workercontracts.exception.WorkerNotFoundException;
import com.example.workercontracts.model.ContractWorker;
import com.example.workercontracts.model.Worker;
import com.example.workercontracts.repository.WorkerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WorkerService {

    private final WorkerRepository workerRepository;

    public WorkerService(WorkerRepository workerRepository) {
        this.workerRepository = workerRepository;
    }

    public List<WorkerResponse> findAll() {
        return workerRepository.findAll()
                .entrySet()
                .stream()
                .map(entry -> WorkerResponse.from(entry.getKey(), entry.getValue()))
                .toList();
    }

    public WorkerResponse findById(Long id) {
        Worker worker = workerRepository.findById(id)
                .orElseThrow(() -> new WorkerNotFoundException(id));
        return WorkerResponse.from(id, worker);
    }

    public WorkerResponse create(WorkerRequest request) {
        Worker worker = toWorker(request);
        Long id = workerRepository.save(worker);
        return WorkerResponse.from(id, worker);
    }

    public WorkerResponse update(Long id, WorkerRequest request) {
        if (!workerRepository.existsById(id)) {
            throw new WorkerNotFoundException(id);
        }
        Worker worker = toWorker(request);
        workerRepository.update(id, worker);
        return WorkerResponse.from(id, worker);
    }

    public void delete(Long id) {
        if (!workerRepository.existsById(id)) {
            throw new WorkerNotFoundException(id);
        }
        workerRepository.deleteById(id);
    }

    private Worker toWorker(WorkerRequest request) {
        if (request == null) {
            throw new IllegalArgumentException("Request body is required");
        }
        return new ContractWorker(request.name(), request.nationality());
    }
}
