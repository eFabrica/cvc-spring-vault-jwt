package br.com.service.doit.component;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;

import lombok.Data;

@Data
@ConfigurationProperties
public class SecretVaultCVC {

    @Value("${username}")
    private String login;

    @Value("${password}")
    private String password;
    
}