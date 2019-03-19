package config;

import aop.Audience;
import aop.EncoreableIntroducer;
import aop.Performance;
import aop.PerformanceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy
@ComponentScan
public class AopConfig {

    @Bean
    public Audience audience() {
        return new Audience();
    }

    @Bean(name = "performance")
    public Performance performance() {
        return new PerformanceImpl();
    }

    @Bean
    public EncoreableIntroducer encoreableIntroducer() {
        return new EncoreableIntroducer();
    }
}
