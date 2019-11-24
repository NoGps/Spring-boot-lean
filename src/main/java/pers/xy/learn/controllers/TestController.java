package pers.xy.learn.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import pers.xy.learn.test.ExecutorTest;

import java.util.concurrent.Future;

@RestController
public class TestController {
    @Autowired
    ExecutorTest executorTest;

    @RequestMapping("/hello")
    public String hello() {
        executorTest.test();

        return "Hello Spring Boot!";
    }

    @RequestMapping("/executortest")
    public String executorTest(){
        try {
            System.out.println(System.currentTimeMillis());
            Future<String> result = executorTest.getFuture();
            System.out.println("begin");
            String test = result.get();
            System.out.println(System.currentTimeMillis());
            System.out.println("end");
            System.out.println(test);
        }catch (Exception ex){
            System.out.println("error");
        }

        return "test";
    }
}
