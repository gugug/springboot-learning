package com.gdufs.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.method.configuration.GlobalMethodSecurityConfiguration;

/**
 * 使用@Secured注解限制方法调用
 * <p>
 * 配置类扩展了GlobalMethodSecurityConfiguration。在第9章中，Web安全的配置类扩展了WebSecurityConfigurerAdapter，
 * <p>
 * 如果securedEnabled属性的值为true的话，将会创建一个切点，这样的话Spring Security切面就会包装带有@Secured注解的方
 * <p>
 * 选择使用@RolesAllowed的话，需要将@EnableGlobalMethodSecurity的jsr250Enabled属性设置为true，以开启此功
 * <p>
 * 两种注解风格可以同时启用
 * <p>
 * prePostEnabled 方法调用前后的注解都已经启用了
 *
 * @author gucailiang
 * @date 2018/9/30
 */
@Configuration
@EnableGlobalMethodSecurity(securedEnabled = true, jsr250Enabled = true, prePostEnabled = true)
public class MethodSecurityConfig extends GlobalMethodSecurityConfiguration {
}
