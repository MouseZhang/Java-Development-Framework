package cn.ustb.pojo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component // 等价于 <bean id="user" class="cn.ustb.pojo.User"/>
@Scope("singleton") // 配置作用域
public class User {
    // 等价于 <property name="name" value="SMITH"/>
    // @Value("SMITH")也能放在Setter上
    @Value("SMITH")
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /*
        @Component衍生注解补充：（都是组件，是等价的）
        dao：@Repository
        service：@Service
        controller：@Controller
        这四个注解都是代表将某个类注册到Spring，装配Bean
     */

}
