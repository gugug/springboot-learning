# spring-security
使用Spring Security进行安全控制 登录安全  

* 通过@EnableWebSecurity注解开启Spring Security的功能
* 继承WebSecurityConfigurerAdapter，并重写它的方法来设置一些web安全的细节
* configure(HttpSecurity http)方法
>* 通过authorizeRequests()定义哪些URL需要被保护、哪些不需要被保护。例如以上代码指定了/和/home不需要任何认证就可以访问，其他的路径都必须通过身份验证。
>* 通过formLogin()定义当需要用户登录时候，转到的登录页面。
* configureGlobal(AuthenticationManagerBuilder auth)方法，在内存中创建了一个用户，该用户的名称为user，密码为password，用户角色为USER。

[学习1](https://github.com/SpringForAll/SpringBoot-Learning/tree/master/Chapter4-3-1)
[学习2](http://blog.didispace.com/springbootsecurity/)