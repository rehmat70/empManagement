package com.employees.managment.entityRepository;

import com.employees.managment.Entities.employees;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface empRepository extends JpaRepository<employees, Long> {
    public List<employees> findByAgeAfter(int age);

    public List<employees> findByAgeBetween(int miniAge, int maxiAge);

}
