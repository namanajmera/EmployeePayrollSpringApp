package com.naman.employeepayrollapp.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.ToString;

import javax.validation.constraints.*;
import java.time.LocalDate;
import java.util.List;
import java.util.Locale;

public @ToString
class EmployeePayrollDTO {

    @Pattern(regexp = "^[A-Z]{1}[a-zA-Z\\s]{2,}$",message = "Employee name Invalid")
    public String name;

    @Min(value = 500, message = "Min Wage Should Be more Than 500")
    public long salary;

    @Pattern(regexp = "male|female", message = "Gender need to be male or female")
    public String gender;

    @JsonFormat(pattern = "dd MM yyyy")
    @NotNull(message = "startDate should not be Empty")
    @PastOrPresent(message = "startDate should be past or today date")
    public LocalDate startDate;

    @NotBlank(message = "Note Should Not Be Empty")
    public String note;

    @NotBlank(message = "Profile pic should not be empty")
    public String profilePic;

    @NotNull(message = "department should not be empty")
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
