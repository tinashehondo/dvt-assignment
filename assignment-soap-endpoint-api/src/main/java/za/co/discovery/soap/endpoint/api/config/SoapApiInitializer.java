package za.co.discovery.soap.endpoint.api.config;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.ws.transport.http.MessageDispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration.Dynamic;

public class SoapApiInitializer implements WebApplicationInitializer {


	public void onStartup(ServletContext servletContext) throws ServletException {

		final AnnotationConfigWebApplicationContext webApplicationContext = new AnnotationConfigWebApplicationContext();
		webApplicationContext.register(SoapConfig.class);
		webApplicationContext.setServletContext(servletContext);
		final MessageDispatcherServlet servlet = new MessageDispatcherServlet();
		servlet.setApplicationContext(webApplicationContext);
		servlet.setTransformWsdlLocations(true);
		final Dynamic dynamic = servletContext.addServlet("soapDispatcher", servlet);
		dynamic.addMapping("/ws/*");
		dynamic.setLoadOnStartup(1);
	}

}
