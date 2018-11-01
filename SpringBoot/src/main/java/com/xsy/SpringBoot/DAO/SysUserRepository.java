package com.xsy.SpringBoot.DAO;

import com.xsy.SpringBoot.Entity.SysUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SysUserRepository extends JpaRepository<SysUser,Long> {

    SysUser findByUsername(String username);
}
