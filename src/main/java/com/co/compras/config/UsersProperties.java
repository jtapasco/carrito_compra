package com.co.compras.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

@Configuration
@PropertySource("classpath:users.properties")
public class UsersProperties {
	
    @Autowired 
    private Environment env; 

	public String getData(String user) {
		return env.getProperty(user);
	}
}



