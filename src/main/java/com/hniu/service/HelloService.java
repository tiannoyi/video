package com.hniu.service;

import com.hniu.entity.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HelloService {
    List<User> list();
}
