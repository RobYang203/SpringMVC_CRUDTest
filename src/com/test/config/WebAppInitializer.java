package com.test.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

@Configuration
public class WebAppInitializer implements WebApplicationInitializer{
	public WebAppInitializer() {
		// TODO Auto-generated constructor stub
		System.out.println("MVC WebAppInitializer");
	}
	@Override
	public void onStartup(ServletContext servletContext) throws ServletException{
		System.out.println("MVC WebAppInitializer StartUp!");
		AnnotationConfigWebApplicationContext appContext = new AnnotationConfigWebApplicationContext();
		appContext.register(WebMvcConfig.class);
		
		ServletRegistration.Dynamic dispather =servletContext.addServlet(
				"SpringDispatcher", new DispatcherServlet(appContext));
		dispather.setLoadOnStartup(1);
		dispather.addMapping("/");
		
	}
	
}
