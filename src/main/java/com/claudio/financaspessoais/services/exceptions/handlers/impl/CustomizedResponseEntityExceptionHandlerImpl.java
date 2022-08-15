package com.claudio.financaspessoais.services.exceptions.handlers.impl;

import com.claudio.financaspessoais.services.exceptions.LancamentoInexistenteException;
import com.claudio.financaspessoais.services.exceptions.handlers.CustomizedResponseEntityExceptionHandler;
import com.claudio.financaspessoais.services.exceptions.response.ExceptionResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

import java.util.Date;

@ControllerAdvice
@RestController
public class CustomizedResponseEntityExceptionHandlerImpl implements CustomizedResponseEntityExceptionHandler {

    @ExceptionHandler({
            LancamentoInexistenteException.class,
    })
    public ResponseEntity<ExceptionResponse> handleNotFoundException(Exception ex, WebRequest request) {
        ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(), ex.getMessage(),
                request.getDescription(false), HttpStatus.NOT_FOUND.getReasonPhrase());

        return new ResponseEntity<>(exceptionResponse, HttpStatus.NOT_FOUND);
    }
}

