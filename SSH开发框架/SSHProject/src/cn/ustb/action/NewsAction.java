package cn.ustb.action;

import java.util.HashSet;
import java.util.Set;

import javax.annotation.Resource;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.springframework.stereotype.Repository;

import com.opensymphony.xwork2.ActionSupport;

import cn.ustb.pojo.News;
import cn.ustb.service.INewsService;

@SuppressWarnings("serial")
@ParentPackage(value="root")
@Namespace(value="/pages/news")
@Action(value="NewsAction")
@Repository
public class NewsAction extends ActionSupport {

	@Resource
	private INewsService newsService;
	
	private News news = new News();

	public News getNews() {
		return news;
	}

	// URL地址：http://localhost:8080/SSHProject/pages/news/NewsAction!insert.action?news.title=世界，你好&news.content=今天天气很好
	public void insert() {
		System.out.println("【新闻数据增加】数据：" + this.news);
		try {
			System.out.println("【新闻数据增加】业务调用结果：" + this.newsService.insert(this.news));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	// URL地址：http://localhost:8080/SSHProject/pages/news/NewsAction!update.action?news.title=世界，你好&news.content=今天天气很好&news.nid=8
	public void update() {
		System.out.println("【新闻数据修改】数据：" + this.news);
		try {
			System.out.println("【新闻数据修改】业务调用结果：" + this.newsService.update(this.news));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	// URL地址：http://localhost:8080/SSHProject/pages/news/NewsAction!delete.action?ids=4|5
	public void delete() {
		String ids = ServletActionContext.getRequest().getParameter("ids");
		System.out.println("【新闻数据删除】数据：" + ids);
		try {
			Set<Integer> set = new HashSet<Integer>();
			String[] result = ids.split("\\|");
			for (int i = 0; i < result.length; i++) {
				set.add(Integer.parseInt(result[i]));
			}
			System.out.println("【新闻数据增加】业务调用结果：" + this.newsService.delete(set));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	// URL地址：http://localhost:8080/SSHProject/pages/news/NewsAction!get.action?news.nid=16
	public void get() {
		System.out.println("【新闻数据取得】数据：" + this.news);
		try {
			System.out.println("【新闻数据取得】业务调用结果：" + this.newsService.get(this.news.getNid()));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	// URL地址：http://localhost:8080/SSHProject/pages/news/NewsAction!list.action
	public void list() {
		System.out.println("【新闻数据查询】数据：" + this.news);
		try {
			System.out.println("【新闻数据查询】业务调用结果：" + this.newsService.list());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	// URL地址：http://localhost:8080/SSHProject/pages/news/NewsAction!listSplit.action
	public void listSplit() {
		System.out.println("【新闻数据分页查询】数据：" + this.news);
		try {
			System.out.println("【新闻数据分页查询】业务调用结果：" + this.newsService.list("title", "", 4, 5));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
