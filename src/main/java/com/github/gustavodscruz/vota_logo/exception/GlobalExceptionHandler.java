package com.github.gustavodscruz.vota_logo.exception;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(FieldException.class)
    public ResponseEntity<ErrorResponse> handleFieldException(FieldException ex) {
        BindingResult bindingResult = ex.getBindingResult();
        
        if (!bindingResult.hasFieldErrors()) {
            return ResponseEntity.badRequest().body(
                    new ErrorResponse(
                            ex.getMessage(),
                            null,
                            LocalDateTime.now()));
        }

        Map<String, String> errors = bindingResult.getFieldErrors().stream()
                .collect(Collectors.toMap(
                        FieldError::getField,
                        FieldError::getDefaultMessage));

        return ResponseEntity.badRequest().body(
                new ErrorResponse(
                        ex.getMessage(),
                        errors,
                        LocalDateTime.now()));
    }
}
