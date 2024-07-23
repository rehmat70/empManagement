package com.employee.management.entityRepository;

import com.employee.management.entities.JobDepartment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobDepRepository extends JpaRepository<JobDepartment, Long> {


}
