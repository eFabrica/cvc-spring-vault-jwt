package br.com.service.doit.controller;

import br.com.service.doit.service.VaultService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
@CrossOrigin
@Slf4j
public class VaultController {

	@Autowired
	private VaultService vaultService;


	@RequestMapping(value = "/teste",method = RequestMethod.POST)
    public ResponseEntity<String> teste() {

	return ResponseEntity.ok("URL EXPOSTA SEM PRECISA AUTENTICAR");

	}


	@RequestMapping(value = "/refresh_token", method = RequestMethod.POST)
	public ResponseEntity<String> createAuthenticationToken( ) {

	 log.info("username: " + this.vaultService.returnoApp1().login);
	 log.info("password: " + this.vaultService.returnoApp1().password);

	 return ResponseEntity.ok("ESSA URL NECESSITA DO TOKEN PARA SER ACESSADA");

	}

}