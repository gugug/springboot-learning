# idea aspect切面不生效
 * idea的默认配置不成功。可能是以下原因：
 * aspect这种写法是idea的增强插件，参加下面的链接。要用的是spring的切面，改为class就好了。
 * [AspectJ - Help | IntelliJ IDEA](https://www.jetbrains.com/help/idea/aspectj.html)
 
 
 ps:
  * # AOP
  * spring.aop.auto=true # Add @EnableAspectJAutoProxy.
  * spring.aop.proxy-target-class=false # Whether subclass-based (CGLIB) proxies are to be created (true) as
  * opposed to standard Java interface-based proxies (false).
  * 而当我们需要使用CGLIB来实现AOP的时候，需要配置spring.aop.proxy-target-class=true，不然默认使用的是标准Java的实现。
  
  
# 监控端点

Spring Boot Actuator Cannot Show diskSpace Information
because only ADMINs are authorized to see any more info than this

所以需要把web security set false
In case if you are using spring security which is by default ON for actuator endpoints, you can disable it in your yml file -

management:
   security:
      enabled: false 