package com.xsy.SpringBoot.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;


@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                //设置SpringSecurity对/和/login路径不拦截
                //.requestMatchers()
                .antMatchers("/","/login").permitAll()
                //只拦截
                .antMatchers("/chat").authenticated()
                .and()
                //设置SpringSecurity的登陆页面访问的路径为/login
                .formLogin().loginPage("/login")
                //登陆成功后转向/chat路径                .defaultSuccessUrl("/chat")
                .permitAll()
                .and().logout().permitAll();
        http.csrf().disable();
    }

    //在内存中分别配置两个用户，角色是USER
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .inMemoryAuthentication()
                .withUser("xsy").password("{noop}xsy").roles("USER")
                .and()
                .withUser("springboot").password("{noop}springboot").roles("USER");
    }

    //不拦截静态资源
    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/resources/static/**");
    }
}
