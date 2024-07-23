package com.employee.management.controller;

import com.employee.management.serviceRepositoy.ServiceDao;
import com.employee.management.entities.Employee;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/employ")
@RequiredArgsConstructor
public class EmpController {
    @Autowired
    private final ServiceDao serviceDao;

    @PostMapping("/save")
    public Employee saveSingleEntity(@RequestBody Employee employee){

        return serviceDao.saveEntity(employee);
    }

    @PostMapping("/save/All")
    public List<Employee> saveAllEntities(@RequestBody List<Employee> employees){
        return serviceDao.saveAllEntity(employees);
    }

    //***************************************************************************************/
    //method for create csrf Token
    @GetMapping("/csrf")
    public String getCsrfToken() {
        // Generate CSRF token
       String csrfToken = UUID.randomUUID().toString();

        // Return CSRF token in the response
        return csrfToken;
    }
    //***************************************************************************************/
    @GetMapping("/get/{Id}")
    public ResponseEntity<Employee> employeeFindById(@PathVariable("Id") Long employee_Id){
        return new ResponseEntity<>(serviceDao.employeeFindById(employee_Id), HttpStatus.OK);
    }

    @GetMapping("/get/allEmployees")
    public List<Employee> employeeFindAll(Employee employees){
        return serviceDao.employeeFindAll(employees);
    }
    @GetMapping("/get/ageAfter")
    public ResponseEntity<List<Employee>> ageAfter(@RequestParam int age){
        return new ResponseEntity<>(serviceDao.ageFindByAfter(age), HttpStatus.OK);
    }
    @GetMapping("/get/ageBetween")
    public ResponseEntity<List<Employee>> ageBetween(@RequestParam int miniAge, int maxiAge){
        return new ResponseEntity<>(serviceDao.ageFindByBetween(miniAge, maxiAge), HttpStatus.OK);
    }

    //********************************************************************************
    @PutMapping("/update/{id}")
    public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employees, @PathVariable("id") Long employeeId){
        return new ResponseEntity<>
                (serviceDao.updateEmployees(employees,employeeId), HttpStatus.OK);

    }

    //*******************************************************************************
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Employee> deleteByIdMethod(@PathVariable("id") Long employeeId){

        return new ResponseEntity<>(serviceDao.deleteById(employeeId).getBody(), HttpStatus.OK);
    }
}
