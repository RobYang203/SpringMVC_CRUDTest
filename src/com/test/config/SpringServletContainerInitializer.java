package com.test.config;

import java.lang.reflect.Modifier;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;

import javax.servlet.ServletContainerInitializer;
import javax.servlet.annotation.HandlesTypes;

import org.springframework.web.WebApplicationInitializer;

import com.sun.istack.Nullable;

@HandlesTypes({WebApplicationInitializer.class})
public class SpringServletContainerInitializer implements ServletContainerInitializer{
	public  SpringServletContainerInitializer() {
		
	}
	
	@Override
	public void onStartup(@Nullable Set<Class<?>> webApplicationInitializerClasss, javax.servlet.ServletContext servletContext) throws javax.servlet.ServletException{
		System.out.println("MVC StartUp!");
//		LinkedList initializers = new LinkedList();
//		Iterator var4;
//		if(webApplicationInitializerClasss != null) {
//			var4=webApplicationInitializerClasss.iterator();
//			while (var4.hasNext()) {
//				Class initalizer=(Class)var4.next();
//				
//				if(!initalizer.isInterface() && !Modifier.isAbstract(initalizer.getModifiers()) && WebApplicationInitializer.class.isAssignableFrom(initalizer) ) {
//					
//					try {
//						
//					} catch (Exception e) {
//						// TODO: handle exception
//					}
//				}
//			}
//		}
	
	
	}

}
