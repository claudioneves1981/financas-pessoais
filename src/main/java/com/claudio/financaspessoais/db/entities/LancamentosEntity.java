package com.claudio.financaspessoais.db.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.*;
import org.hibernate.annotations.Parameter;
import javax.persistence.*;
import javax.persistence.Entity;
import java.time.LocalDate;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@GenericGenerator(
        name = "SEQ_LANCAMENTO",
        strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
        parameters = {
                @Parameter(name = "sequence_name", value = "SEQ_LANCAMENTO"),
                @Parameter(name = "initial_value", value = "1"),
                @Parameter(name = "increment_size", value = "1")
        }
)
public class LancamentosEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ID_LANCAMENTO")
    private Long id;

    @Column(name="DT_DATA")
    private LocalDate data;

   // @Type(type = "javax.persistence.EnumType")
   // @Enumerated(EnumType.STRING)
    @Column(name="TIPO", nullable = false)
    private String tipo;

    //@Type(type = "javax.persistence.EnumType")
   // @Enumerated(EnumType.STRING)
    @Column(name = "CATEGORIA", nullable = false)
    private String categoria;

    //@Type(type = "javax.persistence.EnumType")
    //@Enumerated(EnumType.STRING)
    @Column(name = "SUB_CATEGORIA",nullable = false)
    private String subCategoria;

    @Column(name = "VL_VALOR", nullable = false)
    private Double valor;

    @Column(name = "FORMA_PAGAMENTO", nullable = false)
    private String formaPagamento;

}

