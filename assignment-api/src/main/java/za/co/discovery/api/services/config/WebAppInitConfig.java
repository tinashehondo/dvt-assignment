package za.co.discovery.api.services.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;
import za.co.discovery.repository.config.AppBootStrapConfig;
import za.co.discovery.repository.config.DataDaoConfiguration;
import za.co.discovery.service.config.AssignmentServiceConfig;


/**
 * Created by tinashehondo on 4/7/17.
 */
public class WebAppInitConfig extends AbstractAnnotationConfigDispatcherServletInitializer {


    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[] {DataDaoConfiguration.class, AssignmentServiceConfig.class,AppBootStrapConfig.class };
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[] {RestConfig.class};
    }

    @Override
    protected String[] getServletMappings() {
        return new String[] { "/"};
    }



}
