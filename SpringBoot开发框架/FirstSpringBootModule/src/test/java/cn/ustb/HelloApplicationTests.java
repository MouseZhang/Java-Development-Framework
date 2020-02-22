package cn.ustb;

import cn.ustb.pojo.Dog;
import cn.ustb.pojo.Person;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class HelloApplicationTests {

	@Autowired
	private Person person;

	@Autowired
	private Dog dog;

	@Test
	void contextLoads() {
		System.out.println(dog);
	}

}
