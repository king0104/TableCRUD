package com.example.tablecrud.dao;

import com.example.tablecrud.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

@SpringBootTest // test에는 이 어노테이션 꼭 붙이기
public class UserDaoTests {

    @Autowired
    private UserDao userDao;

    @Test
    public void delete() {
        Optional<User> user = userDao.findById(654L);

        user.ifPresent(selectUser->{
            userDao.delete(selectUser);
        });

    }

    @Test
    public void update() {
        Optional<User> user = userDao.findById(654L);

        user.ifPresent(selectUser->{ // 질문. selectUser가 뭘까?
            selectUser.setName("yoonsubin");
            selectUser.setCash(999);
            userDao.save(selectUser);
        });
    }

    @Test
    public void read() {
        Optional<User> user = userDao.findById(654L);

        user.ifPresent(selectUser ->{
            System.out.println(selectUser.getName());
            System.out.println(selectUser.getCash());
        });
    }

    @Test
    public void create(){
        User user = new User();
        // 엔티티 하나 만들기 - 테이블 하나를 만든다는 뜻인가요 아니면 ROW하나를 만든다는 뜻인가요

        user.setName("yoon1");
        user.setCash(111);
        user.setId(11L);

        userDao.save(user);
    }

}
