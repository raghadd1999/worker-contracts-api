# Worker Contracts API

A Spring Boot application that models employment contracts between workers and employers.

## Model (`com.example.workercontracts.model`)

- `Person` – abstract base class with a required name and nationality.
- `Worker` / `Employer` – interfaces describing each party.
- `ContractWorker` – a `Person` that is a `Worker`.
- `ContractEmployer` – a `Person` that is an `Employer`.
- `ContractType` – `PERMANENT`, `TEMPORARY` or `FREELANCE`.
- `Contract` – links a worker and an employer with start/end dates, salary and type.
  It rejects missing fields, an end date before the start date, and a negative salary.

`WorkerContractsApplication` is the Spring Boot entry point.

## Run

Requires Java 21 and Maven.

```bash
cd worker-contracts-api
mvn spring-boot:run
```
