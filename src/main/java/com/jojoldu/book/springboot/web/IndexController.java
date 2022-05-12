package com.jojoldu.book.springboot.web;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@RequiredArgsConstructor
@Controller
public class IndexController {
    @GetMapping("/")
    public String index(){
        return "index";
    }
    
    @GetMapping("/posts/save") // /posts/save를 호출하면 posts-save.mustache를 호출하는 메소드
    public String postsSave(){
        return "posts-save";
    }
}
