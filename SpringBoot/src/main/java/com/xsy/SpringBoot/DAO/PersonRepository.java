package com.xsy.SpringBoot.DAO;

import com.xsy.SpringBoot.Entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PersonRepository extends JpaRepository<Person,Long> {

    List<Person> findByAddress(String name);

    List<Person> findByNameAndAddress(String name,String address);

    @Query("select p from Person p where p.name= :name and p.address= :address")
    List<Person> withNameAndAddressQueue(@Param("name")String name,@Param("address")String address);

    List<Person> withNameAndAddressNamedQuery(String name,String address);


}
