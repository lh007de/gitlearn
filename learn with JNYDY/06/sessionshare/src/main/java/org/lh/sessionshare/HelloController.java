package org.lh.sessionshare;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

/**
 * @ClassName: HelloController
 * @Description: TODO
 * @author: LH
 * @Date: 2020/8/7 11:11
 * @Version: 1.0
 **/
@RestController
public class HelloController {

    @Value("${server.port}")
    private String port;

    @GetMapping("/set")
    public String set(HttpSession session){
        session.setAttribute("name","lh");
        return port;
    }

    @GetMapping("/get")
    public String get(HttpSession session){
        System.out.println("session id" + session.getId());
        System.out.println("session 创建时间"+ session.getCreationTime());
        System.out.println("session 上次登录时间"+ session.getLastAccessedTime());
        System.out.println("session "+ session.getMaxInactiveInterval());
        return (String)session.getAttribute("name") + port;
    }


}
