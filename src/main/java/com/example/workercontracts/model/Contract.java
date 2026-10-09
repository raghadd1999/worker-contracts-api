package com.example.workercontracts.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

public class Contract {

    private final Worker worker;
    private final Employer employer;
    private final LocalDate startDate;
    private final LocalDate endDate;
    private final BigDecimal salary;
    private final ContractType contractType;

    public Contract(
            Worker worker,
            Employer employer,
            LocalDate startDate,
            LocalDate endDate,
            BigDecimal salary,
            ContractType contractType
    ) {
        this.worker = Objects.requireNonNull(
                worker, "Worker is required"
        );

        this.employer = Objects.requireNonNull(
                employer, "Employer is required"
        );

        this.startDate = Objects.requireNonNull(
                startDate, "Start date is required"
        );

        this.endDate = Objects.requireNonNull(
                endDate, "End date is required"
        );

        this.salary = Objects.requireNonNull(
                salary, "Salary is required"
        );

        this.contractType = Objects.requireNonNull(
                contractType, "Contract type is required"
        );

        if (endDate.isBefore(startDate)) {
            throw new IllegalArgumentException(
                    "End date cannot be before start date"
            );
        }

        if (salary.signum() < 0) {
            throw new IllegalArgumentException(
                    "Salary cannot be negative"
            );
        }
    }

    public Worker getWorker() {
        return worker;
    }

    public Employer getEmployer() {
        return employer;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public ContractType getContractType() {
        return contractType;
    }
}
