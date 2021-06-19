package com.purvesh.springboot.controller;

import com.purvesh.springboot.util.EntitiyHawk;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class CustomerRestExceptionHandler extends ResponseEntityExceptionHandler {

    @Override
    protected ResponseEntity handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        System.out.println("ex.getMessage() = " + ex.getMessage());
        System.out.println("ex.getBindingResult().getFieldError().getDefaultMessage() = " + ex.getBindingResult().getFieldError().getDefaultMessage());
        return new EntitiyHawk().genericSuccess(ex.getBindingResult().getFieldError().getDefaultMessage());
    }

    @ExceptionHandler
    public ResponseEntity handleException(RuntimeException ex, WebRequest webRequest) {
        System.out.println("CustomerRestExceptionHandler.handleException: " + ex.getMessage());
        return new EntitiyHawk().genericError(ex.getMessage());
    }
}
