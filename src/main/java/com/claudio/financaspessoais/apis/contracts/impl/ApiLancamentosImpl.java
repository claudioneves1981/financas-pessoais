package com.claudio.financaspessoais.apis.contracts.impl;

import com.claudio.financaspessoais.adapters.lancamentos.LancamentosAPIAdapter;
import com.claudio.financaspessoais.adapters.lancamentos.LancamentosAPIServiceAdapter;
import com.claudio.financaspessoais.apis.contracts.ApiLancamentos;
import com.claudio.financaspessoais.apis.entities.LancamentosAPI;
import com.claudio.financaspessoais.services.contracts.LancamentosService;
import com.claudio.financaspessoais.services.entities.Lancamentos;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(path="/api/v1/lancamentos")
@AllArgsConstructor(onConstructor = @__(@Autowired))
@CrossOrigin(origins = "http://localhost:8080")
public class ApiLancamentosImpl implements ApiLancamentos {

    private LancamentosService lancamentosService;

    @PostMapping(value = "/salvarlancamentos")
    @Override
    @ResponseStatus(HttpStatus.OK)
    public LancamentosAPI salvarLancamentos(@RequestBody @Valid LancamentosAPI lancamentosAPI) throws Exception {

        LancamentosAPIServiceAdapter adapter = new LancamentosAPIServiceAdapter(lancamentosAPI);
        lancamentosService.salvarLancamento(adapter.getLancamentoAPI());
        return lancamentosAPI;


    }

    @GetMapping(value = "/{lancamento}/{categoria}/{subcategoria}")
    @Override
    public List<LancamentosAPI> lancamentoPorCategoria(@PathVariable String lancamento, @PathVariable String categoria, @PathVariable String subcategoria) throws Exception {

        List<Lancamentos> lancamentos = lancamentosService.buscaPorCategoria(lancamento, categoria, subcategoria);
        return new LancamentosAPIAdapter(lancamentos).getLancamentosAPI();

    }

}
