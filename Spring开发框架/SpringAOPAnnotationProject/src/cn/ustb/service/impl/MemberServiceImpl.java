package cn.ustb.service.impl;

import org.springframework.stereotype.Service;

import cn.ustb.service.IMemberService;
import cn.ustb.vo.Member;

/**
 * AOP是面向方面的编程，在实际的开发中，AOP都会工作在业务层
 * @author MouseZhang
 *
 */

@Service
public class MemberServiceImpl implements IMemberService {
	public boolean insert() {
		// 1、执行日志处理
		// 2、调用数据层操作
		// 3、进行事务的提交处理
		// 4、进行数据库的关闭操作
		return false;
	}

	@Override
	public boolean insert(Member vo) {
//		throw new NullPointerException("闲的没事，抛着玩儿");
		System.out.println("【数据层调用】member = " + vo);
		return false;
	}
	
}
