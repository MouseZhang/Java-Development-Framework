package cn.ustb.action;

import com.opensymphony.xwork2.ActionSupport;

import cn.ustb.vo.News;

@SuppressWarnings("serial")
public class NewsAction extends ActionSupport {
	private String insertRule = "news.nid:int|news.title:string|news.content:string|news.pubdate:string";
	private String updateRule = "news.nid:int|news.title:string|news.content:string|news.pubdate:string";
	private String deleteRule = "news.nid:int";
	private News news = new News();
	
	public News getNews() {
		return news;
	}
	
	public String insert() {
		System.out.println("【新闻增加】" + this.news);
		return "news.show";
	}
	
	public String update() {
		System.out.println("【新闻修改】" + this.news);
		return "news.show";
	}
	
	public String delete() {
		System.out.println("【新闻删除】" + this.news);
		return "news.show";
	}
	
}
