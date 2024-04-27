package com.employees.managment.rController;

import com.employees.managment.Entities.payroll;
import com.employees.managment.serviceRepositoy.ServiceDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/payroll")
public class payrollController {
    @Autowired
    private ServiceDao serviceDao;
    //*****************************************************************************
    @PostMapping("/savePay")
    public payroll savePayroll(@RequestBody payroll payroll){

        return serviceDao.savepayroll(payroll);
    }
    //******************************************************************************
    @GetMapping("/get/{id}")

    public ResponseEntity<payroll> payrollFindById(@PathVariable("id") Long payrollId){
      //return serviceDao.payrollFindById(payrollId);
        return new ResponseEntity<payroll>(serviceDao.payrollFindById(payrollId), HttpStatus.OK);
    }
    //*****************************************************************************
    @PutMapping("/updatePayroll/{id}")
    public ResponseEntity<payroll> updatePayroll(@PathVariable("id") Long payrollId, @RequestBody payroll payroll){
        return new ResponseEntity<payroll>(serviceDao.updatePayroll(payroll, payrollId), HttpStatus.OK);
    }

}
