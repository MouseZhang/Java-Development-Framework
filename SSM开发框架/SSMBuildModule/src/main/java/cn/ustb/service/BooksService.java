package cn.ustb.service;

import cn.ustb.pojo.Books;

import java.util.List;

public interface BooksService {

    public boolean addBook(Books vo);

    public boolean updateBook(Books vo);

    public boolean deleteBook(Integer id);

    public Books getBookById(Integer id);

    public List<Books> getAllBooks();

    public List<Books> getBookByName(String bookName);

}
