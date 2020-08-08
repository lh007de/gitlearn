package org.javaboy.controller;

import org.javaboy.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author 江南一点雨
 * @Site www.javaboy.org 2019-07-15 22:00
 */
@RestController
public class HelloController {
    @Autowired
    HelloService helloService;

    @GetMapping(value = "/hello",produces = "text/html;charset=utf-8")
    public String hello() {
        return helloService.sayHello();
    }
}
