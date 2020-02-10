package cn.ustb.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.stereotype.Service;

import cn.ustb.service.IMessageService;
import cn.ustb.vo.Message;
import cn.ustb.vo.Type;

@Service
public class MessageServiceImpl implements IMessageService {

	@Override
	public boolean insert(Message vo) throws Exception {
		System.out.println("*******【新增消息】" + vo);
		return true;
	}

	@Override
	public boolean update(Message vo) throws Exception {
		System.out.println("*******【修改消息】" + vo);
		return true;
	}

	@Override
	public boolean delete(Set<Integer> ids) throws Exception {
		System.out.println("*******【删除消息】" + ids);
		return true;
	}

	@Override
	public Message get(int id) throws Exception {
		System.out.println("*******【根据ID查询数据】");
		Message msg = new Message();
		msg.setMid(10009);
		msg.setTitle("USTB");
		msg.setPubdate(new Date());
		msg.setPrice(9999.99);
		Type type = new Type();
//		type.setTitle("北京科技大学");
		msg.setType(type);
		return msg;
	}

	@Override
	public Map<String, Object> list(String column, String keyWord, int currentPage, int lineSize) throws Exception {
		System.out.println("*******【分页查询数据】");
		Map<String, Object> map = new HashMap<String, Object>();
		List<Message> all = new ArrayList<Message>();
		for (int i = (currentPage - 1) * lineSize; i < currentPage * lineSize; i++) {
			Message msg = new Message();
			msg.setMid(100 + i);
			msg.setTitle("USTB - " + i);
			msg.setPubdate(new Date());
			msg.setPrice(10000.0 + i);
			Type type = new Type();
//			type.setTitle("北京科技大学 - " + i);
//			msg.setType(type);
			all.add(msg);
		}
		map.put("allMessages", all);
		map.put("messageCount", 999);
		return map;
	}

}
