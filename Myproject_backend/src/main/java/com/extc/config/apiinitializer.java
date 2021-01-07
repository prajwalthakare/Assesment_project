package com.extc.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class apiinitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		// TODO Auto-generated method stub
		return new Class[] {WebMvcConfig.class,hibernate_config.class};
	}

	@Override
	protected String[] getServletMappings() {
		// TODO Auto-generated method stub
		String[] str=new String[1];
		str[0]="/";
		return str;
	}

}
