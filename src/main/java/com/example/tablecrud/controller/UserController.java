package com.example.tablecrud.controller;

import com.example.tablecrud.dao.UserDao;
import com.example.tablecrud.entity.User;
import com.example.tablecrud.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.persistence.PostLoad;
import java.util.Optional;

@RestController
@RequestMapping("/")
public class UserController {

    @Autowired
    private UserDao userDao;

    @PostMapping("/create")
    public void Save(@RequestBody User user) {
        userDao.save(user);
    }


    @GetMapping("/read")
    public User findUser(@RequestParam Long id) {
        Optional<User> user = userDao.findById(id);

        return user.get();
    }

    @PutMapping("/update")
    public Optional<User> changeInfo(@RequestParam Long id, @RequestBody User user) {
        Optional<User> updateUser = userDao.findById(id); // 1. 변경할 user 찾기

        updateUser.ifPresent(selectUser -> { // 2. 존재하면, 입력받은 user 값으로 업데이트
            selectUser.setName(user.getName());
            selectUser.setCash(user.getCash());

            userDao.save(selectUser); // 업데이트한 user를 데이터베이스에 저장한다
            // 질문. 이 userDao는 update가 아니라 데이터베이스에 새로운 하나의 row를 또 만드는거 아닌가요?
        });

        return updateUser;
    }

    @GetMapping("/delete")
    public Optional<User> deleteUser(@RequestParam Long id) {
        Optional<User> deleteUser = userDao.findById(id);

        deleteUser.ifPresent(selectUser->{
            userDao.delete(selectUser);
        });

        return deleteUser; // 자동으로 JSON 형식으로 변환해서 RETURN 한다.
    }
}
