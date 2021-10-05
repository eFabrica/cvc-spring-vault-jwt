package br.com.service.doit.security;

import lombok.AllArgsConstructor;
import lombok.ToString;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import java.util.Collection;

@AllArgsConstructor
@ToString
public class UserSS implements UserDetails {
	
	private static final long serialVersionUID = -9216681746294294148L;
	
	private Integer id;
    private String email;
    private String username;
    private String senha;
    private Collection<? extends GrantedAuthority> authorities;

    public Integer getId() {

        return this.id;

    }

    @Override
    public Collection <? extends GrantedAuthority> getAuthorities() {

     return this.authorities;

    }


    @Override
    public String getPassword() {

        return this.senha;

    }

    @Override
    public String getUsername() {

        return this.username;
    }


    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

}
