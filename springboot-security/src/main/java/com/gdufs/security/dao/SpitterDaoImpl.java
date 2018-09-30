package com.gdufs.security.dao;

import com.gdufs.security.domain.Blog;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PostFilter;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Repository;

import javax.annotation.security.RolesAllowed;
import java.util.ArrayList;
import java.util.List;

/**
 * @author gucailiang
 * @date 2018/9/30
 */
@Repository
public class SpitterDaoImpl {


    /**
     * @Secured注解会使用一个String数组作为参数。 每个String值是一个权限，调用这个方法至少需要具备其中的一个权限。
     * 通过传递进来ROLE_SPITTER，我们告诉Spring Security只允许具有ROLE_SPITTER权限的认证用户才能调用addSpittle ()方法。
     * <p>
     * @RolesAllowed注解和@Secured注解 在各个方面基本上都是一致的。唯一显著的区别在 于@RolesAllowed是JSR-250定义的Java标准注.
     * 选择使用@RolesAllowed的话，需要将@EnableGlobalMethodSecurity的jsr250Enabled属性设置为true，以开启此功能
     * <p>
     * What's the difference between @Secured and @PreAuthorize in spring security 3?
     * The real difference is that @PreAuthorize can work with Spring Expression Language (SpEL). You can:
     */
    @Secured(value = {"ROLE_SPITTER", "ROLE_ADMIN"})
    public void addSpitter() {

    }

    @RolesAllowed(value = {"ROLE_SPITTER", "ROLE_ADMIN"})
    public void addSpitter1() {

    }


    @PreAuthorize(value = "hasRole('ROLE_ADMIN')")
    public void addSpitter2() {

    }

    @PreAuthorize(value = "(hasRole('ROLE_SPITTER') and blog.title.length() < 140) or hasRole('ROLE_ADMIN')")
    public void addSpitter3(Blog blog) {

    }

    @PostAuthorize("returnObject.name == 'hello'")
    public Blog get(Integer id) {
        Blog blog = new Blog();
        blog.setName("hello");
        return blog;
    }

    @PreAuthorize(value = "(hasRole('ROLE_SPITTER') and id < 10) or hasRole('ROLE_ADMIN')")
    @PostFilter(value = "(hasRole('ROLE_SPITTER') || filterObject.title.length() < 140) or hasRole('ROLE_ADMIN')")
    public List<Blog> list(Integer id) {
        Blog blog = new Blog();
        blog.setName("hello");
        ArrayList<Blog> blogs = new ArrayList<Blog>();
        blogs.add(blog);
        return blogs;
    }
}
