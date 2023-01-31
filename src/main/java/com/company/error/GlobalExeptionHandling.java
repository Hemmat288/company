package com.company.error;

import com.company.model.ErrorResponse;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
public class GlobalExeptionHandling extends ResponseEntityExceptionHandler {



    @ExceptionHandler(Exception.class)

    public final ResponseEntity<Object> handleAllExceptions(Exception ex, WebRequest request) {
        List<String> details = new ArrayList<>();
        details.add(ex.getLocalizedMessage());
       ErrorResponse error = new ErrorResponse("Server Error",HttpStatus.INTERNAL_SERVER_ERROR.toString(), details);
        return new ResponseEntity(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }


//////////custom error

    @ExceptionHandler(RecordNotFoundException.class)
    public final ResponseEntity<Object> handleUserNotFoundException(RecordNotFoundException ex, WebRequest request) {
        List<String> details = new ArrayList<>();
        details.add(ex.getLocalizedMessage());
        ErrorResponse error = new ErrorResponse("Record Not Found",HttpStatus.NOT_FOUND.toString(), details);
        return new ResponseEntity(error, HttpStatus.NOT_FOUND);
    }

///////////for many error
     @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        List<String> details = new ArrayList<>();
        for(ObjectError error : ex.getBindingResult().getAllErrors()) {
            details.add(error.getDefaultMessage());
        }
        ErrorResponse error = new ErrorResponse("Validation Failed", HttpStatus.BAD_REQUEST.toString(),details);
        return new ResponseEntity(error, HttpStatus.BAD_REQUEST);
    }
}