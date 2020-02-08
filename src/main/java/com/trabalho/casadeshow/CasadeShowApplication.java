package com.trabalho.casadeshow;

import java.util.Locale;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.FixedLocaleResolver;


@SpringBootApplication
public class CasadeShowApplication {

	public static void main(String[] args) {
		SpringApplication.run(CasadeShowApplication.class, args);
	}
	
	@Bean
	
	public LocaleResolver localeResolver ( ) {
		return new FixedLocaleResolver(new Locale("pt","BR"));
		
	}

}
