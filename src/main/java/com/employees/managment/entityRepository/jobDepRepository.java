package com.employees.managment.entityRepository;

import com.employees.managment.Entities.jobDepartment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface jobDepRepository extends JpaRepository<jobDepartment, Long> {


}
