package com.tianque.repository;

import com.tianque.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by QQ on 2018/7/13.
 */
public interface UserRepository extends JpaRepository<UserEntity,Long> {
    UserEntity findByUserName(String name);
}
