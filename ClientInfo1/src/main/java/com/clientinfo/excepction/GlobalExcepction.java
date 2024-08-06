package com.clientinfo.excepction;
//
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.ExceptionHandler;
//
//public class GlobalExcepction {
//	@ExceptionHandler(IdNotFoundException.class)
//	public ResponseEntity<String>handleIdnotFoundException(IdNotFoundException ex){
//		return new ResponseEntity<>(ex.getMessage(),HttpStatus.NOT_FOUND);
//	}
//}

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExcepction {

    // Exception handler for IdNotFoundException
    @ExceptionHandler(IdNotFoundException.class)
    public ResponseEntity<String> handleIdNotFoundException(IdNotFoundException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }
    
    // You can add more exception handlers here for other types of exceptions
}
