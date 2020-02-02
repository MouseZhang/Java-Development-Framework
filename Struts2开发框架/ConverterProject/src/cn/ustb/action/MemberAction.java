package cn.ustb.action;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

import cn.ustb.vo.Member;

@SuppressWarnings("serial")
public class MemberAction extends ActionSupport {
	private List<Member> allMembers;
	public void setAllMembers(List<Member> allMembers) {
		this.allMembers = allMembers;
	}
	public List<Member> getAllMembers() {
		return allMembers;
	}
	public void insert() {
		System.out.println("********** 【接收Member数据】 **********");
		System.out.println(this.allMembers);
	}
}
