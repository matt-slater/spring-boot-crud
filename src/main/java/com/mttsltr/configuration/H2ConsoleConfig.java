package com.mttsltr.configuration;


import org.h2.server.web.WebServlet;
import org.springframework.boot.context.embedded.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class H2ConsoleConfig {
	@Bean
	ServletRegistrationBean h2serveltRegistration() {
		ServletRegistrationBean regBean = new ServletRegistrationBean(new WebServlet());
		regBean.addUrlMappings("/console/*");
		return regBean;
	}

}
