package com.naman.employeepayrollapp.dto;

import lombok.ToString;

import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;
import java.util.List;

public @ToString
class EmployeePayrollDTO {

    @Pattern(regexp = "^[A-Z]{1}[a-zA-Z\\s]{2,}$",message = "Employee name Invalid")
    public String name;

    @Min(value = 500, message = "Min Wage Should Be more Than 500")
    public long salary;

    public String gender;
    public String startDate;
    public String note;
    public String profilePic;
    public List<String> departments;

    public EmployeePayrollDTO(String name, long salary) {
        this.name = name;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "EmployeePayrollDTO{" +
                "name='" + name + '\'' +
                ", salary=" + salary +
                '}';
    }
}
