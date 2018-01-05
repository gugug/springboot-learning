package com.gdufs.jpa.dao;

import com.gdufs.jpa.entity.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * jpa组件
 * 该接口本身已经实现了创建（save）、更新（save）、删除（delete）、查询（findAll、findOne）等基本操作的函数，因此对于这些基础操作的数据访问就不需要开发者再自己定义。
 * <p>
 * 这就是Spring-data-jpa的一大特性：通过解析方法名创建查询。
 *
 * https://docs.spring.io/spring-data/data-jpa/docs/current/api/
 * Created by gu on 2017/12/3.
 */
public interface CityRepository extends JpaRepository<City, Long> {

    City findById(Long id);

    List<City> findByProvinceId(Long provinceId);

    List<City> findByCityName(String cityName);

    City findAllByProvinceIdAndAndCityName(Long provinceId, String cityName);

    //    它也提供通过使用@Query 注解来创建查询，您只需要编写JPQL语句，并通过类似“:name”来映射@Param指定的参数，就像例子中的第三个findUser函数一样。
    //    @Query("from city c where c.id=:id")
    //    City findCity(@Param("id") Integer id);
}
