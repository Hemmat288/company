package com.company.Services;
import com.company.Repository.EmployeesRepository;
import com.company.error.RecordNotFoundException;
import com.company.model.Employee;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.bytebuddy.dynamic.scaffold.TypeWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class EmployeesService {

    final EmployeesRepository employeesRepository;

//    public List<Employee> getByDepId(Long DepId) {
//       return employeesRepository.findAllByDep_id(DepId);
//    }

    public List<Employee> getAll() {
log.info("hiiiiiiiiiiiiiiii");
        return employeesRepository.findAll();
    }
    public Employee getEmployee(Long id){

        return employeesRepository.findById(id).orElseThrow(() ->new RecordNotFoundException("this employee Not Found"+id));
    }
    public List<Employee> getEmpByFirstName(String firstName){

        return employeesRepository.findByFirstName(firstName);
    }
    public List<Employee> EmpSearchbyName(String firstName,String lastName){

        return employeesRepository.EmpSearch(firstName,lastName);
    }
//    public List<Employee> findEmpBySalary(Double salary){
//
//        return employeesRepository.findEmpBySalary(salary);
//    }
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
