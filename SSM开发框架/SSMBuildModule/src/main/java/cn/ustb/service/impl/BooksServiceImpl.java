package cn.ustb.service.impl;

import cn.ustb.dao.BooksMapper;
import cn.ustb.pojo.Books;
import cn.ustb.service.BooksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BooksServiceImpl implements BooksService {

    private BooksMapper booksMapper;

    @Autowired
    public void setBooksMapper(BooksMapper booksMapper) {
        this.booksMapper = booksMapper;
    }

    public boolean addBook(Books vo) {
        return booksMapper.addBook(vo);
    }

    public boolean updateBook(Books vo) {
        return booksMapper.updateBook(vo);
    }

    public boolean deleteBook(Integer id) {
        return booksMapper.deleteBook(id);
    }

    public Books getBookById(Integer id) {
        return booksMapper.getBookById(id);
    }

    public List<Books> getAllBooks() {
        return booksMapper.getAllBooks();
    }

    public List<Books> getBookByName(String bookName) {
        return booksMapper.getBookByName(bookName);
    }

}
