package br.com.service.doit.controller;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.service.doit.security.JWTUtil;
import br.com.service.doit.security.UserSS;
import br.com.service.doit.service.UserService;

@RestController
@CrossOrigin
@RequestMapping("/v1/autentication")
public class AutenticationController {

	@Autowired
	private JWTUtil jwtUtil;

	@GetMapping("/teste")
	public ResponseEntity<String> teste() {
		return ResponseEntity.ok("URL EXPOSTA SEM PRECISA AUTENTICAR, NAO E NECESSARIO O TOKEN");
	}

	@PostMapping("/refresh_token")
	public ResponseEntity<Void> refreshToke(HttpServletResponse response) {

		UserSS user = UserService.authenticated();
		String token = jwtUtil.generateToken(user.getUsername());

		response.addHeader("Authorization", "Bearer " + token);
		response.addHeader("access-control-expose-headers", "Authorization");

		return ResponseEntity.noContent().build();

	}

	@PostMapping("/url_protegida")
	public ResponseEntity<String> createAuthenticationToken() {
		return ResponseEntity.ok("VOCE ACESSOU ESSE RECURSO UTILIZANDO O TOKEN");
	}

}
