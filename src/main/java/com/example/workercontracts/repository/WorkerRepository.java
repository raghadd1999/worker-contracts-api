package com.example.workercontracts.repository;

import com.example.workercontracts.model.Worker;

import java.util.Map;
import java.util.Optional;

public interface WorkerRepository {

    Map<Long, Worker> findAll();

    Optional<Worker> findById(Long id);

    Long save(Worker worker);

    void update(Long id, Worker worker);

    boolean existsById(Long id);

    void deleteById(Long id);
}
