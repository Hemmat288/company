package com.company.Services;

import com.company.Repository.DepartmentRepository;
import com.company.model.Department;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Service
public class DeparmentService {

    DepartmentRepository DepRepository;

    public List<Department> getAll(){
       return DepRepository.findAll();
    }
    public Department getById(@RequestParam Long id){
        return DepRepository.findById(id).orElseThrow(null);
    }
    public void addDep(@RequestBody Department newDep){
        DepRepository.save(newDep);

    }
    public void updateDep(@RequestParam Department newDep){
        DepRepository.save(newDep);

    }
    public  void deleteDep(@RequestParam Long id){
        DepRepository.deleteById(id);

    }



}
