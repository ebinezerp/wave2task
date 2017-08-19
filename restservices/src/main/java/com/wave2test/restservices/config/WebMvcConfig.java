package com.wave2test.restservices.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@EnableWebMvc
@ComponentScan("com.wave2test")
public class WebMvcConfig extends WebMvcConfigurerAdapter {
	@Bean
	 public InternalResourceViewResolver viewResolver()
	 {
		 InternalResourceViewResolver viewResolver=new InternalResourceViewResolver("/WEB-INF/views/",".jsp");
		 return viewResolver;
		 
	 }
	 
	 
	
	

}
