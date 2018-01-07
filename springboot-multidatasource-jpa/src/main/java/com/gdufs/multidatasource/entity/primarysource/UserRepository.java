package com.gdufs.multidatasource.entity.primarysource;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by gu on 2018/1/7.
 */
public interface UserRepository extends JpaRepository<User,Long> {
}
