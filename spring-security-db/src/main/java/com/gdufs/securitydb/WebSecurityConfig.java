package com.gdufs.securitydb;

import com.gdufs.securitydb.filter.AfterCsrfFilter;
import com.gdufs.securitydb.filter.AtX509AuthenticationFilter;
import com.gdufs.securitydb.filter.BeforeLoginFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.preauth.x509.X509AuthenticationFilter;
import org.springframework.security.web.csrf.CsrfFilter;

/**
 * * 通过@EnableWebSecurity注解开启Spring Security的功能
 * 继承WebSecurityConfigurerAdapter，并重写它的方法来设置一些web安全的细节
 * configure(HttpSecurity http)方法
 * 通过authorizeRequests()定义哪些URL需要被保护、哪些不需要被保护。例如以上代码指定了/和/home不需要任何认证就可以访问，其他的路径都必须通过身份验证。
 * 通过formLogin()定义当需要用户登录时候，转到的登录页面。
 * configureGlobal(AuthenticationManagerBuilder auth)方法，在内存中创建了一个用户，该用户的名称为user，密码为password，用户角色为USER。
 * <p>
 * <p>
 * Created by gucailiang on 2018/1/8.
 */
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    private AnyUserDetailsService anyUserDetailsService;

    @Autowired
    public void setAnyUserDetailsService(AnyUserDetailsService anyUserDetailsService) {
        this.anyUserDetailsService = anyUserDetailsService;
    }

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/").permitAll()
                .antMatchers("/user/**").hasRole("USER")
                .and()
                .formLogin().loginPage("/login").defaultSuccessUrl("/user")
                .and()
                .logout().logoutUrl("/logout").logoutSuccessUrl("/login");
        // 在 UsernamePasswordAuthenticationFilter 前添加 BeforeLoginFilter
        http.addFilterBefore(new BeforeLoginFilter(), UsernamePasswordAuthenticationFilter.class);

        //at
        http.addFilterAt(new AtX509AuthenticationFilter(), X509AuthenticationFilter.class);

        //after
        http.addFilterAfter(new AfterCsrfFilter(), CsrfFilter.class);
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(anyUserDetailsService).passwordEncoder(passwordEncoder());
    }

    /**
     * 密码加密
     * <p>
     * BCryptPasswordEncoder相关知识：
     * <p>
     * 用户表的密码通常使用MD5等不可逆算法加密后存储，为防止彩虹表破解更会先使用一个特定的字符串（如域名）加密，然后再使用一个随机的salt（盐值）加密。
     * <p>
     * 特定字符串是程序代码中固定的，salt是每个密码单独随机，一般给用户表加一个字段单独存储，比较麻烦。
     * <p>
     * BCrypt算法将salt随机并混入最终加密后的密码，验证时也无需单独提供之前的salt，从而无需单独处理salt问题。
     */
    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
