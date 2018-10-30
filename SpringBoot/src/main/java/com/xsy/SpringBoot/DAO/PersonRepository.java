package com.xsy.SpringBoot.DAO;

import com.xsy.SpringBoot.Entity.Person;
import com.xsy.SpringBoot.support.CustomRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PersonRepository extends CustomRepository<Person,Long> {//JpaRepository<Person,Long> {

    List<Person> findByAddress(String name);

    List<Person> findByNameAndAddress(String name,String address);

    @Query("select p from Person p where p.name= :name and p.address= :address")
    List<Person> withNameAndAddressQueue(@Param("name")String name,@Param("address")String address);

    List<Person> withNameAndAddressNamedQuery(String name,String address);


}
