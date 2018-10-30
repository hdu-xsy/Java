package com.xsy.SpringBoot.Service;

import com.xsy.SpringBoot.DAO.PersonRepository;
import com.xsy.SpringBoot.Entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;


@Service
public class PersonServiceImpl implements PersonService{
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
}
