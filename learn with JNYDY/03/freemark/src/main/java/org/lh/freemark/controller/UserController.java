package org.lh.freemark.controller;

import org.lh.freemark.bean.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: UserController
 * @Description: TODO
 * @author: LH
 * @Date: 2020/7/13 20:13
 * @Version: 1.0
 **/
@Controller
public class UserController {
    @GetMapping("/getUser")
    public String user(Model model){
        List<User> userList = new ArrayList<>();
        for (int i = 0; i <10 ; i++) {
            User user = new User();
            user.setId((long) i);
            user.setAddress("address boy "+ i);
            user.setName("name " + i);
            userList.add(user);
        }
        model.addAttribute("userData", userList);
        return "user";
    }
}
