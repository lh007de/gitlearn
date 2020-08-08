package org.lh.jdbctemplate;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.lh.jdbctemplate.bean.User;
import org.lh.jdbctemplate.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class JdbctemplateApplicationTests {
	@Autowired
	UserService userService;
	@Test
	public void contextLoads() {
		User user = new User();
		user.setName("lh");
		user.setAge(26);
		int count = userService.addUser(user);
		System.out.println(count);
	}

	@Test
	public void getUserTest(){
		List<User> allUsers = userService.getAllUsers();
		System.out.println(allUsers);
	}

}
