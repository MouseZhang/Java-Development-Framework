package cn.ustb;

import cn.ustb.service.UserService;
import cn.ustb.service.impl.UserServiceImpl;
import org.apache.shiro.util.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringbootshiroApplicationTests {

    @Autowired
    private UserService userService;

    @Test
    void contextLoads() {
        Assert.notNull(userService.getUserByName("SMITH"));
    }

}
