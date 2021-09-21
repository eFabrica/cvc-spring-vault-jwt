package br.com.service.doit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.service.doit.component.App1;
import br.com.service.doit.service.VaultService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.Authorization;

@RestController
@RequestMapping("/v1/autenticacao")
public class VaultController {

	@Autowired
	private VaultService vaultService;

	@ApiOperation(value = "Busca user/pwd App1", authorizations = { @Authorization(value = "OAuth2") })
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Chamada realizada com sucesso"),
			@ApiResponse(code = 401, message = "Acesso não autorizado"),
			@ApiResponse(code = 500, message = "Erro desconhecido") })
	@GetMapping(value = "/application1")
	@ResponseStatus(HttpStatus.OK)
	public App1 retornoApp1() {
		return vaultService.returnoApp1();
	}
}