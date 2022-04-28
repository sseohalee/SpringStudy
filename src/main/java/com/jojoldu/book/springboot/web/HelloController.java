package com.jojoldu.book.springboot.web;

import  org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController //JSON을 반환하는 컨트롤러로 만들어줌
public class HelloController {

    @GetMapping("/hello") //HTTP 메소드인 Get의 요청을 받을 수 있는 API로 만들어줆. /hello로 요청이 오면 문자열 hello를 반환하는 기능을 가짐.
    public String hello(){
        return "hello";
    }
}
