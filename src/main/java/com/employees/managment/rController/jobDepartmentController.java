package com.employees.managment.rController;
import com.employees.managment.Entities.jobDepartment;
import com.employees.managment.serviceRepositoy.ServiceDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/depArtMen")
public class jobDepartmentController {

    private final ServiceDao serviceDao;

    public jobDepartmentController(ServiceDao serviceDao) {

        this.serviceDao = serviceDao;
    }

    @PostMapping("/saveDepartment")
    public jobDepartment saveSingleEntity(@RequestBody jobDepartment jobDepartments){
        return serviceDao.addEntity(jobDepartments);
    }
    @GetMapping("/getJobDepartment/{id}")
    public ResponseEntity<jobDepartment> jobDepartmentFindById(@PathVariable("id") Long jobDepartment_Id){
        return new ResponseEntity<jobDepartment>(serviceDao.jobDepartmentFindById(jobDepartment_Id), HttpStatus.OK);
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<jobDepartment> updateDepartmentEntity(@PathVariable("id") Long jobDepartment_ID, @RequestBody jobDepartment jobDepartment){
        return new ResponseEntity<jobDepartment>(serviceDao.updateJobDepartment(jobDepartment, jobDepartment_ID), HttpStatus.OK);
    }

}
