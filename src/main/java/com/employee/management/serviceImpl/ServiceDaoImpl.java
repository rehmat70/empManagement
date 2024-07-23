package com.employee.management.serviceImpl;

import com.employee.management.entityRepository.EmpRepository;
import com.employee.management.entityRepository.JobDepRepository;
import com.employee.management.entityRepository.PayrollRepository;
import com.employee.management.serviceRepositoy.ServiceDao;
import com.employee.management.entities.Employee;
import com.employee.management.entities.JobDepartment;
import com.employee.management.entities.Payroll;
import com.employee.management.exception.ResponseNotFoundException;
import org.hibernate.Hibernate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ServiceDaoImpl implements ServiceDao {
    private final PayrollRepository payrollRepository;
    private final JobDepRepository jobDepRepository;
    private final EmpRepository empRepository;


    public ServiceDaoImpl(JobDepRepository jobDepRepository, EmpRepository empRepository, PayrollRepository payrollRepository) {
        this.jobDepRepository = jobDepRepository;
        this.empRepository = empRepository;
        this.payrollRepository=payrollRepository;
    }

    @Override
    public Employee saveEntity(Employee employee) {

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
    public List<Employee> saveAllEntity(List<Employee> employees) {
        return empRepository.saveAll(employees);
    }

    //********************************************************************************8

    @Override
    public JobDepartment addEntity(JobDepartment jobDepartments) {

        return jobDepRepository.save(jobDepartments);
    }

    @Override
    public Payroll savepayroll(Payroll payrolls) {

        return payrollRepository.save(payrolls);
    }

//***************************************************************************************
    //custom method get employee by id
@Override
public Employee employeeFindById(Long employee_Id) {
    Employee employee = empRepository.findById(employee_Id)
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
    public JobDepartment jobDepartmentFindById(Long jobDepartment_Id) {
        return jobDepRepository.findById(jobDepartment_Id)
                .orElseThrow(() -> new ResponseNotFoundException("jobDepartment", "jobDepartment_Id", jobDepartment_Id));
    }

    @Override
    public Payroll payrollFindById(Long payrollId) {
        return payrollRepository.findById(payrollId)
                .orElseThrow(() -> new ResponseNotFoundException("payroll", "payrollId", payrollId));
    }

    @Override
    public List<Employee> employeeFindAll(Employee employees) {
        return empRepository.findAll();
    }

    @Override
    public List<Employee> ageFindByAfter(int age) {
        return empRepository.findByAgeAfter(age);
    }

    @Override
    public List<Employee> ageFindByBetween(int miniAge, int maxiAge) {
        return empRepository.findByAgeBetween(miniAge, maxiAge);
    }

//***************************************************************************************
@Override
public Employee updateEmployees(Employee employees, Long employeeId) {
      Employee employees1=  empRepository.findById(employeeId)
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
    public JobDepartment updateJobDepartment(JobDepartment jobDepartment, Long jobDepartment_Id) {
       JobDepartment job=jobDepRepository.findById(jobDepartment_Id)
               .orElseThrow(() -> new ResponseNotFoundException("jobDepartment", "jobDepartment_Id", jobDepartment_Id));
       job.setDepartment(jobDepartment.getDepartment());
       job.setName(jobDepartment.getName());
       job.setDescription(jobDepartment.getDescription());
       job.setSalaryRange(jobDepartment.getSalaryRange());
       jobDepRepository.save(job);
        return job;
    }


    @Override
    public Payroll updatePayroll(Payroll payroll, Long payrollId) {
        Payroll pay=payrollRepository.findById(payrollId)
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
    public ResponseEntity<Employee> deleteById(Long employeeId) {
        Employee entityDeletion=empRepository.findById(employeeId)
                .orElseThrow(() -> new ResponseNotFoundException("employees", "employeeId", employeeId));
        empRepository.deleteById(employeeId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


}
