package org.lh.jpa;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.lh.jpa.Dao.BookDao;
import org.lh.jpa.bean.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = JpaApplication.class)
class JpaApplicationTests {
    @Autowired
    BookDao bookDao;
    @Test
    void contextLoads() {
        Book s = new Book();
        s.setAuthor("s1");
        s.setName("name1"+ LocalDateTime.now().getDayOfMonth());
        bookDao.save(s);
    }

    @Test
    void updateTest(){
        Book book = new Book();
        book.setId(1);
        book.setName("update name");
        book.setAuthor("update author");
        bookDao.saveAndFlush(book);
    }

    @Test
    void getTest(){
        Optional<Book> book = bookDao.findById(2);
        System.out.println(book.get());
        List<Book> all = bookDao.findAll();
        System.out.println(all);
    }

    @Test
    void getPageTest(){
        Pageable pageable = PageRequest.of(2, 2);
        Page<Book> page = bookDao.findAll(pageable);
        System.out.println("总记录数"+page.getTotalElements());
        System.out.println("当前页记录数"+page.getNumberOfElements());
        System.out.println("每页记录数"+page.getSize());
        System.out.println("总页数"+page.getTotalPages());
        System.out.println("查询结果"+page.getContent());
        System.out.println("是否为首页"+page.isFirst());
        System.out.println("是否为尾页"+page.isLast());



    }

    @Test
    void myDefineQuery(){
        Book book = bookDao.findBookById(5);
        System.out.println(book);
        List<Book> list = bookDao.findBookByIdGreaterThan(2);
        System.out.println(list);
        System.out.println("---------------");
        Book maxIdBook = bookDao.getMaxIdBook();
        System.out.println(maxIdBook);
    }

    @Test
    void defineUpdate(){
        bookDao.addBook("小鸟", "刀郎");
        bookDao.addBook2("春天", "小草");
    }

}
