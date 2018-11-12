package com.xsy.SpringBoot.DAO;

import com.xsy.SpringBoot.Entity.Person;
import com.xsy.SpringBoot.Entity.RedisPerson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

@Repository
public class RedisPersonDao {

    /*@Autowired
    StringRedisTemplate stringRedisTemplate;

    @Resource(name = "stringRedisTemplate")
    ValueOperations<String,String> valueOpsStr;

    @Autowired
    RedisTemplate<Object,Object> redisTemplate;

    @Resource(name = "redisTemplate")
    ValueOperations<Object,Object> valOps;

    public void stringRedisTemplateDemo() {
        valueOpsStr.set("xx","yy");
    }

    public void save(RedisPerson person) {
        valOps.set(person.getId(),person);
    }

    public String getString() {
        return valueOpsStr.get("xx");
    }

    public RedisPerson getPerson() {
        return (RedisPerson) valOps.get("1");
    }*/


}
