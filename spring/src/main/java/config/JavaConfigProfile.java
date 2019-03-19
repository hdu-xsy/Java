package config;

import javaconfig.JavaConfigService;
import javaconfig.JavaConfigServiceImpl;
import javaconfig.UseJavaConfigService;
import javaconfig.UseJavaConfigServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
//@Profile("DEV")
public class JavaConfigProfile {

    @Bean(name = "JavaConfigService")
    public JavaConfigService javaConfigService() {
        return new JavaConfigServiceImpl();
    }

    @Bean(name = "UseJavaConfigService")
    public UseJavaConfigService useJavaConfigService() {
        return new UseJavaConfigServiceImpl(javaConfigService());
    }

}
