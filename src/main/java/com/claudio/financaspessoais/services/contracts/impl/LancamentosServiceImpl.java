package com.claudio.financaspessoais.services.contracts.impl;

import com.claudio.financaspessoais.adapters.lancamentos.LancamentosEntityAdapter;
import com.claudio.financaspessoais.adapters.lancamentos.LancamentosServiceAdapter;
import com.claudio.financaspessoais.db.contracts.LancamentosEntityRepository;
import com.claudio.financaspessoais.db.entities.LancamentosEntity;
import com.claudio.financaspessoais.services.contracts.LancamentosService;
import com.claudio.financaspessoais.services.entities.Lancamentos;
import com.claudio.financaspessoais.services.exceptions.LancamentoInexistenteException;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class LancamentosServiceImpl implements LancamentosService {

    private final LancamentosEntityRepository lancamentosEntityRepository;
    private static LancamentosService instance;

    public static LancamentosService getInstance(LancamentosEntityRepository lancamentosEntityRepository) {
        if (instance == null) {
            instance = new LancamentosServiceImpl(lancamentosEntityRepository);
        }
        return instance;
    }

    @Override
    public Lancamentos salvarLancamento(Lancamentos lancamentos) {

        lancamentosEntityRepository.save(new LancamentosEntityAdapter(lancamentos).getLancamentosEntity());
        return new LancamentosServiceAdapter(new LancamentosEntityAdapter(lancamentos).getLancamentosEntity()).getLancamento();

    }

    @Override
    public List<Lancamentos> buscaPorCategoria(String lancamento, String categoria, String subcategoria) throws LancamentoInexistenteException {
        List<Lancamentos> listaLancamentos;
        List<LancamentosEntity> foundLancamentos = lancamentosEntityRepository.findByCategoria(lancamento, categoria, subcategoria).orElseThrow(LancamentoInexistenteException::new);
        if (!foundLancamentos.isEmpty()) {
            listaLancamentos = new LancamentosServiceAdapter(foundLancamentos).getLancamentos();
        } else {
            throw new LancamentoInexistenteException();
        }

        return listaLancamentos;
    }
}