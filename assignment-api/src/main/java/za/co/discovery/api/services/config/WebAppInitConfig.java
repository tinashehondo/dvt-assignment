package za.co.discovery.api.services.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;
import za.co.discovery.repository.config.DataDaoConfiguration;
import za.co.discovery.service.config.AssignmentServiceConfig;


/**
 * Created by tinashehondo on 4/7/17.
 */
public class WebAppInitConfig extends AbstractAnnotationConfigDispatcherServletInitializer {


    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[] {RestConfig.class,DataDaoConfiguration.class, AssignmentServiceConfig.class };
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return null;
    }

    @Override
    protected String[] getServletMappings() {
        return new String[] { "/"};
    }



}
