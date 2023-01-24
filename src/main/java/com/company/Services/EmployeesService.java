package com.company.Services;
import com.company.Repository.EmployeesRepository;
import com.company.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeesService {
    @Autowired
    EmployeesRepository employeesRepository;

    public List<Employee> getAll() {

        return employeesRepository.findAll();
    }
    public Employee getEmployee(Long id){

        return employeesRepository.findById(id).orElseThrow(null);
    }
    public  void AddEmp(Employee newEmp){
        employeesRepository.save(newEmp);
    }
    public  void updateEmp(Employee newEmp){
        employeesRepository.save(newEmp);
    }
    public void deleteEmp(Long id){
        employeesRepository.deleteById(id);
    }
}
