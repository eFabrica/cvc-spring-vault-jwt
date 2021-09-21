package br.com.service.doit.component;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;

import lombok.Data;

@Data
@ConfigurationProperties
public class App1 {

    @Value("${username}")
    public String login;

   @Value("${password}")
    public String password;
    
}