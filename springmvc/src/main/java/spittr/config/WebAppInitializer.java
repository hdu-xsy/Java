package spittr.config;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.FilterRegistration;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

public class WebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer
        implements WebApplicationInitializer {

    /*
    Spring提供了这个接口的实现， 名为SpringServletContainerInitializer，
    这个类反过来又会查找实现WebApplicationInitializer 的类并将配置的任务交给它们来完成
    */

    @Override
    //它会将一个或多个路径映射到DispatcherServlet上
    protected String[] getServletMappings() {
        return new String[] { "/" };
    }

    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class<?>[] { RootConfig.class };
    }

    @Override
    //我们要求DispatcherServlet加载应用上下文时， 使用定义在WebConfig配置类（ 使用Java配置） 中的bean
    protected Class<?>[] getServletConfigClasses() {
        return new Class<?>[] { WebConfig.class };
    }


/*
    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        ServletRegistration.Dynamic myServlet = servletContext.addServlet("",MyServlet.class);
        myServlet.addMapping("/");
        FilterRegistration.Dynamic filterRegistration = servletContext.addFilter("",MyFilter.class);
        filterRegistration.addMappingForUrlPatterns(null,false,"/");

    }
*/

}
