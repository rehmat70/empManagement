package com.employees.managment.serviceImpl;

import com.employees.managment.Entities.employees;
import com.employees.managment.Entities.jobDepartment;
import com.employees.managment.Entities.payroll;
import com.employees.managment.Exception.ResponseNotFoundException;
import com.employees.managment.entityRepository.empRepository;
import com.employees.managment.entityRepository.jobDepRepository;
import com.employees.managment.entityRepository.payrollRepository;
import com.employees.managment.serviceRepositoy.ServiceDao;
import org.hibernate.Hibernate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ServiceDaoImpl implements ServiceDao {
    private final payrollRepository payrollRepository;
    private final jobDepRepository jobDepRepository;
    private final empRepository empRepository;


    public ServiceDaoImpl(jobDepRepository jobDepRepository, empRepository empRepository,payrollRepository payrollRepository) {
        this.jobDepRepository = jobDepRepository;
        this.empRepository = empRepository;
        this.payrollRepository=payrollRepository;
    }

    @Override
    public employees saveEntity(employees employee) {

        return empRepository.save(employee);
    }


//@Override
//         // Assuming you have a method to save an employee entity in your service or repository class
//    public employees saveEntity(employees employee) {
//        // Get the jobDepartment from the employee
//        jobDepartment department = employee.getJobDepartment();
//
//        // If the jobDepartment is not null and doesn't have a primary key (ID), save it first
//        if (department != null && department.getJobDepartment_Id() == null) {
//            department = jobDepRepository.save(department);
//        }
//
//        // Set the jobDepartment for the employee
//        employee.setJobDepartment(department);
//
//        // Save the employee entity
//        return empRepository.save(employee);
//    }

    @Override
    public List<employees> saveAllEntity(List<employees> employees) {
        return empRepository.saveAll(employees);
    }

    //********************************************************************************8

    @Override
    public jobDepartment addEntity(jobDepartment jobDepartments) {

        return jobDepRepository.save(jobDepartments);
    }

    @Override
    public payroll savepayroll(payroll payrolls) {

        return payrollRepository.save(payrolls);
    }

//***************************************************************************************
    //custom method get employee by id
@Override
public employees employeeFindById(Long employee_Id) {
    employees employee = empRepository.findById(employee_Id)
            .orElseThrow(() -> new ResponseNotFoundException("employees", "employee_Id", employee_Id));

    // Initialize the payroll association if it's lazily fetched
    if (employee != null && !Hibernate.isInitialized(employee.getPayroll())) {
        Hibernate.initialize(employee.getPayroll());
    }

    return employee;
}
//        return empRepository.findById(employee_Id)
//                .orElseThrow(() -> new ResponseNotFoundException("employees", "employee_Id", employee_Id));
//    }

    @Override
    public jobDepartment jobDepartmentFindById(Long jobDepartment_Id) {
        return jobDepRepository.findById(jobDepartment_Id)
                .orElseThrow(() -> new ResponseNotFoundException("jobDepartment", "jobDepartment_Id", jobDepartment_Id));
    }

    @Override
    public payroll payrollFindById(Long payrollId) {
        return payrollRepository.findById(payrollId)
                .orElseThrow(() -> new ResponseNotFoundException("payroll", "payrollId", payrollId));
    }

    @Override
    public List<employees> employeeFindAll(employees employees) {
        return empRepository.findAll();
    }

    @Override
    public List<employees> ageFindByAfter(int age) {
        return empRepository.findByAgeAfter(age);
    }

    @Override
    public List<employees> ageFindByBetween(int miniAge, int maxiAge) {
        return empRepository.findByAgeBetween(miniAge, maxiAge);
    }

//***************************************************************************************
@Override
public employees updateEmployees(employees employees, Long employeeId) {
      employees employees1=  empRepository.findById(employeeId)
              .orElseThrow(() ->new ResponseNotFoundException("employees", "employeeId", employeeId));
      employees1.setFirstName(employees.getFirstName());
      employees1.setLastName(employees.getLastName());
      employees1.setGender(employees.getGender());
      employees1.setAge(employees.getAge());
      employees1.setContactNumbers(employees.getContactNumbers());
      employees1.setEmail(employees.getEmail());
      empRepository.save(employees1);
    return employees1;
}

    @Override
    public jobDepartment updateJobDepartment(jobDepartment jobDepartment, Long jobDepartment_Id) {
       jobDepartment job=jobDepRepository.findById(jobDepartment_Id)
               .orElseThrow(() -> new ResponseNotFoundException("jobDepartment", "jobDepartment_Id", jobDepartment_Id));
       job.setDepartment(jobDepartment.getDepartment());
       job.setName(jobDepartment.getName());
       job.setDescription(jobDepartment.getDescription());
       job.setSalaryRange(jobDepartment.getSalaryRange());
       jobDepRepository.save(job);
        return job;
    }


    @Override
    public payroll updatePayroll(payroll payroll, Long payrollId) {
        payroll pay=payrollRepository.findById(payrollId)
                .orElseThrow(() ->new ResponseNotFoundException("payroll", "payrollId", payrollId));
        pay.setBasicSalary(payroll.getBasicSalary());
        pay.setPreviousSalary(payroll.getPreviousSalary());
        pay.setDate(payroll.getDate());
        pay.setReport(payroll.getReport());
        pay.setTotalSalary(payroll.getTotalSalary());
        payrollRepository.save(pay);

        return pay;
    }


    //*******************************************************************************
    @Override
    public ResponseEntity<employees> deleteById(Long employeeId) {
        employees entityDeletion=empRepository.findById(employeeId)
                .orElseThrow(() -> new ResponseNotFoundException("employees", "employeeId", employeeId));
        empRepository.deleteById(employeeId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


}
