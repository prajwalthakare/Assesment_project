package com.extc.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;

import com.extc.entity.Empolyeesdetails;
import com.extc.entity.Managerdetails;

public class hibernate_config {
	@Autowired
	ApplicationContext context;
	
@Bean
	public LocalSessionFactoryBean sessionfactory(){
	System.out.println("HibernateConfiguration---getBean()");
	LocalSessionFactoryBean factorybean=new LocalSessionFactoryBean();
	factorybean.setConfigLocation(context.getResource("classpath:hibernate.cfg.xml"));
	factorybean.setAnnotatedClasses(Managerdetails.class,Empolyeesdetails.class);
	return factorybean;
	}

}
