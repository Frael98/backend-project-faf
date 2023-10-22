package com.frael.federacion;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@EnableWebMvc //Para indicarle a Spring que este proyecto es de tipo web/servicioRest (Controllers, Interceptors...)
@SpringBootApplication
@ComponentScan("com.frael.federacion")
public class FederacionApplication extends SpringBootServletInitializer { // se agrega SpringBootServletInitializer

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SpringApplication.run(FederacionApplication.class, args);
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(FederacionApplication.class);
	}

}
