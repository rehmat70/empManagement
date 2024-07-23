package com.employee.management.entityRepository;

import com.employee.management.entities.Payroll;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PayrollRepository extends JpaRepository<Payroll, Long> {



}
