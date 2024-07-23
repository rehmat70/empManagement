package com.employee.management.controller;

import com.employee.management.serviceRepositoy.ServiceDao;
import com.employee.management.entities.Payroll;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/payroll")
@RequiredArgsConstructor
public class PayrollController {
    @Autowired
    private final ServiceDao serviceDao;
    //*****************************************************************************
    @PostMapping("/savePay")
    public Payroll savePayroll(@RequestBody Payroll payroll){

        return serviceDao.savepayroll(payroll);
    }
    //******************************************************************************
    @GetMapping("/get/{id}")

    public ResponseEntity<Payroll> payrollFindById(@PathVariable("id") Long payrollId){
      //return serviceDao.payrollFindById(payrollId);
        return new ResponseEntity<>(serviceDao.payrollFindById(payrollId), HttpStatus.OK);
    }
    //*****************************************************************************
    @PutMapping("/updatePayroll/{id}")
    public ResponseEntity<Payroll> updatePayroll(@PathVariable("id") Long payrollId, @RequestBody Payroll payroll){
        return new ResponseEntity<>(serviceDao.updatePayroll(payroll, payrollId), HttpStatus.OK);
    }

}
