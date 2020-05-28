package com.lh.aop.service;

import org.springframework.stereotype.Service;

/**
 * @ClassName: UserService
 * @Description: TODO
 * @author: LH
 * @Date: 2020/5/22 11:57
 * @Version: 1.0
 **/
@Service
public class UserService implements BaseService {
    @Override
    public void add(Integer a, Integer b) {
        System.out.println("我要学习Aop");
        System.out.println("....");
        System.out.println(a/b);
        System.out.println("...");
    }
}
