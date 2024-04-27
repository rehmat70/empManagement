package com.employees.managment.rController;
import com.employees.managment.Entities.employees;
import com.employees.managment.Entities.jobDepartment;
import com.employees.managment.entityRepository.empRepository;
import com.employees.managment.entityRepository.jobDepRepository;
import com.employees.managment.serviceRepositoy.ServiceDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/employ")
public class empController {
    @Autowired
    private final ServiceDao serviceDao;

    public empController(ServiceDao serviceDao, jobDepRepository jobDepRepository) {

        this.serviceDao = serviceDao;
    }

    @PostMapping("/save")
    public employees saveSingleEntity(@RequestBody employees employee){

        return serviceDao.saveEntity(employee);
    }

//    @PostMapping("/save")
//    public ResponseEntity<employees> saveEmployee(@RequestBody employees employee) {
//        jobDepartment department = employee.getJobDepartment();
//        if (department != null && department.getJobDepartment_Id() == null) {
//            // Save the department first if it doesn't exist already
//            department = jobDepRepository.save(department);
//        }
//        // Set the department in the employee
//        employee.setJobDepartment(department);
//        // Save the employee
//        employees savedEmployee = empRepository.save(employee);
//        return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
//    }
//}
    @PostMapping("/save/All")
    public List<employees> saveAllEntities(@RequestBody List<employees> employees){
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
    public ResponseEntity<employees> employeeFindById(@PathVariable("Id") Long employee_Id){
        return new ResponseEntity<employees>(serviceDao.employeeFindById(employee_Id), HttpStatus.OK);
    }

    @GetMapping("/get/allEmployees")
    public List<employees> employeeFindAll(employees employees){
        return serviceDao.employeeFindAll(employees);
    }
    @GetMapping("/get/ageAfter")
    public ResponseEntity<List<employees>> ageAfter(@RequestParam int age){
        return new ResponseEntity<>(serviceDao.ageFindByAfter(age), HttpStatus.OK);
    }
    @GetMapping("/get/ageBetween")
    public ResponseEntity<List<employees>> ageBetween(@RequestParam int miniAge, int maxiAge){
        return new ResponseEntity<>(serviceDao.ageFindByBetween(miniAge, maxiAge), HttpStatus.OK);
    }

    //********************************************************************************
    @PutMapping("/update/{id}")
    public ResponseEntity<employees> updateEmployee(@RequestBody employees employees, @PathVariable("id") Long employeeId){
        return new ResponseEntity<employees>
                (serviceDao.updateEmployees(employees,employeeId), HttpStatus.OK);

    }

    //*******************************************************************************
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<employees> deleteByIdMethod(@PathVariable("id") Long employeeId){

        return new ResponseEntity<employees>(serviceDao.deleteById(employeeId).getBody(), HttpStatus.OK);
    }
}
