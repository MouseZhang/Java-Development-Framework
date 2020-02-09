package cn.ustb.service;

import java.util.List;
import java.util.Map;
import java.util.Set;

import cn.ustb.pojo.News;

public interface INewsService {
	public boolean insert(News vo) throws Exception;
	
	public boolean update(News vo) throws Exception;
	
	public News get(int id) throws Exception;
	
	public boolean delete(Set<Integer> ids) throws Exception;
	
	public List<News> list() throws Exception;
	
	public Map<String, Object> list(String column, String keyWord, int currentPage, int lineSize) throws Exception;
	
}
