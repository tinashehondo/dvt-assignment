package za.co.discovery.soap.endpoint.api.config;

import org.springframework.web.context.AbstractContextLoaderInitializer;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;

public class RootInitializer extends AbstractContextLoaderInitializer {

	@Override
	protected WebApplicationContext createRootApplicationContext() {
		final AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
		return context;
	}

}
