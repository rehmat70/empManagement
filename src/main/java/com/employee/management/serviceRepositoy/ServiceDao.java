package com.employee.management.serviceRepositoy;

import com.employee.management.entities.Employee;
import com.employee.management.entities.JobDepartment;
import com.employee.management.entities.Payroll;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ServiceDao {


    Employee saveEntity(Employee employees);

     List<Employee> saveAllEntity(List<Employee> employees);
     JobDepartment addEntity(JobDepartment jobDepartments);
     Payroll savepayroll(Payroll payrolls);
//***********************************************************************************
    //custom method get employees by id
    Employee employeeFindById(Long employee_Id);
    JobDepartment jobDepartmentFindById(Long jobDepartment_Id);
    Payroll payrollFindById(Long payrollId);
    //************************************************************************
        //jpaRepository method employees findAll
    List<Employee> employeeFindAll(Employee employees);
        //custom method employees age findByAfter
    List<Employee> ageFindByAfter(int age);
       //custom between method
    List<Employee> ageFindByBetween(int miniAge, int maxiAge);

    //**********************************************************************
        //jpa Repository update method for employees
     Employee updateEmployees(Employee employees, Long employeeId);

        //jpa repository update method for jobDepartment
    JobDepartment updateJobDepartment(JobDepartment jobDepartment, Long jobDepartment_Id);
        //jpa repository update method for payroll
     Payroll updatePayroll(Payroll payroll , Long payrollId);
    //*********************************************************************

      //jpa Repository Delete By Id method

    ResponseEntity<Employee> deleteById(Long employeeId);

}
