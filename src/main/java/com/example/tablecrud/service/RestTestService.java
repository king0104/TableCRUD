package com.example.tablecrud.service;

import com.example.tablecrud.entity.User;
import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestTemplate;

@Slf4j
public class RestTestService {

    @Autowired
    RestTemplate restTemplate;

    @Test
    public void getTest() {
            User user = restTemplate.getForObject("http://localhost:8080/read?id={id}", User.class, 658);
            log.info("user: {}", user);
    }

    @Test
    public void getTest2() {
        String str = restTemplate.getForObject("http://localhost:8080/test/user", String.class);
        System.out.println(str);
    }

       // String url = "http://localhost:8080/read?id={id}";
       // Integer empId= 101;
       // Employee emp = restTemplate.getForObject(url, Employee.class, empId);

}


