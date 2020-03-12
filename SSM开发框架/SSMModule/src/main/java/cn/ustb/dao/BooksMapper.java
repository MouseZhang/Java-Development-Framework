package cn.ustb.dao;

import cn.ustb.pojo.Books;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BooksMapper {

    public boolean addBook(Books vo);

    public boolean updateBook(Books vo);

    public boolean deleteBook(@Param("id") Integer id);

    public Books getBookById(@Param("id") Integer id);

    public List<Books> getAllBooks();

}
