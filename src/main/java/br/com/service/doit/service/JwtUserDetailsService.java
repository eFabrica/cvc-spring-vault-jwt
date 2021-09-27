package br.com.service.doit.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.com.service.doit.model.JwtRequest;

@Service
public class JwtUserDetailsService implements UserDetailsService {

	@Autowired
	private UserService userService;

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		br.com.service.doit.model.User user = userService.getByEmail(email);

//		if (user.getEmail().equals(email)) {
		return new User(email, user.getPassword(), new ArrayList<>());
//		} else {
//			throw new UsernameNotFoundException("User not found with email: " + email);
//		}
	}

	public UserDetails loadUserByUsername(JwtRequest authenticationRequest) {

		return new User(authenticationRequest.getUsername(), authenticationRequest.getPassword(), new ArrayList<>());
	}
}