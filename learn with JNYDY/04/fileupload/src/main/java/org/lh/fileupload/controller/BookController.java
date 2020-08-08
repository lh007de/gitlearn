package org.lh.fileupload.controller;

import org.lh.fileupload.bean.Author;
import org.lh.fileupload.bean.Book;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName: BookController
 * @Description: TODO
 * @author: LH
 * @Date: 2020/7/14 15:31
 * @Version: 1.0
 **/
@RestController
public class BookController {
    @PostMapping("/book")
    public void addBook(@ModelAttribute("b") Book book,@ModelAttribute("a") Author author){
        System.out.println(book);
        System.out.println(author);
    }
}
