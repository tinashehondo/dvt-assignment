package za.co.discovery.soap.endpoint.api.config;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.ws.transport.http.MessageDispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration.Dynamic;

public class SoapApiInitializer implements WebApplicationInitializer {

	public void onStartup(ServletContext servletContext) throws ServletException {
		final AnnotationConfigWebApplicationContext ctx = new AnnotationConfigWebApplicationContext();
		ctx.register(SoapConfig.class);
		ctx.setServletContext(servletContext);
		final MessageDispatcherServlet servlet = new MessageDispatcherServlet();
		servlet.setApplicationContext(ctx);
		servlet.setTransformWsdlLocations(true);
		final Dynamic dynamic = servletContext.addServlet("soapDispatcher", servlet);
		dynamic.addMapping("/soapapi/*");
		dynamic.setLoadOnStartup(1);
	}

}
