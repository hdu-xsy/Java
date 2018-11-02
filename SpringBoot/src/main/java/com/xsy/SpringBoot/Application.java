package com.xsy.SpringBoot;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.xsy.SpringBoot.DAO.PersonDao;
import com.xsy.SpringBoot.hello.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.server.ErrorPage;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

//必须使用XML配置时 @ImportResource{{"classpath:some-context.xml","classpath:another-context.xml"}}
@Controller
@EnableCaching
@SpringBootApplication  //开启自动配置
public class Application {

    @Autowired
    HelloService helloService;

	@RequestMapping("/hello")
        String hello() {
	        return helloService.sayHello();
    }

    @Bean
	public ServletWebServerFactory servletContainer() {
		TomcatServletWebServerFactory tomcat = new TomcatServletWebServerFactory();
		tomcat.setPort(8080);
		tomcat.addErrorPages(new ErrorPage(HttpStatus.NOT_FOUND,"/404"));
		return tomcat;
	}

    //作为项目启动的入口
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	//自动转向
	/*@Bean
	public TomcatServletWebServerFactory servletWebServerFactory() {
		TomcatServletWebServerFactory tomcat = new TomcatServletWebServerFactory() {
			@Override
			protected void postProcessContext(Context context) {
				SecurityConstraint securityConstraint = new SecurityConstraint();
				securityConstraint.setUserConstraint("CONFIDENTIAL");
				SecurityCollection collection = new SecurityCollection();
				collection.addPattern("/*");
				securityConstraint.addCollection(collection);
				context.addConstraint(securityConstraint);
			}
		};
		tomcat.addAdditionalTomcatConnectors(httpConnector());
		return tomcat;
	}
	@Bean
	public Connector httpConnector() {
		Connector connector = new Connector("org.apache.coyote.http11.Http11NioProtocol");
		connector.setScheme("http");
		connector.setSecure(false);
		connector.setRedirectPort(8443);
		return connector;
	}*/

	@Bean
	@SuppressWarnings({"rawtypes","unchecked"})
	public RedisTemplate<Object,Object> redisTemplate(RedisConnectionFactory redisConnectionFactory)
		throws UnknownHostException {
		RedisTemplate<Object,Object> template = new RedisTemplate<Object, Object>();
		template.setConnectionFactory(redisConnectionFactory);

		Jackson2JsonRedisSerializer jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer(Object.class);
		ObjectMapper om = new ObjectMapper();
		om.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
		om.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
		jackson2JsonRedisSerializer.setObjectMapper(om);

		template.setValueSerializer(jackson2JsonRedisSerializer);
		template.setKeySerializer(new StringRedisSerializer());

		template.afterPropertiesSet();
		return template;
	}
}
