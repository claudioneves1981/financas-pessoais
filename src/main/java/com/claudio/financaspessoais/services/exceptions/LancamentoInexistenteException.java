package com.claudio.financaspessoais.services.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class LancamentoInexistenteException extends Exception {


    public LancamentoInexistenteException() {
        super("Conta Inexistente");
    }
}
