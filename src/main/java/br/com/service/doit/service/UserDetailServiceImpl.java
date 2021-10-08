package br.com.service.doit.service;

import br.com.service.doit.security.Authority;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import br.com.service.doit.security.UserSS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

@Service
@Slf4j
public class UserDetailServiceImpl implements UserDetailsService {


    /*
      HARD CODE DOS DADOS ABAIXO, DEPOIS E SO PLUGAR O DATABASE AQUI
      FALTA AUTORITY COM ROOLES SETEI COMO NULL
    */

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

     BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
     String senha = bCryptPasswordEncoder.encode("cvcpwd12");

     Authority authority = new Authority("ROLE_ADMIN");
     List<GrantedAuthority> listAuthorities = new ArrayList<GrantedAuthority>();
     listAuthorities.add(authority);

     log.info( "Autority " + listAuthorities.get(0).getAuthority());

     //DADOS MOCADOS PLUGAR DATABASE AQUI
     UserSS userSS = new UserSS(1,"cvc@cvc.com.br","cvcuser",senha, listAuthorities);

     return userSS;

    }


}
