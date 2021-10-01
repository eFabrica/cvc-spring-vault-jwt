package br.com.service.doit.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
@AllArgsConstructor
public class CredenciaisDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    public CredenciaisDTO() {
    }


    //o email e username
    private String email;
    private String senha;

}
