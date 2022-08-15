package com.claudio.financaspessoais.apis.entities;


import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LancamentosAPI {

    private Long idLancamento;


    @NotNull
    private String tipoLancamento;

    @NotNull
    private LocalDate data;

    @NotNull
    private String categoria;

    @NotNull
    private String subCategoria;

    private String formaPagamento;

    @NotNull
    private Double valor;

}
