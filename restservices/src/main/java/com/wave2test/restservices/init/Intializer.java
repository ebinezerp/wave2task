package com.wave2test.restservices.init;

import javax.servlet.Filter;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import com.wave2test.restservices.config.WebMvcConfig;
import com.wave2test.restservices.filter.CORSFilter;

public class Intializer extends AbstractAnnotationConfigDispatcherServletInitializer{

	@Override
	protected Class<?>[] getRootConfigClasses() {
		// TODO Auto-generated method stub
		return new Class[]{WebMvcConfig.class,WebMvcConfig.class};
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected String[] getServletMappings() {
		// TODO Auto-generated method stub
		return new String[]{"/"};
	}
	
	
	@Override
	protected Filter[] getServletFilters() {
		// TODO Auto-generated method stub
		return new Filter[]{new CORSFilter()};
	}
	

}
