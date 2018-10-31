package com.xsy.SpringBoot.Service;

import com.xsy.SpringBoot.DAO.PersonRepository;
import com.xsy.SpringBoot.Entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;


@Service
public class PersonServiceImpl implements PersonService {
    @Autowired
    PersonRepository personRepository;

    @Transactional(rollbackOn={IllegalArgumentException.class})
    public Person savePersonWithRollBack(Person person) {
        Person p = personRepository.save(person);

        if(person.getName().equals("dd")) {
            throw new IllegalArgumentException("数据回滚");
        }
        return p;
    }

    @Transactional(dontRollbackOn = {IllegalArgumentException.class})
    public Person savePersonWithoutRollBack(Person person) {
        Person p = personRepository.save(person);

        if(person.getName().equals("dd")) {
            throw new IllegalArgumentException("不会回滚");
        }
        return p;
    }

    @Override
    @CachePut(value = "people",key = "#person.id")
    public Person save(Person person) {
        Person p = personRepository.save(person);
        System.out.println("为id、key为："+p.getId()+"数据做了缓存");
        return p;
    }

    @Override
    @CacheEvict(value = "people")
    public void remove(Long id) {
        System.out.println("删除了id、key为" +id+"的数据缓存");
        personRepository.deleteById(id);
    }

    @Override
    @Cacheable(value = "people",key="#person.id")
    public Person findOne(Person person) {
        Optional<Person> p = personRepository.findById(person.getId());
        System.out.println("为id、key为:"+p.get().getId()+"数据做了缓存");
        return p.get();
    }
}
