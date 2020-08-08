package org.lh.json.controller;

import org.lh.json.bean.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: UserController
 * @Description: TODO
 * @author: LH
 * @Date: 2020/7/14 10:15
 * @Version: 1.0
 **/
@RestController
public class UserController {
    @GetMapping("/user")
    public List<User> getUsers(){
        List<User> users = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            User user = new User();
            user.setId(i);
            user.setName("name"+i);
            user.setAddress("address"+i);
            user.setDateTime(LocalDateTime.now());
            users.add(user);
        }
        return users;
    }
}
