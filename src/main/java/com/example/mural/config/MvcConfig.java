package com.example.mural.config;

import java.util.Locale;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

@Configuration
public class MvcConfig {

	@Bean
	public LocaleResolver localeResolver() {
		var resolver = new SessionLocaleResolver();
		resolver.setDefaultLocale(new Locale("pt", "BR"));
		return resolver;
	}
}
