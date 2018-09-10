package com.hniu.service.imp;

import com.hniu.entity.User;
import com.hniu.entity.UserExample;
import com.hniu.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.hniu.service.HelloService;

import java.util.List;

@Service
public class HelloServiceImp implements HelloService {
    @Autowired
    UserMapper userMapper;

    public List<User> list(){
        UserExample example = new UserExample();
        example.setOrderByClause("user_id desc");
        return userMapper.selectByExample(example);
    }
}
