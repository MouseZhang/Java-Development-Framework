package cn.ustb.action;

import com.opensymphony.xwork2.ActionSupport;

import cn.ustb.vo.News;

@SuppressWarnings("serial")
public class NewsAction extends ActionSupport {
	private News news = new News(); // 目的是为了接收数据
	public News getNews() {
		return news;
	}
	public String insert() { // 负责信息的显示而后跳转到一个路径上
		System.out.println(this.news);
		return "news.show";
	}
	public String update() { // 修改操作但是不跳转
		System.out.println("******【修改新闻】" + this.news);
		return "news.insert";
	}
	public void list() {
		System.out.println("******【新闻列表】" + this.news);
	}
	public String delete() {
		System.out.println("******【删除新闻】" + this.news);
		return "news.insert";
	}
	
//	@Override
//	public void validate() {
//		System.out.println("****************** " + this.news);
//		System.out.println("****************** ");
//		if (this.news.getNid() == null) {
//			super.addFieldError("news.nid", super.getText("data.null", new String[] {"新闻编号"}));
//		}
//		if (this.news.getTitle() == null || "".equals(this.news.getTitle())) {
//			super.addFieldError("news.title", super.getText("data.null", new String[] {"新闻标题"}));
//		}
//		if (this.news.getContent() == null || "".equals(this.news.getContent())) {
//			super.addFieldError("news.content", super.getText("data.null", new String[] {"新闻内容"}));
//		}
//		if (this.news.getPubdate() == null || "".equals(this.news.getPubdate())) {
//			super.addFieldError("news.pubdate", super.getText("data.null", new String[] {"发布日期"}));
//		}
//	}
}
