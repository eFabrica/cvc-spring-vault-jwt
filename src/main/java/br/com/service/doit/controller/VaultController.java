package br.com.service.doit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.service.doit.component.SecretVaultCVC;
import br.com.service.doit.service.VaultService;


@RestController
@CrossOrigin
@RequestMapping("/v1/vault")
public class VaultController {

	@Autowired
	private VaultService vaultService;

	@GetMapping("/buscar")
	public SecretVaultCVC buscar() {		
		 return vaultService.buscaUser();
		}
	
	@PostMapping("/consultar")	
	public SecretVaultCVC consutar(String username, String password ) {		
	 return vaultService.consultarUserPass(username, password);
	}
	
	


}