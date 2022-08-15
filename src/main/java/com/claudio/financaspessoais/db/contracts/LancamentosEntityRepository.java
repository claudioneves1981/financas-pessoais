package com.claudio.financaspessoais.db.contracts;

import com.claudio.financaspessoais.db.entities.LancamentosEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Repository
public interface LancamentosEntityRepository extends JpaRepository<LancamentosEntity, Long> {

    @Query(value = "select lancamento from LancamentosEntity lancamento" +
          // "   JOIN lancamento.tipo tipo" +
          // "   JOIN lancamento.categoria categoria" +
            // "   JOIN lancamento.subCategoria subcategoria")
            "   WHERE lancamento.tipo  = :lancamento" +
            "   AND  lancamento.categoria = :categoria" +
            "   AND  lancamento.subCategoria = :subcategoria")
    Optional<List<LancamentosEntity>> findByCategoria(@Valid @Param("lancamento") String lancamento, @Valid @Param("categoria") String categoria, @Valid @Param("subcategoria") String subCategoria);
}
