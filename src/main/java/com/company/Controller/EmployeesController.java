package com.company.Controller;


import com.company.Services.EmployeesService;
import com.company.model.Department;
import com.company.model.Employee;
//import com.example.video4.Services.EmployeesService;
//import com.example.video4.hr.model.Employees;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeesController {
    @Autowired
    private EmployeesService employeesService;


//    @GetMapping("/department/{depId}/employees")
//    public List<Employee> getAllEmpByDepId(@PathVariable Long depId) {
//        return employeesService.getByDepId(depId);
//    }
    @GetMapping("/allEmployees")
    public  List<Employee> getAllEmployees() {

        return  employeesService.getAll();
    }
    @GetMapping
    public  List<Employee> getEmpByFirstName(@RequestParam String firstName) {

        return  employeesService.getEmpByFirstName(firstName);
    }
    @GetMapping("/Search")
    public  List<Employee> getEmpName(@RequestParam String firstName ,@RequestParam String lastName) {

        return  employeesService.EmpSearchbyName(firstName,lastName);
    }
//    @GetMapping("/salary")
//    public ResponseEntity<?> findBySalary(@RequestParam Double salary) {
//
//        return  ResponseEntity.ok(employeesService.findEmpBySalary(salary)) ;
//    }
    @GetMapping("/getEmpById")
    public Employee getEmployee(@RequestParam Long id) {

        return  employeesService.getEmployee(id);
    }

    @PostMapping
    public ResponseEntity<Employee> saveEmployee(@Valid @RequestBody Employee newEmp){
        employeesService.AddEmp(newEmp);
        return new ResponseEntity<Employee>(newEmp , HttpStatus.OK)  ;
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

