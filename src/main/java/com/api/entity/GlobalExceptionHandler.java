package com.api.entity;


import com.api.exception.RecordNotFound;
import com.api.payload.ErrorDto;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.util.Date;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(RecordNotFound.class)
    public ResponseEntity <ErrorDto> resourceNotFound(
            RecordNotFound r,
            WebRequest request
    ){
        ErrorDto error= new ErrorDto(r.getMessage() , new Date() , request.getDescription(false));
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    }

