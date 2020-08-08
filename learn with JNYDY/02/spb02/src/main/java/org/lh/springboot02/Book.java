package org.lh.springboot02;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * @ClassName: Book
 * @Description: TODO
 * @author: LH
 * @Date: 2020/7/13 17:06
 * @Version: 1.0
 **/
@Component
@PropertySource("classpath:book.properties")
@ConfigurationProperties(prefix = "book")
public class Book {
//    @Value("${book.age}")
    private int age;
//    @Value("${book.author}")
    private String author;
//    @Value("${book.name}")
    private String name;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", author='" + author + '\'' +
                '}';
    }
}
