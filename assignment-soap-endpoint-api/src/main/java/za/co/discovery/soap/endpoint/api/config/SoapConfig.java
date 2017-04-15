package za.co.discovery.soap.endpoint.api.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;

@Configuration
@EnableWs
@ComponentScan(basePackages = "za.co.discovery.soap.endpoint.api.soap")
public class SoapConfig {

	@Bean
	public XsdSchema kweseSchema() {
		return new SimpleXsdSchema(new ClassPathResource("xsd/shortestRouteService.xsd"));
	}

	@Bean(name = "service")
	public DefaultWsdl11Definition defaultWsdl11Definition(XsdSchema kweseSchema) {
		final DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();
		wsdl11Definition.setPortTypeName("ShortestRouteApi");
		wsdl11Definition.setLocationUri("/soapapi/service");
		wsdl11Definition.setTargetNamespace("http://www.discovery/assignment/api/soap");
		wsdl11Definition.setSchema(kweseSchema);
		return wsdl11Definition;
	}
}
