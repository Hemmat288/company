package com.company.Controller;


import com.company.Services.EmployeesService;
import com.company.model.Employees;
//import com.example.video4.Services.EmployeesService;
//import com.example.video4.hr.model.Employees;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeesController {
    @Autowired
    private EmployeesService employeesService;
    @GetMapping
    public  List<Employees> getAllEmploye() {
//        List<Employees> emps = new ArrayList<Employees>();
//
//        emps.add(new Employees(1, "Hemmat", "Mofy", 550, "Asyut"));
//        emps.add(new Employees(2, "Dalia", "Mofy", 250, "Asyut"));
//        emps.add(new Employees(3, "Dina", "Mofy", 280, "Asyut"));
//        emps.add (new Employees(4, "Haidy", "Rafat", 50, "Asyut"));
//        emps.add (new Employees(5, "Nour", "mostafa", 20, "Asyut"));

        return  employeesService.getAll();
    }
}

