package com.naman.employeepayrollapp.controllers;

import com.naman.employeepayrollapp.dto.EmployeePayrollDTO;
import com.naman.employeepayrollapp.dto.ResponseDTO;
import com.naman.employeepayrollapp.model.EmployeePayrollData;
import com.naman.employeepayrollapp.service.IEmployeePayrollService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employeepayroll")
public class EmployeePayrollController {

    @Autowired
    IEmployeePayrollService iEmployeePayrollService;

    //    Get All Data
    @RequestMapping(value = {"", "/", "/getAll"})
    public ResponseEntity<ResponseDTO> getEmployeeData() {
        List<EmployeePayrollData> employeePayrollDataList=iEmployeePayrollService.getEmployeePayrollDataList();
        ResponseDTO responseDTO = new ResponseDTO("Get Call Success", employeePayrollDataList);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    //    Get Particular Data
    @GetMapping("/get/{empId}")
    public ResponseEntity<ResponseDTO> getEmployeePayrollData(@PathVariable("empId") int empId) {
        EmployeePayrollData employeePayrollData=iEmployeePayrollService.getEmployeePayrollDataById(empId);
        ResponseDTO responseDTO = new ResponseDTO("Get Call By ID", employeePayrollData);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    //    Post Call
    @PostMapping("/post/create")
    public ResponseEntity<ResponseDTO> addEmployeePayrollData(@RequestBody EmployeePayrollDTO employeePayrollDTO) {
        EmployeePayrollData employeePayrollData=iEmployeePayrollService.createEmployeePayrollData(employeePayrollDTO);
        ResponseDTO responseDTO = new ResponseDTO("Successfully Created Employee", employeePayrollData);
        return new ResponseEntity<>(responseDTO, HttpStatus.CREATED);
    }

    //    Put Call with ID
    @PutMapping("/put/update/{empId}")
    public ResponseEntity<ResponseDTO> updateEmployeePayrollData(@PathVariable("empId") int empId,@RequestBody EmployeePayrollDTO employeePayrollDTO) {
        EmployeePayrollData employeePayrollData=iEmployeePayrollService.updateEmployeePayrollData(empId,employeePayrollDTO);
        ResponseDTO responseDTO = new ResponseDTO("Updated successfully", employeePayrollData);
        return new ResponseEntity<>(responseDTO, HttpStatus.CREATED);
    }

    //    Delete Call
    @DeleteMapping("/delete/{empId}")
    public ResponseEntity<ResponseDTO> deleteEmployeePayrollData(@PathVariable("empId") int empid) {
        iEmployeePayrollService.deleteEmployeePayrollData(empid);
        ResponseDTO responseDTO = new ResponseDTO("Deleted Successfully", empid);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }
}
