package za.co.discovery.soap.endpoint.api.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.web.client.RestTemplate;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;
import za.co.discovery.soap.endpoint.api.utils.constants.SoapConstants;

@Configuration
@EnableWs
@ComponentScan(basePackages = {"za.co.discovery.soap.endpoint.api.soap","za.co.discovery.soap.endpoint.api.core"})
public class SoapConfig {

	@Bean
	public XsdSchema discoverySchema() {
		return new SimpleXsdSchema(new ClassPathResource("xsd/shortestRouteService.xsd"));
	}

	@Bean(name = "routes")
	public DefaultWsdl11Definition defaultWsdl11Definition(XsdSchema discoverySchema) {
		final DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();
		wsdl11Definition.setPortTypeName("ShortestRouteApiPort");
		wsdl11Definition.setLocationUri("/ws");
		wsdl11Definition.setTargetNamespace(SoapConstants.TARGET_NAMESPACE);
		wsdl11Definition.setSchema(discoverySchema);
		return wsdl11Definition;
	}

	@Bean
	public RestTemplate restTemplate(){
		return new RestTemplate();
	}
}
