package com.extc.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
@ComponentScan("com.extc")
@EnableWebMvc
@Configuration
public class WebMvcConfig {

	@Bean
	InternalResourceViewResolver myresolver(){
		InternalResourceViewResolver irv=new InternalResourceViewResolver();
		irv.setPrefix("/WEB-INF/pages/");
		irv.setSuffix(".jsp");
		return irv;
		
	}
}
