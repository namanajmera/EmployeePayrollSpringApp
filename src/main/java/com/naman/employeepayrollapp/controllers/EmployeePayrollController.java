package com.naman.employeepayrollapp.controllers;

import com.naman.employeepayrollapp.dto.EmployeePayrollDTO;
import com.naman.employeepayrollapp.dto.ResponseDTO;
import com.naman.employeepayrollapp.model.EmployeePayrollData;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employeepayroll")
public class EmployeePayrollController {

    //    Get All Data
    @RequestMapping(value = {"", "/", "/getAll"})
    public ResponseEntity<ResponseDTO> getEmployeeData() {
        EmployeePayrollData employeePayrollData = new EmployeePayrollData(1, new EmployeePayrollDTO("Naman", 1000000));
        ResponseDTO responseDTO = new ResponseDTO("Get Call Success", employeePayrollData);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    //    Get Particular Data
    @GetMapping("/get/{empId}")
    public ResponseEntity<ResponseDTO> getEmployeePayrollData(@PathVariable("empId") int empId) {
        EmployeePayrollData employeePayrollData = new EmployeePayrollData(empId, new EmployeePayrollDTO("Naman", 1000000));
        ResponseDTO responseDTO = new ResponseDTO("Get Call By ID", employeePayrollData);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    //    Post Call
    @PostMapping("/post/create")
    public ResponseEntity<ResponseDTO> addEmployeePayrollData(@RequestBody EmployeePayrollDTO employeePayrollDTO) {
        EmployeePayrollData employeePayrollData = new EmployeePayrollData(1, employeePayrollDTO);
        ResponseDTO responseDTO = new ResponseDTO("Successfully Created Employee", employeePayrollData);
        return new ResponseEntity<>(responseDTO, HttpStatus.CREATED);
    }

    //    Put Call
    @PutMapping("/put/update")
    public ResponseEntity<ResponseDTO> updateEmployeePayrollData(@RequestBody EmployeePayrollDTO employeePayrollDTO) {
        EmployeePayrollData employeePayrollData = new EmployeePayrollData(1, employeePayrollDTO);
        ResponseDTO responseDTO = new ResponseDTO("Updated successfully", employeePayrollData);
        return new ResponseEntity<>(responseDTO, HttpStatus.CREATED);
    }
    //    Put Call with ID
    @PutMapping("/put/update/{empId}")
    public ResponseEntity<ResponseDTO> updateEmployeePayrollData(@PathVariable("empId") int empId,@RequestBody EmployeePayrollDTO employeePayrollDTO) {
        EmployeePayrollData employeePayrollData = new EmployeePayrollData(empId, employeePayrollDTO);
        ResponseDTO responseDTO = new ResponseDTO("Updated successfully", employeePayrollData);
        return new ResponseEntity<>(responseDTO, HttpStatus.CREATED);
    }

    //    Delete Call
    @DeleteMapping("/delete/{empId}")
    public ResponseEntity<ResponseDTO> deleteEmployeePayrollData(@PathVariable("empId") int empid) {
        EmployeePayrollData employeePayrollData = new EmployeePayrollData(empid, new EmployeePayrollDTO("Naman", 123213));
        ResponseDTO responseDTO = new ResponseDTO("Deleted Successfully", employeePayrollData);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }
}
