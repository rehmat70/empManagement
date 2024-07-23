package com.employee.management.entityRepository;

import com.employee.management.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmpRepository extends JpaRepository<Employee, Long> {
    List<Employee> findByAgeAfter(int age);

    List<Employee> findByAgeBetween(int miniAge, int maxiAge);

}
