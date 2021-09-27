package br.com.service.doit.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Service;

import br.com.service.doit.component.App1;
import br.com.service.doit.model.JwtRequest;

@Service
@EnableConfigurationProperties(App1.class)
public class VaultService {

	@Autowired
	App1 app1;

	public VaultService(App1 app1) {
		this.app1 = app1;
	}

	public App1 returnoApp1() {

		return app1;
	}


	public void verificaUserPass(String username, String password) throws Exception {
		
		if(username.equals(app1.getLogin()) && password.equals(app1.getPassword()) ) {
			
		}else {
			throw new Exception("INVALID_CREDENTIALS");
		}
		
		
	}

}
