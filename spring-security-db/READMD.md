
study from  http://www.spring4all.com/article/428
#spring security 与 mybatis 的整合，实现基于数据库的登录校验
实现UserDetailsService的方法，进行数据库的登录验证
#ps
默认情况下 thymeleaf 对于模板的解析是严格模式的，某些元素没有使用 "/" 结束符便会抛出 报错日志信息（一）。

包括像使用 vue.js 的库编写了 <div v-cloak></div> 这样的代码，也会解析不通过。

解决方法

可以在配置文件中增加 spring.thymeleaf.mode=LEGACYHTML5 配置项，默认情况下是 spring.thymeleaf.mode=HTML5

LEGACYHTML5 需要搭配第三方库 nekohtml 才可以使用。

# 加密登录验证
   @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
#自定义的 Filter 加入到 Spring Security 中的 Filter 链中的指定位置
HttpSecurity.addFilterBefore(new DiyFilter(), UsernamePasswordAuthenticationFilter.class);

# qq-oauth 授权码方式
TOKEN_ACCESS_API --> openIdUri -->
QQAuthenticationManager 通过传来的 token 和 openID 去请求腾讯的getUserInfo接口，获取腾讯用户的信息，并生成新的 Authtication 对象
