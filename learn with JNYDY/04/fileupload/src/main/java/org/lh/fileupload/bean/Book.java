package org.lh.fileupload.bean;

/**
 * @ClassName: Book
 * @Description: TODO
 * @author: LH
 * @Date: 2020/7/14 15:23
 * @Version: 1.0
 **/

public class Book {
    private String name;
    private Double price;

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
