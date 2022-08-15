package com.claudio.financaspessoais.adapters.lancamentos;

import com.claudio.financaspessoais.db.entities.LancamentosEntity;
import com.claudio.financaspessoais.services.entities.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class LancamentosServiceAdapter {

    private Lancamentos lancamento;
    private List<Lancamentos> lancamentos;

    public LancamentosServiceAdapter(LancamentosEntity lancamentoEntity) {
        this.lancamento = convertLancamentoEntityEmLancamento(lancamentoEntity);
    }

    public LancamentosServiceAdapter(List<LancamentosEntity> lancamentosEntity) {
        this.lancamentos = convertListEntityEmListLancamento(lancamentosEntity);
    }


    private List<Lancamentos> convertListEntityEmListLancamento(List<LancamentosEntity> lancamentosEntityList) {
        lancamentos = new ArrayList<>();
        for (LancamentosEntity lancamentosEntity : lancamentosEntityList) {
            lancamentos.add(convertLancamentoEntityEmLancamento(lancamentosEntity));
        }
        return lancamentos;
    }

    private Lancamentos convertLancamentoEntityEmLancamento(LancamentosEntity lancamentoEntity) {
        return Lancamentos.builder()
                .tipoLancamento(lancamentoEntity.getTipo())
                .categoria(lancamentoEntity.getCategoria())
                .data(lancamentoEntity.getData())
                .id(lancamentoEntity.getId())
                .formaPagamento(lancamentoEntity.getFormaPagamento())
                .subCategoria(lancamentoEntity.getSubCategoria())
                .valor(lancamentoEntity.getValor())
                .build();
    }
}
