package br.com.service.doit.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import java.io.Serializable;


@Data
@AllArgsConstructor
public class CredenciaisDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    public CredenciaisDTO() {
    }

    private String username;
    private String password;

}

