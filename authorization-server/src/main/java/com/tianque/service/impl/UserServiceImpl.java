package com.tianque.service.impl;

import com.tianque.entity.UserEntity;
import com.tianque.repository.UserRepository;
import com.tianque.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by QQ on 2018/7/13.
 */
@Service("userService")
public class UserServiceImpl implements UserService{
    @Autowired
    private UserRepository userRepository;
    @Override
    public UserEntity getUserEntityByUsername(String name) {
        return userRepository.findByUserName(name);
    }
}
