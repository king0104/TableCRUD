package com.example.tablecrud.service;

import com.example.tablecrud.entity.User;
import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.*;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestTemplate;

import javax.persistence.criteria.CriteriaBuilder;

import static net.bytebuddy.matcher.ElementMatchers.is;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@Slf4j
@RunWith(SpringRunner.class) //JUnit 4 사용시 필요. JUnit 5 사용 시에는 @SpringBootTest 만으로 해결 가능
@SpringBootTest
public class RestTestService {

    @Autowired
    private RestTemplate restTemplate ; //= new RestTemplate();

    String url = "http://localhost:8080";

    @Test
    public void getTest() {
        User user = restTemplate.getForObject(url+"/read?id={id}", User.class, 658);
        log.info("user: {}", user.getId());
    }

    @Test
    public void postTestFinal() throws JSONException { //JSONException 던져야 JSONObject 만들 수 있다.

        // body 만들기
        JSONObject userJsonObject = new JSONObject();
        userJsonObject.put("id", 1);
        userJsonObject.put("name", "jang");
        userJsonObject.put("cash", 999);


        // header 만들기
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        // body + header
        HttpEntity<String> entity = new HttpEntity<>(userJsonObject.toString(), headers);


//      try {
        ResponseEntity<String> response = restTemplate.exchange(
                url+"/create", //{요청할 서버 주소}
                HttpMethod.POST, //{요청할 방식}
                entity, // {요청할 때 보낼 데이터}
                String.class); //{요청시 반환되는 데이터 타입}

        System.out.println(response.getBody());

//        } catch(HttpStatusCodeException e) {
//             ResponseEntity.status(e.getRawStatusCode())
//                    .headers(e.getResponseHeaders())
//                    .body(e.getResponseBodyAsString());
//        }

    }


    @Test
    public void putTestByPut() {
        User user = new User(null,"lee",111);

        restTemplate.put(url+"/update?id={id}",user,663);
    }


    @Test
    public void deleteTest() {
        User user = restTemplate.getForObject(url+"/delete?id={id}", User.class, 661);
        log.info("user: {}", user.getId());
    }



}


