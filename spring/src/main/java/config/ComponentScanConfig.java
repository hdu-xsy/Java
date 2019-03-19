package config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/*
* 组件扫描默认是不启用的。 我们还需要显式配置一下Spring，
* 从而命令它去寻找带有@Component注解的类， 并为其创建bean
* */

/*
* <context:component-scan base-package="autowiring"/>
* */

@Configuration
@ComponentScan(basePackages = {"autowiring"})
public class ComponentScanConfig {

}
