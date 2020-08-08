package org.lh.mybatis.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.lh.mybatis.bean.User;

import java.util.List;

/**
 * @ClassName: UserMapper
 * @Description: TODO
 * @author: LH
 * @Date: 2020/7/24 15:52
 * @Version: 1.0
 **/
//@Mapper
public interface UserMapper {
    List<User> getAllUsers();
}
