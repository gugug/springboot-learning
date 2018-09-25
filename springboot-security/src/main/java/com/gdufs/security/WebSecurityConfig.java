package com.gdufs.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.StandardPasswordEncoder;

/**
 *
 * * 通过@EnableWebSecurity注解开启Spring Security的功能
 * 继承WebSecurityConfigurerAdapter，并重写它的方法来设置一些web安全的细节
 * configure(HttpSecurity http)方法
 *      通过authorizeRequests()定义哪些URL需要被保护、哪些不需要被保护。例如以上代码指定了/和/home不需要任何认证就可以访问，其他的路径都必须通过身份验证。
 *      通过formLogin()定义当需要用户登录时候，转到的登录页面。
 * configureGlobal(AuthenticationManagerBuilder auth)方法，在内存中创建了一个用户，该用户的名称为user，密码为password，用户角色为USER。

 *
 * Created by gucailiang on 2018/1/8.
 */
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http
//                .csrf().disable()//禁用Spring Security的CSRF防护功能
                //定义哪些URL需要被保护、哪些不需要被保护
                .authorizeRequests()
                    .antMatchers("/", "/home").permitAll()
                    .anyRequest().authenticated()
                    .and()
                //定义当需要用户登录时候，转到的登录页面
                .formLogin()
                    .loginPage("/login")
                    .permitAll()
                    .and()
                .rememberMe()
                    .tokenValiditySeconds(2419200).key("spittrKey").and()
                .logout()
                    .permitAll();
    }

//    @Override
//    public void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.inMemoryAuthentication()
//                //在内存中创建了一个用户，该用户的名称为user，密码为password，用户角色为USER
//                .withUser("username").password("password").roles("USER")
//                .and()
//                .withUser("admin").password("admin").roles("USER","ADMIN");
//    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
//        基于数据库表进行认证
//        auth.jdbcAuthentication().dataSource().usersByUsernameQuery().authoritiesByUsernameQuery().groupAuthoritiesByUsername().
//                passwordEncoder(new StandardPasswordEncoder("5r43ct4C"));//基于数据库表进行认证


//        使用基于内存的用户存储
        auth.inMemoryAuthentication()
                //在内存中创建了一个用户，该用户的名称为user，密码为password，用户角色为USER
                .withUser("username").password("password").roles("USER")// roles()是.authorities方法的缩写，只是加了前缀("ROLE_USER")
                .and()
                .withUser("admin").password("admin").roles("USER","ADMIN");
    }
}
