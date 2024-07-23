package com.employee.management.controller;
import com.employee.management.serviceRepositoy.ServiceDao;
import com.employee.management.entities.JobDepartment;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/depArtMen")
@RequiredArgsConstructor
public class JobDepartmentController {

    private final ServiceDao serviceDao;
    @PostMapping("/saveDepartment")
    public JobDepartment saveSingleEntity(@RequestBody JobDepartment jobDepartments){
        return serviceDao.addEntity(jobDepartments);
    }
    @GetMapping("/getJobDepartment/{id}")
    public ResponseEntity<JobDepartment> jobDepartmentFindById(@PathVariable("id") Long jobDepartment_Id){
        return new ResponseEntity<>(serviceDao.jobDepartmentFindById(jobDepartment_Id), HttpStatus.OK);
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<JobDepartment> updateDepartmentEntity(@PathVariable("id") Long jobDepartment_ID, @RequestBody JobDepartment jobDepartment){
        return new ResponseEntity<>(serviceDao.updateJobDepartment(jobDepartment, jobDepartment_ID), HttpStatus.OK);
    }

}
