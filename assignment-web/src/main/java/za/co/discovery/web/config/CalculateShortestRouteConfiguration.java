
package za.co.discovery.web.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import za.co.discovery.web.client.RoutesClient;

@Configuration
public class CalculateShortestRouteConfiguration {

	@Bean
	public Jaxb2Marshaller marshaller() {
		Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
		// this package must match the package in the <generatePackage> specified in
		// pom.xml
		marshaller.setContextPath("za.co.discovery.soap.endpoint.client.wsdl");
		return marshaller;
	}

	@Bean
	public RoutesClient routesClient(Jaxb2Marshaller marshaller) {
		RoutesClient client = new RoutesClient();
		client.setDefaultUri("http://localhost:8081/assignment-soap-service/ws");
		client.setMarshaller(marshaller);
		client.setUnmarshaller(marshaller);
		return client;
	}

}
