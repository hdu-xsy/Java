package com.xsy.SpringBoot.Controller;

import com.xsy.SpringBoot.DAO.PersonRepository;
import com.xsy.SpringBoot.DAO.RedisPersonDao;
import com.xsy.SpringBoot.Entity.Person;
import com.xsy.SpringBoot.Entity.RedisPerson;
import com.xsy.SpringBoot.Service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DataController {

    @Autowired
    PersonRepository personRepository;

    @Autowired
    PersonService personService;

    @Autowired
    RedisPersonDao redisPersonDao;
    /*
    *  <S extends T> Iterable<S> save(Iterable><S> entities)
    *  void delete(ID id)
    *  void delete(T entity)
    *  void delete(Iterable<? extends T> entities)
    *  void deleteAll();
    *
    * */
    @RequestMapping("/save")
    public Person sava(String name,String address,Integer age) {

        Person p = personRepository.save(new Person(null,name,age,address));

        return p;
    }

    /*findByAddress*/
    @RequestMapping("/q1")
    public List<Person> q1(String address) {

        List<Person> people = personRepository.findByAddress(address);
        return people;
    }

    /*findByNameAndAddress*/
    @RequestMapping("/q2")
    public List<Person> q2(String name,String address) {

        List<Person> people = personRepository.findByNameAndAddress(name,address);

        return people;
    }

    /*withNameAndAddressQuery*/
    @RequestMapping("/q3")
    public List<Person> q3(String name,String address) {

        List<Person> people = personRepository.withNameAndAddressQueue(name,address);

        return people;
    }

    /*withNameAndAddressNamedQuery*/
    @RequestMapping("/q4")
    public List<Person> q4(String name,String address) {

        List<Person> people = personRepository.withNameAndAddressNamedQuery(name,address);

        return people;
    }

    @RequestMapping("/sort")
    public List<Person> sort() {

        List<Person> people = personRepository.findAll(new Sort(Sort.Direction.ASC,"age"));

        return people;
    }

    @RequestMapping("/page")
    public Page<Person> page() {

        Page<Person> personPage = personRepository.findAll(new PageRequest(1,2));

        return personPage;
    }

    @RequestMapping("/rollback")
    public Person rollback(Person person) {
        return personService.savePersonWithRollBack(person);
    }

    @RequestMapping("/norollback")
    public Person noRollback(Person person) {
        return personService.savePersonWithoutRollBack(person);
    }

    @RequestMapping("/set")
    public void set() {
        RedisPerson person = new RedisPerson("1","a",11);
        redisPersonDao.save(person);
        redisPersonDao.stringRedisTemplateDemo();

    }

    @RequestMapping("/getStr")
    public String getStr() {
        return redisPersonDao.getString();
    }

    @RequestMapping("/getPerson")
    public RedisPerson getPerson() {
        return redisPersonDao.getPerson();
    }
}
