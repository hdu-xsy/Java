package com.xsy.SpringBoot.Controller;

import com.xsy.SpringBoot.Entity.Person;
import com.xsy.SpringBoot.Service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CacheController {

    @Autowired
    PersonService personService;

    @RequestMapping("/put")
    public Person put(Person person) {
        return personService.save(person);
    }

    @RequestMapping("/able")
    public Person cacheable(Person person) {
        return personService.findOne(person);
    }

    @RequestMapping("/evid")
    public String evid(Long id) {
        personService.remove(id);
        return "ok";
    }

}
