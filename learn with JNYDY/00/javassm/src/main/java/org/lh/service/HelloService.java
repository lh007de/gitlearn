package org.lh.service;

import org.springframework.stereotype.Service;

/**
 * @ClassName: HelloService
 * @Description: TODO
 * @author: LH
 * @Date: 2020/7/13 13:34
 * @Version: 1.0
 **/
@Service
public class HelloService {
    public String sayHello() {
        return "hello";
    }
}
