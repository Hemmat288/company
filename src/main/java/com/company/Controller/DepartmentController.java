package com.company.Controller;

import com.company.Services.DeparmentService;
import com.company.model.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/department")
public class DepartmentController {
    @Autowired
    DeparmentService DepService;
@GetMapping("/all")
    public List<Department> getAll() {
        return DepService.getAll();
    }
@GetMapping
    public Department getDepById(@RequestParam Long id) {
        return DepService.getById(id);
    }

    @PostMapping
    public String newDept(@RequestBody Department newDep) {
          DepService.addDep(newDep);
        return  "add new Department";
    }
@PutMapping
    public String updateDep(@RequestBody Department newDep) {
        DepService.updateDep(newDep);
        return "update Department Success";
    }

    @DeleteMapping
    public String deleteDep(@RequestParam Long id){
        DepService.deleteDep(id);
        return "Deleted Department";
    }
}
