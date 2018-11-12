package com.xsy.SpringBoot.Entity;

import lombok.Data;

import javax.persistence.*;

@Entity //Entity注解指明这是一个和数据库表映射的实体类
@NamedQuery(name = "Person.withNameAndAddressNamedQuery", query = "select p from Person p where p.name=?1 and address=?2")
@Data
public class Person {
    @Id //Id注解   表明这个属性映射为数据库的主键
    @GeneratedValue(strategy = GenerationType.IDENTITY) //GeneratedValue默认自增 会生成一个HIBERNATE_SEQUENCE的序列
    private Long id;

    private String name;

    private Integer age;

    private String address;

    public Person() {
        super();
    }

    public Person(Long id,String name,Integer age,String address) {
        super();
        this.id = id;
        this.name = name;
        this.age = age;
        this.address = address;
    }
}
