package br.com.service.doit.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Service;

import br.com.service.doit.component.App1;

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

}
