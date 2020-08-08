package org.lh.controller;

import org.lh.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName: HelloController
 * @Description: TODO
 * @author: LH
 * @Date: 2020/7/13 13:19
 * @Version: 1.0
 **/
@RestController
public class HelloController {

    @Autowired
    HelloService helloService;

    @GetMapping("/hello")
    public String sayHi(){
        return helloService.sayHello();
    }
}
