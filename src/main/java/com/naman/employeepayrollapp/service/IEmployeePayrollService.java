package com.naman.employeepayrollapp.service;

import com.naman.employeepayrollapp.dto.EmployeePayrollDTO;
import com.naman.employeepayrollapp.model.EmployeePayrollData;

import java.util.List;

public interface IEmployeePayrollService {

    List<EmployeePayrollData> getEmployeePayrollDataList();

    EmployeePayrollData getEmployeePayrollDataById(int empId);

    List<EmployeePayrollData> getEmployeesByDepartment(String department);

    List<EmployeePayrollData> getEmployeePayrollByKeywordName(String keyword);

    EmployeePayrollData createEmployeePayrollData(EmployeePayrollDTO employeePayrollDTO);

    EmployeePayrollData updateEmployeePayrollData(int empId,EmployeePayrollDTO employeePayrollDTO);

    void deleteEmployeePayrollData(int empId);
}
