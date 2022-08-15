package com.claudio.financaspessoais.adapters.lancamentos;

import com.claudio.financaspessoais.apis.entities.*;
import com.claudio.financaspessoais.services.entities.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class LancamentosAPIAdapter {

    private LancamentosAPI lancamentoAPI;
    private List<LancamentosAPI> lancamentosAPI;

    public LancamentosAPIAdapter(Lancamentos lancamento) {
        lancamentoAPI = convertLancamentoParaLancamentoAPI(lancamento);
    }

    public LancamentosAPIAdapter(List<Lancamentos> lancamentos) {
        lancamentosAPI = convertListLancamentoParaListLancamentoAPI(lancamentos);
    }

    private List<LancamentosAPI> convertListLancamentoParaListLancamentoAPI(List<Lancamentos> lancamentos) {
        List<LancamentosAPI> lancamentosAPI = new ArrayList<>();
        for (Lancamentos lancamento : lancamentos) {
            lancamentosAPI.add(convertLancamentoParaLancamentoAPI(lancamento));
        }
        return lancamentosAPI;
    }

    private LancamentosAPI convertLancamentoParaLancamentoAPI(Lancamentos lancamento) {

        return LancamentosAPI.builder()
                .tipoLancamento(lancamento.getTipoLancamento())
                .categoria(lancamento.getCategoria())
                .data(lancamento.getData())
                .idLancamento(lancamento.getId())
                .formaPagamento(lancamento.getFormaPagamento())
                .subCategoria(lancamento.getSubCategoria())
                .valor(lancamento.getValor())
                .build();
    }
}