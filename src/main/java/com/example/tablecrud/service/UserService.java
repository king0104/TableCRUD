package com.example.tablecrud.service;

import com.example.tablecrud.dao.UserDao;
import com.example.tablecrud.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
// @RequiredArgsConstructor // UserDao 주입
public class UserService {

    @Autowired
    private UserDao userDao;

    public void save(String userName, int cash) {
        userDao.save(new User(null, userName, cash));
    }


}
