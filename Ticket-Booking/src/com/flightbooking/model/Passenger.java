package com.flightbooking.model;

public class Passenger {
    // 1. Private fields
    private String passengerId;
    private String name;
    private int age;
    private String email;

    // 2. Default Constructor
    public Passenger() {
    }

    // 3. Parameterized Constructor
    public Passenger(String passengerId, String name, int age, String email) {
        this.passengerId = passengerId;
        this.name = name;
        this.age = age;
        this.email = email;
    }

    // 4. Getters and Setters
    public String getPassengerId() { return passengerId; }
    public void setPassengerId(String passengerId) { this.passengerId = passengerId; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    // 5. Overridden toString
    @Override
    public String toString() {
        return "Passenger ID: " + passengerId + " | Name: " + name + " | Age: " + age + " | Email: " + email;
    }
}
