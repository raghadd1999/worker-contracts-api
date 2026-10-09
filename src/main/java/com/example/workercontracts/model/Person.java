package com.example.workercontracts.model;

public abstract class Person {

    private final String name;
    private final String nationality;

    protected Person(String name, String nationality) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Name is required");
        }

        if (nationality == null || nationality.isBlank()) {
            throw new IllegalArgumentException(
                    "Nationality is required"
            );
        }

        this.name = name;
        this.nationality = nationality;
    }

    public String getName() {
        return name;
    }

    public String getNationality() {
        return nationality;
    }
}
