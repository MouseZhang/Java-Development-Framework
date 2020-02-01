package cn.ustb.action;

import com.opensymphony.xwork2.ActionSupport;

import cn.ustb.vo.News;

@SuppressWarnings("serial")
public class NewsAction extends ActionSupport {
	private News news = new News(); // 目的是为了接收数据
	public News getNews() {
		return news;
	}
	public String insert() { // 增加操作但是不跳转
		System.out.println("******【增加新闻】" + this.news);
		return null;
	}
	public void update() { // 修改操作但是不跳转
		System.out.println("******【修改新闻】" + this.news);
	}
	public void list() {
		System.out.println("******【新闻列表】" + this.news);
	}
	public void delete() {
		System.out.println("******【删除新闻】" + this.news);
	}
}
