package org.lh.exception.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName: HelloController
 * @Description: TODO
 * @author: LH
 * @Date: 2020/7/14 15:41
 * @Version: 1.0
 **/
@RestController
public class HelloController {

    @GetMapping("/hello")
    public String hello(){
        /*自定义404 500对应的页面 更具状态码去找对应的页面  这种是静态异常的处理方式*/
        int i =1/0;
        return "hello";
    }
}
