package cn.ustb.service;

import java.util.Map;
import java.util.Set;

import cn.ustb.vo.Message;

public interface IMessageService {
	
	public boolean insert(Message vo) throws Exception;
	
	public boolean update(Message vo) throws Exception;
	
	public boolean delete(Set<Integer> ids) throws Exception;
	
	public Message get(int id) throws Exception;
	
	public Map<String, Object> list(String column, String keyWord, int currentPage, int lineSize) throws Exception;
}
