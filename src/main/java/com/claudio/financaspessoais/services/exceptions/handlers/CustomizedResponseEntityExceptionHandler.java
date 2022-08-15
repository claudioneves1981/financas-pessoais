package com.claudio.financaspessoais.services.exceptions.handlers;

import com.claudio.financaspessoais.services.exceptions.response.ExceptionResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.context.request.WebRequest;

public interface CustomizedResponseEntityExceptionHandler {

    ResponseEntity<ExceptionResponse> handleNotFoundException(Exception ex, WebRequest request);
}
