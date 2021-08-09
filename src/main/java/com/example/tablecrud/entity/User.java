package com.example.tablecrud.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.annotation.processing.Generated;
import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity // db의 테이블에 해당
// 질문. User가 테이블에 해당하는 것인가요 아니면 테이블 내에 존재하는 하나하나의 row를 의미하는 것인가요???
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private int cash;
}
