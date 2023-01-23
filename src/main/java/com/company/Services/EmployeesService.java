package com.company.Services;
import com.company.Repository.EmployeesRepository;
import com.company.model.Employees;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeesService {
    @Autowired
    EmployeesRepository employeesRepository;

    public List<Employees> getAll() {

        return employeesRepository.findAll();
    }
}
