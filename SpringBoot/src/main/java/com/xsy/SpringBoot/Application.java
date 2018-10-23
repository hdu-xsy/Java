package com.xsy.SpringBoot;

import com.xsy.SpringBoot.DAO.Person;
import com.xsy.SpringBoot.hello.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

//必须使用XML配置时 @ImportResource{{"classpath:some-context.xml","classpath:another-context.xml"}}
@Controller
@SpringBootApplication  //开启自动配置
public class Application {

    @Autowired
    HelloService helloService;

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

    //作为项目启动的入口
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
