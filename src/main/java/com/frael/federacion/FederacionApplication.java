package com.frael.federacion;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.frael.federacion")
public class FederacionApplication {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SpringApplication.run(FederacionApplication.class, args);
	}

}
