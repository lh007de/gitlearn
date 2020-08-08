package org.lh.springboot02.controller;

import org.lh.springboot02.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName: MyController
 * @Description: TODO
 * @author: LH
 * @Date: 2020/7/13 16:57
 * @Version: 1.0
 **/
@RestController
public class MyController {

    @Autowired
    Book book;

    @GetMapping("/hello")
    public String hello(){

        return book.toString();
    }
}
