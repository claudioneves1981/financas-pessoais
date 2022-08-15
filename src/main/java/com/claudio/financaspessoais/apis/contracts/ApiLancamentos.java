package com.claudio.financaspessoais.apis.contracts;

import com.claudio.financaspessoais.apis.entities.LancamentosAPI;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import java.util.List;

public interface ApiLancamentos {

    @ApiOperation(value = "Salva um Lancamento")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Retorna uma mensagem se salvou o valor"),
            @ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
            @ApiResponse(code = 406, message = "Quando uma regra for quebrada"),
            @ApiResponse(code = 500, message = "Retornará uma mensagem amigável para o usuário"),
    })
    LancamentosAPI salvarLancamentos(LancamentosAPI novoLancamento) throws Exception;


    @ApiOperation(value = "Mostra um lançamento pela categoria")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Retorna lancamento"),
            @ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
            @ApiResponse(code = 500, message = "Retornará uma mensagem amigável para o usuário"),
    })
    List<LancamentosAPI> lancamentoPorCategoria(String lancamento, String categoria, String subcategoria) throws Exception;

}
