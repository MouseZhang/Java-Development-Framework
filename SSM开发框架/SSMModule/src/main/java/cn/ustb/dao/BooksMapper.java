package cn.ustb.dao;

import cn.ustb.pojo.Books;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BooksMapper {

    public boolean doCreate(Books vo);

    public boolean doUpdate(Books vo);

    public boolean doRemove(@Param("bookID") Integer id);

    public Books findById(@Param("bookID") Integer id);

    public List<Books> findAll();

}
