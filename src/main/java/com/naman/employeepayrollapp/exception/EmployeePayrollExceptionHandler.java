package com.naman.employeepayrollapp.exception;

import com.naman.employeepayrollapp.dto.ResponseDTO;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.List;
import java.util.stream.Collectors;

@ControllerAdvice
public class EmployeePayrollExceptionHandler {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ResponseDTO> handleMethodArgumentNotValidException(MethodArgumentNotValidException exception){
        List<ObjectError> errorsList=exception.getBindingResult().getAllErrors();
        List<String> errMsg=errorsList.stream().map(DefaultMessageSourceResolvable::getDefaultMessage).collect(Collectors.toList());
        ResponseDTO responseDTO=new ResponseDTO("Exception while Processing REST Request",errMsg);
        return new ResponseEntity<>(responseDTO, HttpStatus.BAD_REQUEST);
    }
}
