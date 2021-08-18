package com.example.tablecrud;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class SpringConfig {

    // restTemplate 빈에 등록하기
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

}
