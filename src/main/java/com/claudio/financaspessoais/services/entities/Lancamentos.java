package com.claudio.financaspessoais.services.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Lancamentos {

    private Long id;

    private LocalDate data;

    private String tipoLancamento;

    private String categoria;

    private String subCategoria;

    private String formaPagamento;

    private Double valor;

}
