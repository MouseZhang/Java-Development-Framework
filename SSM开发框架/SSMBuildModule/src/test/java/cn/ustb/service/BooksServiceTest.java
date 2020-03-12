package cn.ustb.service;

import cn.ustb.pojo.Books;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class BooksServiceTest {

    @Test
    public void getAllBooks() {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        BooksService booksService = context.getBean("booksServiceImpl", BooksService.class);
        List<Books> allBooks = booksService.getAllBooks();
        for (Books books : allBooks) {
            System.out.println(books);
        }
    }

}
