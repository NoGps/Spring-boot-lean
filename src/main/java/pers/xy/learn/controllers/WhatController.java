package pers.xy.learn.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping
public class WhatController {
    @ResponseBody//不使用该注解的话将走resolve view流程
    @RequestMapping("/what")
    public String hello() {
        return "What happen?";
    }

    @RequestMapping("/jsp")
    public String jspTest(){
        return "jsp";//找name为jsp的jsp页面
    }
}
