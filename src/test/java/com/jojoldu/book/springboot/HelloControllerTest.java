package com.jojoldu.book.springboot;

import com.jojoldu.book.springboot.web.HelloController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class) //테스트 진행시 SpringRunner라는 스프링 실행자를 사용. 스프링부트와 Junit 사이에 연결자 역할
@WebMvcTest(controllers = HelloController.class) //스프링테스트 어노테이션 중, Web(Spring MVC)에 집중할 수 있는 어노테이션
public class HelloControllerTest {
    @Autowired //스프링이 관리하는 빈(Bean)을 주입 받음.
    private MockMvc mvc; //웹 API를 테스트할 때 사용. 스프링 MVC테스트의 시작점

    @Test
    public void hello_is_return() throws Exception{
        //given
        String hello="hello";
        //when
        mvc.perform(get("/hello"))
                //then
                .andExpect(status().isOk())
                .andExpect(content().string(hello));
    }
    @Test
    public void helloDto_is_return() throws Exception{
        String name="hello";
        int amount=1000;

        mvc.perform(
                get("/hello/dto")
                        .param("name",name)
                        .param("amount",String.valueOf(amount)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name",is(name)))
                .andExpect(jsonPath("$.amount", is(amount)));
    }
}
