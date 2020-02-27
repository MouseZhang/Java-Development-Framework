package cn.ustb.service;

import cn.ustb.pojo.Books;

import java.util.List;

public interface BooksService {

    public boolean insert(Books vo);

    public boolean update(Books vo);

    public boolean delete(int id);

    public Books get(int id);

    public List<Books> list();

}
