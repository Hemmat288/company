package com.company.Controller;


import com.company.Services.EmployeesService;
import com.company.model.Employee;
//import com.example.video4.Services.EmployeesService;
//import com.example.video4.hr.model.Employees;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeesController {
    @Autowired
    private EmployeesService employeesService;
    @GetMapping("/allEmployees")
    public  List<Employee> getAllEmployees() {

        return  employeesService.getAll();
    }
    @GetMapping("/getEmpByid/{id}")
    public Employee getEmployee(@RequestParam Long id) {

        return  employeesService.getEmployee(id);
    }

    @PostMapping
    public String saveEmployee(@RequestBody Employee newEmp){
        employeesService.AddEmp(newEmp);
        return  "Save NewEmp";
    }

    @PutMapping
    public String UpdateEmp(@RequestBody Employee newEmp){
        employeesService.updateEmp(newEmp);
        return  "update NewEmp";
    }

    @DeleteMapping
    public String delete(@RequestParam Long id){
        employeesService.deleteEmp(id);
        return "deleted employee";
    }
}

