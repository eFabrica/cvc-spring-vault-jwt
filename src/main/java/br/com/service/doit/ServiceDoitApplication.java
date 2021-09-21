package br.com.service.doit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;

import br.com.service.doit.component.App1;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
@EnableSwagger2
@SpringBootApplication
@EnableConfigurationProperties(App1.class)
@ComponentScan(basePackages = { "br.com.service.doit", "br.com.service.doit.component",
		"br.com.service.doit.controller", "br.com.service.doit.service" })
public class ServiceDoitApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServiceDoitApplication.class, args);
	}

}
