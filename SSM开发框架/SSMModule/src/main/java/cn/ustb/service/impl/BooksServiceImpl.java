package cn.ustb.service.impl;

import cn.ustb.dao.BooksMapper;
import cn.ustb.pojo.Books;
import cn.ustb.service.BooksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BooksServiceImpl implements BooksService {

    @Autowired
    private BooksMapper booksMapper;


    public boolean insert(Books vo) {
        return booksMapper.doCreate(vo);
    }

    public boolean update(Books vo) {
        return booksMapper.doUpdate(vo);
    }

    public boolean delete(int id) {
        return booksMapper.doRemove(id);
    }

    public Books get(int id) {
        return booksMapper.findById(id);
    }

    public List<Books> list() {
        return booksMapper.findAll();
    }

}
