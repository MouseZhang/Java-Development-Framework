package cn.ustb.action;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;

import com.opensymphony.xwork2.ActionSupport;

import cn.ustb.factory.ServiceFactory;
import cn.ustb.pojo.Member;

@SuppressWarnings("serial")
@Namespace(value="/")
@Action(value="MemberAction")
public class MemberAction extends ActionSupport {
	private Member member = new Member();
	public Member getMember() {
		return member;
	}
	public void insert() {
		try {
			System.out.println(ServiceFactory.getIMemberServiceInstance().insert(this.member));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
