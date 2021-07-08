package by.it_academy.jd2.hw.example.messenger.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * Spring configuration initializer
 * @author Maksim Perekladov
 * @version 2.0
 */

public class MyWebApplicationInitializer extends AbstractAnnotationConfigDispatcherServletInitializer{

    protected Class<?>[] getRootConfigClasses() {
        return new Class[] {RootConfig.class};
    }

    protected Class<?>[] getServletConfigClasses()  {
        return new Class[] {WebConfig.class};
    }

    protected String[] getServletMappings() {
        return new String[] {"/"};
    }

}