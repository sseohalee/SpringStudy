package com.jojoldu.book.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication //스프링부트 자동 설정, Bean 읽기와 생성 자동 설정
public class Application { //프로젝트 메인 클래스
    public static void main(String[] args){
        SpringApplication.run(Application.class, args); //내장 WAS 실행
    }
}
