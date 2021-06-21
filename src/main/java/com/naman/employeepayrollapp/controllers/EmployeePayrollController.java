package com.naman.employeepayrollapp.controllers;

import com.naman.employeepayrollapp.dto.EmployeePayrollDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employeepayroll")
public class EmployeePayrollController {

//    Get All Data
    @RequestMapping(value = {"","/","/getAll"})
    public ResponseEntity<String> getEmployeeData(){
        return new ResponseEntity<>("Get Call Success",HttpStatus.OK);
    }

//    Get Particular Data
    @GetMapping("/get/{empId}")
    public ResponseEntity<String> getEmployeePayrollData(@PathVariable("empId") int empId){
        return new ResponseEntity<>("Get Call Success For id: "+empId,HttpStatus.OK);
    }

//    Post Call
    @PostMapping("/post/create")
    public ResponseEntity<String> addEmployeePayrollData(@RequestBody EmployeePayrollDTO employeePayrollDTO){
        return new ResponseEntity<>("Successfully Created Employee: "+employeePayrollDTO,HttpStatus.CREATED);
    }

//    Put Call
    @PutMapping("/put/update")
    public ResponseEntity<String> updateEmployeePayrollData(@RequestBody EmployeePayrollDTO employeePayrollDTO){
        return new ResponseEntity<>("Updated successfully: "+employeePayrollDTO,HttpStatus.CREATED);
    }

//    Delete Call
    @DeleteMapping("/delete/{empId}")
    public ResponseEntity<String> deleteEmployeePayrollData(@PathVariable("empId") int empid){
        return new ResponseEntity<>("Deleted Successfully: "+ empid,HttpStatus.OK);
    }
}
