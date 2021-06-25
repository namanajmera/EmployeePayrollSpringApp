package com.naman.employeepayrollapp.model;

import com.naman.employeepayrollapp.dto.EmployeePayrollDTO;

import java.time.LocalDate;
import java.util.List;

public class EmployeePayrollData {
    private int empId;
    private String name;
    private long salary;
    public String gender;
    public LocalDate startDate;
    public String note;
    public String profilePic;
    public List<String> departments;

    public EmployeePayrollData() {
    }

    public EmployeePayrollData(int empId, EmployeePayrollDTO employeePayrollDTO) {
        this.empId = empId;
        this.name = employeePayrollDTO.name;
        this.salary = employeePayrollDTO.salary;
        this.gender= employeePayrollDTO.gender;
        this.startDate= employeePayrollDTO.startDate;
        this.note= employeePayrollDTO.note;
        this.profilePic= employeePayrollDTO.profilePic;
        this.departments= employeePayrollDTO.departments;
    }

    public int getEmpId() {
        return empId;
    }

    public void setEmpId(int empId) {
        this.empId = empId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getSalary() {
        return salary;
    }

    public void setSalary(long salary) {
        this.salary = salary;
    }
}
