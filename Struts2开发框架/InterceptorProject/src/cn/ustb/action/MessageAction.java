package cn.ustb.action;

import com.opensymphony.xwork2.ActionSupport;

import cn.ustb.vo.News;

@SuppressWarnings("serial")
public class MessageAction extends ActionSupport {
	private News news = new News();
	
	public News getNews() {
		return news;
	}
	
	public void insert() {
		System.out.println(this.news);
		System.out.println("**************** MessageAction ****************");
	}
	
}
