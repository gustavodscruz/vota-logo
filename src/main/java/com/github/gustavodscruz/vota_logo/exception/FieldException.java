package com.github.gustavodscruz.vota_logo.exception;

import org.springframework.validation.BindingResult;

import lombok.Getter;

@Getter
public class FieldException extends RuntimeException {
    private BindingResult bindingResult;

    public FieldException(String message, BindingResult bindingResult) {
        super(message);
        this.bindingResult = bindingResult;
    }
}
