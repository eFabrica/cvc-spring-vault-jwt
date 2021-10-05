package br.com.service.doit.component;

import org.springframework.boot.context.properties.ConfigurationProperties;

import lombok.Data;

@Data
@ConfigurationProperties
public class UserMock {
	
    private String login = "cvcuser14";

    private String password = "cvcpwd";

}
