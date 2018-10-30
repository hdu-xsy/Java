package com.xsy.SpringBoot;

import com.xsy.SpringBoot.DAO.Person;
import com.xsy.SpringBoot.DAO.PersonRepository;
import com.xsy.SpringBoot.hello.HelloService;
import com.xsy.SpringBoot.support.CustomRepositoryFactoryBean;
import org.apache.catalina.Context;
import org.apache.catalina.connector.Connector;
import org.apache.tomcat.util.descriptor.web.SecurityCollection;
import org.apache.tomcat.util.descriptor.web.SecurityConstraint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.server.ErrorPage;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

//必须使用XML配置时 @ImportResource{{"classpath:some-context.xml","classpath:another-context.xml"}}
@Controller
@SpringBootApplication  //开启自动配置
//@EnableJpaRepositories(repositoryBaseClass = CustomRepositoryFactoryBean.class)
public class Application {

    @Autowired
    HelloService helloService;
    //PersonRepository personRepository;

	@RequestMapping("/hello")
        String hello() {
	        return helloService.sayHello();
    }

    @RequestMapping("/")
    public String index(Model model) {
	    Person single = new Person("aa",11);
	    List<Person> people = new ArrayList<Person>();
	    Person p1 = new Person("xx",11);
	    Person p2 = new Person("yy",22);
	    Person p3 = new Person("zz",33);
	    people.add(p1);
	    people.add(p2);
	    people.add(p3);
	    model.addAttribute("singlePerson",single);
	    model.addAttribute("people",people);
	    return "index";
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
}
