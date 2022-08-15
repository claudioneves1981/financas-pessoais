package com.claudio.financaspessoais.services.contracts;

import com.claudio.financaspessoais.services.entities.Lancamentos;
import com.claudio.financaspessoais.services.exceptions.LancamentoInexistenteException;

import java.util.List;

public interface LancamentosService {

    Lancamentos salvarLancamento(Lancamentos lancamento) throws Exception;

    List<Lancamentos> buscaPorCategoria(String lancamento, String categoria, String subcategoria) throws LancamentoInexistenteException;

}
