package cn.ustb.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.ustb.dao.INewsDAO;
import cn.ustb.pojo.News;
import cn.ustb.service.INewsService;

@Service
public class NewsServiceImpl implements INewsService {
	
	@Resource
	private INewsDAO newDAO;

	@Override
	public boolean insert(News vo) throws Exception {
		return this.newDAO.doCreate(vo);
	}

	@Override
	public boolean update(News vo) throws Exception {
		return this.newDAO.doUpdate(vo);
	}

	@Override
	public boolean delete(Set<Integer> ids) throws Exception {
		if (ids.size() == 0) {
			return false;
		}
		return this.newDAO.doRemoveBatch(ids);
	}
	
	@Override
	public News get(int id) throws Exception {
		return this.newDAO.findById(id);
	}

	@Override
	public List<News> list() throws Exception {
		return this.newDAO.findAll();
	}

	@Override
	public Map<String, Object> list(String column, String keyWord, int currentPage, int lineSize) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("allNews", this.newDAO.findAllSplit(column, keyWord, currentPage, lineSize));
		map.put("newsCount", this.newDAO.getAllCount(column, keyWord));
		return map;
	}

}
