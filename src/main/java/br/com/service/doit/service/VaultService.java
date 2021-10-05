package br.com.service.doit.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import br.com.service.doit.component.SecretVaultCVC;
import br.com.service.doit.exception.CVCException;
import br.com.service.doit.util.Constants;

@Service
@EnableConfigurationProperties(SecretVaultCVC.class)
public class VaultService {

	@Autowired
	private SecretVaultCVC secretVaultCVC;

	public SecretVaultCVC consultarUserPass(String username, String password) {

		if (!username.equals(secretVaultCVC.getLogin()) && !password.equals(secretVaultCVC.getPassword())) {
			throw CVCException.builder().httpStatusCode(HttpStatus.NOT_FOUND).message(Constants.NOT_FOUND).build();
		}
		return secretVaultCVC;
	}

	public SecretVaultCVC buscaUser() {
		return this.secretVaultCVC;
	}

}
