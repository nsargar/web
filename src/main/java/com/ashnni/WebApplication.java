package com.ashnni;

import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.SecurityAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

import controller.ArchController;
//import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
//import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class })
@EnableAutoConfiguration
@ComponentScan(basePackages = { "controller", "configuration", "services" })
public class WebApplication {
	
	
		public static void main(String[] args) {

			
			
		SpringApplication.run(WebApplication.class, args);
		
		
		
		
	}
}
