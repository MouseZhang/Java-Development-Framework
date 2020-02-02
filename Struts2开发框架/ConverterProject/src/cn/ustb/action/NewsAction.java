package cn.ustb.action;

import java.util.Set;

import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class NewsAction extends ActionSupport {
	private Set<Integer> ids;
	private Set<String> nids;
	public void setIds(Set<Integer> ids) {
		this.ids = ids;
	}
	public void setNids(Set<String> nids) {
		this.nids = nids;
	}
	public void insert() {
		// 浏览器输入地址：http://localhost:8080/ConverterProject/NewsAction!insert.action?ids=1|2|3|4|5
		System.out.println("【要删除的Int数据】：" + this.ids);
		// 浏览器输入地址：http://localhost:8080/ConverterProject/NewsAction!insert.action?ids=1|2|3|4|5&nids=hello|nihao|world|shijie|ustb
		System.out.println("【要删除的String数据】：" + this.nids);
	}
}
