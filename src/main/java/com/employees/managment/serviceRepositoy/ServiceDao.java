package com.employees.managment.serviceRepositoy;

import com.employees.managment.Entities.employees;
import com.employees.managment.Entities.jobDepartment;
import com.employees.managment.Entities.payroll;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface ServiceDao {


    public employees saveEntity(employees employees);

    public List<employees> saveAllEntity(List<employees> employees);
    public jobDepartment addEntity(jobDepartment jobDepartments);
    public payroll savepayroll(payroll payrolls);
//***********************************************************************************
    //custom method get employees by id
    public employees employeeFindById(Long employee_Id);
    public jobDepartment jobDepartmentFindById(Long jobDepartment_Id);
    public payroll payrollFindById(Long payrollId);
    //************************************************************************
        //jpaRepository method employees findAll
    public List<employees> employeeFindAll(employees employees);
        //custom method employees age findByAfter
    public List<employees> ageFindByAfter(int age);
       //custom between method
    public List<employees> ageFindByBetween(int miniAge, int maxiAge);

    //**********************************************************************
        //jpa Repository update method for employees
    public employees updateEmployees(employees employees, Long employeeId);

        //jpa repository update method for jobDepartment
    public jobDepartment updateJobDepartment(jobDepartment jobDepartment, Long jobDepartment_Id);
        //jpa repository update method for payroll
    public payroll updatePayroll(payroll payroll , Long payrollId);
    //*********************************************************************

      //jpa Repository Delete By Id method

    public ResponseEntity<employees> deleteById(Long employeeId);

}
