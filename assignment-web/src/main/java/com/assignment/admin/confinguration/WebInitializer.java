package com.assignment.admin.confinguration;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.Filter;

public class WebInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {


    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[] { WebModuleConfiguration.class};
    }
  
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return null;
    }
  
    @Override
    protected String[] getServletMappings() {
        return new String[] { "/"};
    }
    
    @Override
    protected Filter[] getServletFilters() {
    	Filter [] singleton = { new WebFilter() };
    	return singleton;
	}

 
}