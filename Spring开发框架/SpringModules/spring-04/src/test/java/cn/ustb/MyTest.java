package cn.ustb;

import cn.ustb.pojo.Student;
import cn.ustb.pojo.User;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyTest {
    public static void main(String[] args) {
        // 通过Setter方式的依赖注入：
        /*
            Student{name='SMITH',
            address=Address{address='北京'},
            books=[红楼梦, 西游记, 三国演义],
            hobbies=[编程, 唱歌, 跳舞],
            cards={身份证=110110111110, 银行卡=880880888800},
            games=[LOL, COC, BOB],
            wife='null',
            info={jdbc.username=root, jdbc.password=root123}}
         */
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        Student student = (Student) context.getBean("student");
        System.out.println(student);
    }

    @Test
    public void test() {
        ApplicationContext context = new ClassPathXmlApplicationContext("userbean.xml");
        User user = context.getBean("userc", User.class);
        System.out.println(user);
    }
}
