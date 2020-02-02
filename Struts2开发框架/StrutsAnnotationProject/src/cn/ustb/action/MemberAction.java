package cn.ustb.action;

import java.io.File;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Actions;
import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.InterceptorRefs;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.validator.annotations.RegexFieldValidator;
import com.opensymphony.xwork2.validator.annotations.RequiredStringValidator;
import com.opensymphony.xwork2.validator.annotations.Validations;

import cn.ustb.vo.Member;

@SuppressWarnings("serial")
@ParentPackage(value="root") // 继承了root包
@Namespace(value="/pages/back/admin/member") // 定义了自己的命名空间
@Action(value="MemberAction")
//@InterceptorRef(value="ustbStack") 配置单个拦截器
@InterceptorRefs(value= {@InterceptorRef("timer"),
		@InterceptorRef("defaultStack"),
		@InterceptorRef(value="fileUpload",params= {"maximumSize","20000000",
		"allowedTypes","image/bmp,image/jpg,image/jpeg,image/png,image/gif"})}) // 配置拦截器组
@Results(value= {
		@Result(name="success", location="/pages/back/admin/member/insert.jsp",type="redirect"),
		@Result(name="list", location="/pages/back/admin/member/list.jsp")
})
//@Validations(requiredStrings={@RequiredStringValidator(fieldName="member.name",message="姓名不允许为空！")})
@Validations(
		requiredStrings={
			@RequiredStringValidator(
				fieldName="member.name",
				key="string.validate.error.msg"),
			@RequiredStringValidator(
					fieldName="member.mid",
					key="string.validate.error.msg"),
			@RequiredStringValidator(
					fieldName="member.email",
					key="string.validate.error.msg")},
		regexFields={
			@RegexFieldValidator(
				fieldName="member.mid",
				expression="\\d+",
				key="number.validate.error.msg"),
			@RegexFieldValidator(
				fieldName="member.email",
				expression="\\w+@\\w+\\.\\w+",
				message="Email格式错误！")})
public class MemberAction extends ActionSupport {
	private Member member = new Member();
	private File photo;
	public Member getMember() {
		return member;
	}
	public void setPhoto(File photo) {
		this.photo = photo;
	}
	public String insert() {
		System.out.println("********* 【MemberAction】数据增加" + this.photo);
		return ActionSupport.SUCCESS;
	}
	
	@Actions(value= {@Action("Update"),@Action("Hello")})
	public void update() {
		System.out.println("********* 【MemberAction】数据修改。");
	}
	// 浏览器地址：http://localhost:8080/StrutsAnnotationProject/pages/back/admin/member/MemberAction!test.action?member.email=12
	public void test() {
		System.out.println("********* 【MemberAction】数据验证。");
	}
}
