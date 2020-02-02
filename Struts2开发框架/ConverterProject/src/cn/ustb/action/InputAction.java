package cn.ustb.action;

import java.util.Arrays;
import java.util.Set;

import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class InputAction extends ActionSupport {
	private String[] inst; // 定义一个数字用于参数接收
//	private Integer[] gid;
	private Set<Integer> gid; // 利用set集合接收
	public void setInst(String[] inst) {
		this.inst = inst;
	}
//	public void setGid(Integer[] gid) {
//		this.gid = gid;
//	}
	public void setGid(Set<Integer> gid) {
		this.gid = gid;
	}
	public void insert() {
		System.out.println("【参数内容】：" + Arrays.toString(this.inst));
	}
	public void update() {
		System.out.println("【参数内容】：" + this.gid);
	}
}
