package com.xsy.SpringBoot.Entity;


import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
public class SysRole {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    public SysRole() { }

    public SysRole(Long id,String name) {
        super();
        this.id = id;
        this.name = name;
    }

}
