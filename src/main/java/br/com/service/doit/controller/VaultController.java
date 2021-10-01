package br.com.service.doit.controller;

import br.com.service.doit.security.JWTUtil;
import br.com.service.doit.security.UserSS;
import br.com.service.doit.service.UserService;
import br.com.service.doit.service.VaultService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.http.HttpServletResponse;


@RestController
@CrossOrigin
@Slf4j
public class VaultController {

	@Autowired
	private VaultService vaultService;


	@Autowired
	private JWTUtil jwtUtil;


	@RequestMapping(value = "/teste",method = RequestMethod.POST)
    public ResponseEntity<String> teste() {

	return ResponseEntity.ok("URL EXPOSTA SEM PRECISA AUTENTICAR, NAO E NECESSARIO O TOKEN");

	}

	@RequestMapping(value="/refresh_token",method=RequestMethod.POST)
	public ResponseEntity<Void> refreshToke(HttpServletResponse response) {

		UserSS user = UserService.authenticated();

		String token = jwtUtil.generateToken(user.getUsername());

		response.addHeader("Authorization", "Bearer " + token);
		response.addHeader("access-control-expose-headers", "Authorization");

		return ResponseEntity.noContent().build();

	}


	@RequestMapping(value = "/url_protegida", method = RequestMethod.POST)
	public ResponseEntity<String> createAuthenticationToken( ) {

	 log.info("username: " + this.vaultService.returnoApp1().login);
	 log.info("password: " + this.vaultService.returnoApp1().password);

	 return ResponseEntity.ok("VOCE ACESSOU ESSE RECURSO UTILIZANDO O TOKEN");

	}


}