package cn.ustb.controller;

import cn.ustb.pojo.Books;
import cn.ustb.service.BooksService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/books")
public class BooksController {

    @Autowired
    private BooksService booksService;

    private static Logger logger = Logger.getLogger(BooksController.class);

    /**
     * 查询全部的书籍，并返回书籍展示页面
     * @param model 视图解析器
     * @return 跳转到书籍展示页
     */
    @RequestMapping("/allBooks")
    public String list(Model model) {
        List<Books> allBooks = booksService.getAllBooks();
        logger.info("【书籍列表查询】的结果：" + allBooks);
        model.addAttribute("books", allBooks);
        return "list";
    }

    /**
     * 实现新增前的页面跳转，跳转到新增页面
     * @return 跳转到书籍新增页
     */
    @RequestMapping("/insertPre")
    public String insertPre() {
        return "insert";
    }

    /**
     * 实现新增实际的操作
     * @param books 书籍信息
     * @return 重定向/books/allBooks请求，进入查询书籍列表页
     */
    @RequestMapping("/insertBooks")
    public String insertBooks(Books books) {
        logger.info("insertBooks ==> " + books);
        boolean flag = booksService.addBook(books);
        logger.info("【新增书籍】的结果：" + flag);
        return "redirect:/books/allBooks";
    }

    /**
     * 实现修改前的页面跳转，跳转到修改页面
     * @return 跳转到书籍修改页
     */
    @RequestMapping("/updatePre")
    public String updatePre(int id, Model model) {
        Books books = booksService.getBookById(id);
        model.addAttribute("book", books);
        return "update";
    }

    /**
     * 实现修改实际的操作
     * @param books 书籍信息
     * @return 重定向/books/allBooks请求，进入查询书籍列表页
     */
    @RequestMapping("/updateBooks")
    public String updateBooks(Books books) {
        logger.info("updateBooks ==> " + books);
        boolean flag = booksService.updateBook(books);
        logger.info("【修改书籍】的结果：" + flag);
        return "redirect:/books/allBooks";
    }

    /**
     * 实现删除实际的操作
     * @param id 待删除书籍的ID
     * @return 重定向/books/allBooks请求，进入查询书籍列表页
     */
    @RequestMapping("/deleteBooks/{bookID}")
    public String deleteBooks(@PathVariable("bookID") int id) {
        logger.info("deleteBooks ID ==> " + id);
        boolean flag = booksService.deleteBook(id);
        logger.info("【删除书籍】的结果：" + flag);
        return "redirect:/books/allBooks";
    }


    /**
     * 模糊查询书籍的操作
     * @param bkName 模糊查询的字段
     * @param model 视图解析器
     * @return 跳转到书籍展示页
     */
    @RequestMapping("/searchBooks")
    public String searchBooks(String bkName, Model model) {
        List<Books> books = booksService.getBookByName(bkName);
        if (CollectionUtils.isEmpty(books)) {
            model.addAttribute("error", "未查询到书籍！");
        } else {
            logger.info("searchBooks ==> " + books);
            List<Books> allBooks = new ArrayList<Books>();
            allBooks.addAll(books);
            logger.info("【书籍列表查询】的结果：" + allBooks);
            model.addAttribute("books", allBooks);
        }
        return "list";
    }

}
