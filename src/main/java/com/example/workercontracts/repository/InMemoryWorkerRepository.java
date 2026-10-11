package com.example.workercontracts.repository;

import com.example.workercontracts.model.Worker;
import org.springframework.stereotype.Repository;

import java.util.Collections;
import java.util.Map;
import java.util.Optional;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class InMemoryWorkerRepository implements WorkerRepository {

    private final Map<Long, Worker> workers = new ConcurrentHashMap<>();
    private final AtomicLong nextId = new AtomicLong(1);

    @Override
    public Map<Long, Worker> findAll() {
        return Collections.unmodifiableMap(new TreeMap<>(workers));
    }

    @Override
    public Optional<Worker> findById(Long id) {
        return Optional.ofNullable(workers.get(id));
    }

    @Override
    public Long save(Worker worker) {
        Long id = nextId.getAndIncrement();
        workers.put(id, worker);
        return id;
    }

    @Override
    public void update(Long id, Worker worker) {
        workers.put(id, worker);
    }

    @Override
    public boolean existsById(Long id) {
        return workers.containsKey(id);
    }

    @Override
    public void deleteById(Long id) {
        workers.remove(id);
    }
}
