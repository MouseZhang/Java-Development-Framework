package cn.ustb.factory;

import cn.ustb.service.IMemberService;
import cn.ustb.service.impl.MemberServiceImpl;

public class ServiceFactory {
	public static IMemberService getIMemberServiceInstance() {
		return new MemberServiceImpl();
	}
}
