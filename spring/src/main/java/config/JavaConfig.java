package config;

import javaconfig.UseJavaConfigServiceImpl;
import javaconfig.JavaConfigService;
import javaconfig.JavaConfigServiceImpl;
import javaconfig.UseJavaConfigService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//@Import()
//@ImportResource()
@Configuration
public class JavaConfig {

    @Bean(name="javaConfigService")
    public JavaConfigService javaConfigService() {
        return new JavaConfigServiceImpl();
    }

    @Bean(name="useJavaConfigService")
    public UseJavaConfigService useJavaConfigService() {
        return new UseJavaConfigServiceImpl(javaConfigService());
    }

}
