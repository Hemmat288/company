package com.company.model;


import javax.persistence.*;

@Entity
@Table(name = "Employees")
public class Employees {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  long id;
    @Column(name = "First_Name")
    private String firstName;
    private String lastName;
    private double salary;
    private String address;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Employees(long id, String firstName, String lastName, double salary, String address) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.salary = salary;
        this.address = address;
    }

    public Employees() {
    }
}
