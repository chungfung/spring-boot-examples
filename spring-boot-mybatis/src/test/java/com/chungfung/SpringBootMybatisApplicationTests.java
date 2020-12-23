package com.chungfung;

import com.chungfung.model.UserEnum;
import com.chungfung.model.UserVO;
import com.chungfung.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootMybatisApplicationTests {

	@Autowired
	private UserService userService;

	@Test
	public void userTest() {
		List<UserVO> list = userService.getNameUserEnum(UserEnum.Man,new HashMap<>());
		list.stream().forEach(System.out::println);
	}

}
