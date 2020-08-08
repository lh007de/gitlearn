package org.lh.thymeleaf.controller;

import org.lh.thymeleaf.bean.Book;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: BookController
 * @Description: TODO
 * @author: LH
 * @Date: 2020/7/14 9:20
 * @Version: 1.0
 **/
@Controller
public class BookController {
    @GetMapping("/book")
    public String book(Model model){
        List<Book> bookList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Book book = new Book();
            book.setId(i);
            book.setAuthor("author" + i);
            book.setName("name"+i);
            book.setPrice((double) i);
            bookList.add(book);
        }
        model.addAttribute("books",bookList);
        return "book";
    }
}
