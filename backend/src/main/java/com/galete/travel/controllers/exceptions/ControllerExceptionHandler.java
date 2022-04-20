package com.galete.travel.controllers.exceptions;

import com.galete.travel.helpers.enums.ApplicationExceptionEnums;
import com.galete.travel.helpers.errors.ApplicationError;
import com.galete.travel.helpers.errors.ApplicationValidationError;
import com.galete.travel.services.exceptions.IntegrityViolationException;
import com.galete.travel.services.exceptions.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.time.Instant;

@ControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ApplicationError> resourceNotFoundException(ResourceNotFoundException ex, HttpServletRequest req) {
        ApplicationError applicationError = new ApplicationError();
        HttpStatus httpStatus = HttpStatus.NOT_FOUND;

        applicationError.setTimestamp(Instant.now());
        applicationError.setStatus(httpStatus.value());
        applicationError.setError("Resource not found");
        applicationError.setMessage(ex.getMessage());
        applicationError.setPath(req.getRequestURI());
        applicationError.setApplicationExceptionEnums(ex.getExceptionsServiceEnum());

        return ResponseEntity.status(httpStatus).body(applicationError);
    }

    @ExceptionHandler(IntegrityViolationException.class)
    public ResponseEntity<ApplicationError> integrityViolationException(IntegrityViolationException ex, HttpServletRequest req) {
        ApplicationError applicationError = new ApplicationError();
        HttpStatus httpStatus = HttpStatus.BAD_REQUEST;

        applicationError.setTimestamp(Instant.now());
        applicationError.setStatus(httpStatus.value());
        applicationError.setError("Bad request");
        applicationError.setMessage(ex.getMessage());
        applicationError.setPath(req.getRequestURI());
        applicationError.setApplicationExceptionEnums(ex.getExceptionsServiceEnum());

        return ResponseEntity.status(httpStatus).body(applicationError);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApplicationValidationError> methodArgumentNotValidException(MethodArgumentNotValidException ex, HttpServletRequest req) {
        ApplicationValidationError applicationValidationError = new ApplicationValidationError();
        HttpStatus httpStatus = HttpStatus.UNPROCESSABLE_ENTITY;

        applicationValidationError.setTimestamp(Instant.now());
        applicationValidationError.setStatus(httpStatus.value());
        applicationValidationError.setError("Validation exception");
        applicationValidationError.setMessage("");
        applicationValidationError.setPath(req.getRequestURI());
        applicationValidationError.setApplicationExceptionEnums(ApplicationExceptionEnums.VALIDATION_ERROR);

        for(FieldError fieldError : ex.getBindingResult().getFieldErrors()) {
            applicationValidationError.addFieldMessage(fieldError.getField(), fieldError.getDefaultMessage());
        }

        return ResponseEntity.status(httpStatus).body(applicationValidationError);
    }
}
