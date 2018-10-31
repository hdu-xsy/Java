package com.xsy.SpringBoot.Service;

import com.xsy.SpringBoot.Entity.Person;

public interface PersonService {
    Person savePersonWithRollBack(Person person);

    Person savePersonWithoutRollBack(Person person);

    Person save(Person person);

    void remove(Long id);

    Person findOne(Person person);

}
