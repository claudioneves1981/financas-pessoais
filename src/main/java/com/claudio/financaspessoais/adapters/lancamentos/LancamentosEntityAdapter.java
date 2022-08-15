package com.claudio.financaspessoais.adapters.lancamentos;

import com.claudio.financaspessoais.db.entities.*;
import com.claudio.financaspessoais.services.entities.Lancamentos;
import lombok.Data;

@Data
public class LancamentosEntityAdapter {

    private LancamentosEntity lancamentosEntity;

    public LancamentosEntityAdapter(Lancamentos lancamentos) {
        this.lancamentosEntity = converteLancamentoEmLancamentoEntity(lancamentos);
    }

    private LancamentosEntity converteLancamentoEmLancamentoEntity(Lancamentos lancamento) {

        return LancamentosEntity.builder()
                .tipo(lancamento.getTipoLancamento().toString())
                .categoria(lancamento.getCategoria().toString())
                .data(lancamento.getData())
                .id(lancamento.getId())
                .formaPagamento(lancamento.getFormaPagamento().toString())
                .subCategoria(lancamento.getSubCategoria().toString())
                .valor(lancamento.getValor())
                .build();
    }

}
