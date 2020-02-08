package cn.ustb.service;

import cn.ustb.vo.Member;

/**
 * AOP是面向方面的编程，在实际的开发中，AOP都会工作在业务层
 * @author MouseZhang
 *
 */

public interface IMemberService {
	public boolean insert(Member vo);
}
