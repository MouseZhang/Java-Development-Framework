package cn.ustb.dao;

import cn.ustb.pojo.Blog;

import java.util.List;
import java.util.Map;

public interface BlogMapper {

    public boolean addBlog(Blog blog);

    public List<Blog> queryBlog(Map<String, Object> map);

    public List<Blog> queryBlogChoose(Map<String, Object> map);

    public boolean updateBlog(Map<String, Object> map);

    public List<Blog> queryBlogForeach(Map<String, Object> map);
}
