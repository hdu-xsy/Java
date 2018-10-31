package com.xsy.SpringBoot.DAO;

public class PersonDao {
    private String name;
    private Integer age;

    public PersonDao() {
        super();
    }
    public PersonDao(String name, Integer age) {
        super();
        this.name =name;
        this.age = age;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Integer getAge() {
        return age;
    }
    public void setAge(Integer age) {
        this.age = age;
    }
}
