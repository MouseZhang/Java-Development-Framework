package cn.ustb;

import cn.ustb.pojo.Hello;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyTest {
    public static void main(String[] args) {
        // 获取Spring的上下文对象
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        // 现在的对象都在Spring容器中了，使用的时候直接取出
        Hello hello = (Hello) context.getBean("hello");
        System.out.println(hello.toString());
    }
}
