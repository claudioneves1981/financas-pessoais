package com.claudio.financaspessoais.adapters.lancamentos;

import com.claudio.financaspessoais.apis.entities.LancamentosAPI;
import com.claudio.financaspessoais.services.entities.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class LancamentosAPIServiceAdapter {

    private List<Lancamentos> lancamentosAPI;
    private Lancamentos lancamentoAPI;

    public LancamentosAPIServiceAdapter(LancamentosAPI lancamentoAPI) {
        this.lancamentoAPI = convertLancamentosApiEmLancamentos(lancamentoAPI);
    }



    public LancamentosAPIServiceAdapter(List<LancamentosAPI> lancamentos) {
        this.lancamentosAPI = convertListAPIEmListLancamentos(lancamentos);
    }



    private List<Lancamentos> convertListAPIEmListLancamentos(List<LancamentosAPI> lancamentoAPIS) {

        lancamentosAPI = new ArrayList<>();
        for (LancamentosAPI lancamentoAPI : lancamentoAPIS) {
            lancamentosAPI.add(convertLancamentosApiEmLancamentos(lancamentoAPI));
        }
        return lancamentosAPI;
    }

    private Lancamentos convertLancamentosApiEmLancamentos(LancamentosAPI lancamentoApi) {


        return Lancamentos.builder()
                .tipoLancamento(lancamentoApi.getTipoLancamento())
                .categoria(lancamentoApi.getCategoria())
                .data(lancamentoApi.getData())
                .id(lancamentoApi.getIdLancamento())
                .formaPagamento(lancamentoApi.getFormaPagamento())
                .subCategoria(lancamentoApi.getSubCategoria())
                .valor(lancamentoApi.getValor())
                .build();
    }

}
