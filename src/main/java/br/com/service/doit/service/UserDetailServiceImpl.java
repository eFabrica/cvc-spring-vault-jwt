package br.com.service.doit.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import br.com.service.doit.security.UserSS;

@Service
public class UserDetailServiceImpl implements UserDetailsService {


    /*
      HARD CODE DOS DADOS ABAIXO, DEPOIS E SO PLUGAR O DATABASE AQUI
      FALTA AUTORITY COM ROOLES SETEI COMO NULL
    */

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

     BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
     String senha = bCryptPasswordEncoder.encode("cvcpwd12");


     //DADOS MOCADOS PLUGAR DATABASE AQUI
     UserSS userSS = new UserSS(1,"cvc@cvc.com.br","cvcuser",senha,null);

     return userSS;

    }


}
