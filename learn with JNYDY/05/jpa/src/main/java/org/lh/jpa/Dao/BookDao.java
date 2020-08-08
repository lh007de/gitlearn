package org.lh.jpa.Dao;

import org.hibernate.annotations.Subselect;
import org.hibernate.mapping.Value;
import org.lh.jpa.bean.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.awt.geom.AffineTransform;
import java.util.List;

public interface BookDao extends JpaRepository<Book,Integer> {
    // 自定义查询
    Book findBookById(Integer id);

    List<Book> findBookByIdGreaterThan(Integer id);

    // 查询id最大的书
    @Query(value="select * from t_book where id = (select max(id) from t_book)",nativeQuery = true)
    Book getMaxIdBook();

    // 增加
    @Query(value="insert into t_book(name,author) values (?1,?2)",nativeQuery = true)
    @Modifying
    @Transactional
    Integer addBook(String name,String author);

    // 增加
    @Query(value="insert into t_book(name,author) values (:name ,:author)",nativeQuery = true)
    @Modifying
    @Transactional
    Integer addBook2(@Param("name") String name,@Param("author") String author);

}
