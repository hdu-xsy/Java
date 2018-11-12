package com.xsy.SpringBoot.Service;

import com.xsy.SpringBoot.DAO.SysUserRepository;
import com.xsy.SpringBoot.Entity.SysRole;
import com.xsy.SpringBoot.Entity.SysUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

public class CustomUserService implements UserDetailsService {

    @Autowired
    SysUserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) {
        SysUser user = userRepository.findByUsername(username);
        if(user == null)
            throw new UsernameNotFoundException("用户名不存在");
        return user;
    }

}
