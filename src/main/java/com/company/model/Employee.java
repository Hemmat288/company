package com.company.model;


import lombok.*;
import org.hibernate.engine.internal.Cascade;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name = "Employees")
@Data
@NoArgsConstructor
@AllArgsConstructor

//@NamedQuery(name = "Employee.findBySalary",query = "select emp from employee emp where emp.salary>=:salary")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  long id;

//    @NotEmpty(message = "first name must not be empty")
    private String firstName;
    private String lastName;
    private double salary;
    @NotBlank
    @Size(min = 0, max = 50)

    private String address;
    @ManyToOne(cascade=CascadeType.ALL)
private  Department Dep;



}
