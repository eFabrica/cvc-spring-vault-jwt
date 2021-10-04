package br.com.service.doit.service;

import br.com.service.doit.component.App1;
import br.com.service.doit.security.UserSS;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


@Service
public class UserDetailServiceImpl implements UserDetailsService {

    @Autowired
    App1 app1;


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
