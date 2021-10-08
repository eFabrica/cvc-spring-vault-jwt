package br.com.service.doit.controller;

import javax.servlet.http.HttpServletResponse;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import br.com.service.doit.security.JWTUtil;
import br.com.service.doit.security.UserSS;
import br.com.service.doit.service.UserService;

@RestController
@CrossOrigin
@RequestMapping("/v1/autentication")
@RequiredArgsConstructor
public class AutenticationController {

	private final JWTUtil jwtUtil;

	@Value("${cvc.url.elk}")
	private String elkUrl;


	@Value("${cvc.url.vault}")
	private String vaultUrl;


	@GetMapping("/url_desprotegida")
	public ResponseEntity<String> teste() {
		return ResponseEntity.ok("URL EXPOSTA SEM PRECISAR AUTENTICAR, NAO E NECESSARIO O TOKEN");
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
	public ResponseEntity<String> disṕlayUrlprotegida() {
		return ResponseEntity.ok("VOCE ACESSOU ESSE RECURSO UTILIZANDO O TOKEN");
	}


	@PostMapping("/elk")
	public ResponseEntity<String> displayElkUrl() {

		return ResponseEntity.ok(elkUrl);
	}



	@PostMapping("/vault")
	public ResponseEntity<String> displayVaultUrl() {

		return ResponseEntity.ok(vaultUrl);
	}


	@PreAuthorize("hasRole('ADMIN')")
	@RequestMapping(value="/adminping", method = RequestMethod.GET)
	public String adminPing(){
		return "Only Admins Can Read This";
	}



	@PreAuthorize("hasRole('USER')")
	@RequestMapping(value="/userping", method = RequestMethod.GET)
	public String userPing(){
		return "Any User Can Read This";
	}


}
