package com.xsy.SpringBoot.Controller;

import com.xsy.SpringBoot.DAO.PersonRepository;
import com.xsy.SpringBoot.DAO.SysUserRepository;
import com.xsy.SpringBoot.Entity.SysRole;
import com.xsy.SpringBoot.Entity.SysUser;
import com.xsy.SpringBoot.Service.CustomUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UserController {

    @Autowired
    private SysUserRepository sysUserRepository;

    @RequestMapping(value = "/saveUser/{id}/{username}/{password}",method = RequestMethod.GET)
    public String saveUser(@PathVariable Long id,@PathVariable String username,@PathVariable String password) {
        SysUser sysUser = new SysUser(id,username,new BCryptPasswordEncoder().encode(password));
        List<SysRole> sysRoles = new ArrayList<SysRole>();
        sysRoles.add(new SysRole(Integer.toUnsignedLong(2),"ROLE_USER"));
        sysUser.setRoles(sysRoles);
        sysUserRepository.save(sysUser);
        return "saveSuccess";
    }

}
