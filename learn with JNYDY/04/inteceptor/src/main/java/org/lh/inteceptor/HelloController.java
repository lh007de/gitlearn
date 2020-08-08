package org.lh.inteceptor;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName: HelloController
 * @Description: TODO
 * @author: LH
 * @Date: 2020/7/17 14:57
 * @Version: 1.0
 **/
@RestController
public class HelloController {
    @GetMapping("/hello")
    public String hello(){
        return "hello";
    }
}
