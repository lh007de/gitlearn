package org.lh.thymeleaf.bean;

/**
 * @ClassName: Book
 * @Description: TODO
 * @author: LH
 * @Date: 2020/7/14 9:17
 * @Version: 1.0
 **/
public class Book {
    private Integer id;
    private String name;
    private String author;
    private Double price;

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", price=" + price +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
