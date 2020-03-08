package cn.ustb.dao;

import cn.ustb.pojo.Blog;
import cn.ustb.utils.IDUtils;
import cn.ustb.utils.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.Date;

public class MyTest {

    @Test
    public void testAddBlog() {
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);
        Blog blog = new Blog();
        blog.setId(IDUtils.getId());
        blog.setTitle("MyBatis开发实战");
        blog.setAuthor("apache");
        blog.setCreateTime(new Date());
        blog.setViews(9999);
        mapper.addBlog(blog);
        blog.setId(IDUtils.getId());
        blog.setTitle("Java开发实战");
        mapper.addBlog(blog);
        blog.setId(IDUtils.getId());
        blog.setTitle("Oracle开发实战");
        mapper.addBlog(blog);
        sqlSession.close();
    }
}
