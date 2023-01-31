package com.company.Repository;


import com.company.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeesRepository extends JpaRepository<Employee,Long> {
//    @Query("select * from employees  JOIN department   on employees.dep_id= department.id ;")
//    public  List<Employee> findAllByDep_id(Long Dep_id);

    public List<Employee> findByFirstName(String firstName);

    @Query("select emp from Employee emp where emp.firstName=:firstNamebind and emp.lastName=:lastNamebind ")
    public  List<Employee> EmpSearch(@Param("firstNamebind")String firstName ,@Param("lastNamebind") String lastName);

   /////namedQuery
    public List<Employee>findEmpBySalary(Double  salary);
}
